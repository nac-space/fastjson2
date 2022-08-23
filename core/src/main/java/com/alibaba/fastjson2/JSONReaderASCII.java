package com.alibaba.fastjson2;

import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.JDKUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static com.alibaba.fastjson2.JSONFactory.*;
import static com.alibaba.fastjson2.JSONFactory.Utils.*;

final class JSONReaderASCII
        extends JSONReaderUTF8 {
    final String str;

    JSONReaderASCII(Context ctx, String str, byte[] bytes, int offset, int length) {
        super(ctx, bytes, offset, length);
        this.str = str;
        nameAscii = true;
    }

    @Override
    public void next() {
        if (offset >= end) {
            ch = EOI;
            return;
        }

        ch = (char) (bytes[offset] & 0xFF);
        while (ch <= ' ' && ((1L << ch) & SPACE) != 0) {
            offset++;
            if (offset >= end) {
                ch = EOI;
                return;
            }
            ch = (char) (bytes[offset] & 0xFF);
        }
        offset++;
    }

    @Override
    public boolean nextIfMatch(char ch) {
        if (this.ch != ch) {
            return false;
        }
        if (ch == ',') {
            this.comma = true;
        }

        if (offset >= end) {
            this.ch = EOI;
            return true;
        }

        this.ch = (char) (bytes[offset] & 0xFF);
        while (this.ch <= ' ' && ((1L << this.ch) & SPACE) != 0) {
            offset++;
            if (offset >= end) {
                this.ch = EOI;
                return true;
            }
            this.ch = (char) (bytes[offset] & 0xFF);
        }
        offset++;
        return true;
    }

    @Override
    public boolean nextIfEmptyString() {
        final char first = this.ch;
        if ((first != '"' && first != '\'') || offset >= end || bytes[offset] != first) {
            return false;
        }

        offset++;
        this.ch = offset == end ? EOI : (char) bytes[offset];

        while (this.ch <= ' ' && ((1L << this.ch) & SPACE) != 0) {
            offset++;
            if (offset >= end) {
                this.ch = EOI;
                return true;
            }
            this.ch = (char) bytes[offset];
        }

        if (ch == ',') {
            this.comma = true;
            ch = (char) bytes[offset++];

            while (ch <= ' ' && ((1L << ch) & SPACE) != 0) {
                if (offset >= end) {
                    ch = EOI;
                } else {
                    ch = (char) bytes[offset++];
                }
            }
        }

        if (offset >= end) {
            this.ch = EOI;
            return true;
        }

        this.ch = (char) bytes[offset];
        while (this.ch <= ' ' && ((1L << this.ch) & SPACE) != 0) {
            offset++;
            if (offset >= end) {
                this.ch = EOI;
                return true;
            }
            this.ch = (char) bytes[offset];
        }
        offset++;
        return true;
    }

    @Override
    public long readFieldNameHashCode() {
        if (ch != '"' && ch != '\'') {
            if ((context.features & Feature.AllowUnQuotedFieldNames.mask) != 0) {
                return readFieldNameHashCodeUnquote();
            }
            if (ch == '}' || isNull()) {
                return -1;
            }
            throw new JSONException(info("illegal character " + ch));
        }

        final char quote = ch;

        this.stringValue = null;
        this.nameEscape = false;
        int offset = this.nameBegin = this.offset;

        long nameValue = 0;
        if (MIXED_HASH_ALGORITHM && offset + 9 < end) {
            byte c0, c1, c2, c3, c4, c5, c6, c7;

            if ((c0 = bytes[offset]) == quote) {
                nameValue = 0;
            } else if ((c1 = bytes[offset + 1]) == quote && c0 != 0 && c0 != '\\' && c0 <= 0xFF) {
                nameValue = c0;
                this.nameLength = 1;
                this.nameEnd = offset + 1;
                offset += 2;
            } else if ((c2 = bytes[offset + 2]) == quote && c0 != 0
                    && c0 != '\\' && c1 != '\\'
                    && c0 <= 0xFF && c1 <= 0xFF
            ) {
                nameValue = (c0 << 8)
                        + (c1 & 0xFF);
                this.nameLength = 2;
                this.nameEnd = offset + 2;
                offset += 3;
            } else if ((c3 = bytes[offset + 3]) == quote && c0 != 0
                    && c0 != '\\' && c1 != '\\' && c2 != '\\'
                    && c0 <= 0xFF && c1 <= 0xFF && c2 <= 0xFF
            ) {
                nameValue
                        = (c0 << 16)
                        + ((c1 & 0xFF) << 8)
                        + c2;
                this.nameLength = 3;
                this.nameEnd = offset + 3;
                offset += 4;
            } else if ((c4 = bytes[offset + 4]) == quote && c0 != 0
                    && c0 != '\\' && c1 != '\\' && c2 != '\\' && c3 != '\\'
                    && c0 <= 0xFF && c1 <= 0xFF && c2 <= 0xFF && c3 <= 0xFF
            ) {
                nameValue
                        = (c0 << 24)
                        + ((c1 & 0xFF) << 16)
                        + (c2 << 8)
                        + c3;
                this.nameLength = 4;
                this.nameEnd = offset + 4;
                offset += 5;
            } else if ((c5 = bytes[offset + 5]) == quote && c0 != 0
                    && c0 != '\\' && c1 != '\\' && c2 != '\\' && c3 != '\\' && c4 != '\\'
                    && c0 <= 0xFF && c1 <= 0xFF && c2 <= 0xFF && c3 <= 0xFF && c4 <= 0xFF
            ) {
                nameValue
                        = (((long) c0) << 32)
                        + ((c1 & 0xFFL) << 24)
                        + ((c2 & 0xFFL) << 16)
                        + ((c3 & 0xFFL) << 8)
                        + (c4 & 0xFFL);
                this.nameLength = 5;
                this.nameEnd = offset + 5;
                offset += 6;
            } else if ((c6 = bytes[offset + 6]) == quote && c0 != 0
                    && c0 != '\\' && c1 != '\\' && c2 != '\\' && c3 != '\\' && c4 != '\\' && c5 != '\\'
                    && c0 <= 0xFF && c1 <= 0xFF && c2 <= 0xFF && c3 <= 0xFF && c4 <= 0xFF && c5 <= 0xFF
            ) {
                nameValue
                        = (((long) c0) << 40)
                        + ((c1 & 0xFFL) << 32)
                        + ((c2 & 0xFFL) << 24)
                        + ((c3 & 0xFFL) << 16)
                        + ((c4 & 0xFFL) << 8)
                        + (c5 & 0xFFL);
                this.nameLength = 6;
                this.nameEnd = offset + 6;
                offset += 7;
            } else if ((c7 = bytes[offset + 7]) == quote && c0 != 0
                    && c0 != '\\' && c1 != '\\' && c2 != '\\' && c3 != '\\' && c4 != '\\' && c5 != '\\' && c6 != '\\'
                    && c0 <= 0xFF && c1 <= 0xFF && c2 <= 0xFF && c3 <= 0xFF && c4 <= 0xFF && c5 <= 0xFF && c6 <= 0xFF
            ) {
                nameValue
                        = (((long) c0) << 48)
                        + ((c1 & 0xFFL) << 40)
                        + ((c2 & 0xFFL) << 32)
                        + ((c3 & 0xFFL) << 24)
                        + ((c4 & 0xFFL) << 16)
                        + ((c5 & 0xFFL) << 8)
                        + (c6 & 0xFFL);
                this.nameLength = 7;
                this.nameEnd = offset + 7;
                offset += 8;
            } else if (bytes[offset + 8] == quote && c0 != 0
                    && c0 != '\\' && c1 != '\\' && c2 != '\\' && c3 != '\\' && c4 != '\\' && c5 != '\\' && c6 != '\\' && c7 != '\\'
                    && c0 <= 0xFF && c1 <= 0xFF && c2 <= 0xFF && c3 <= 0xFF && c4 <= 0xFF && c5 <= 0xFF && c6 <= 0xFF && c7 <= 0xFF
            ) {
                nameValue
                        = (((long) c0) << 56)
                        + ((c1 & 0xFFL) << 48)
                        + ((c2 & 0xFFL) << 40)
                        + ((c3 & 0xFFL) << 32)
                        + ((c4 & 0xFFL) << 24)
                        + ((c5 & 0xFFL) << 16)
                        + ((c6 & 0xFFL) << 8)
                        + (c7 & 0xFFL);
                this.nameLength = 8;
                this.nameEnd = offset + 8;
                offset += 9;
            }
        }

        if (MIXED_HASH_ALGORITHM && nameValue == 0) {
            for (int i = 0; offset < end; offset++, i++) {
                int c = bytes[offset];

                if (c == quote) {
                    if (i == 0) {
                        offset = this.nameBegin;
                        break;
                    }

                    this.nameLength = i;
                    this.nameEnd = offset;
                    offset++;
                    break;
                }

                if (c == '\\') {
                    nameEscape = true;
                    c = bytes[++offset];
                    switch (c) {
                        case 'u': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            byte c3 = bytes[++offset];
                            byte c4 = bytes[++offset];
                            c = char4(c1, c2, c3, c4);
                            break;
                        }
                        case 'x': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            c = char2(c1, c2);
                            break;
                        }
                        case '\\':
                        case '"':
                        default:
                            c = char1(c);
                            break;
                    }
                }

                if (c > 0xFF || i >= 8 || (i == 0 && c == 0)) {
                    nameValue = 0;
                    offset = this.nameBegin;
                    break;
                }

                if (i == 0) {
                    nameValue = (byte) c;
                } else {
                    nameValue <<= 8;
                    nameValue += (c & 0xFF);
                }
            }
        }

        long hashCode;
        if (nameValue != 0) {
            hashCode = nameValue;
        } else {
            hashCode = Fnv.MAGIC_HASH_CODE;
            for (int i = 0; ; ++i) {
                int c = bytes[offset];
                if (c == '\\') {
                    nameEscape = true;
                    c = bytes[++offset];
                    switch (c) {
                        case 'u': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            byte c3 = bytes[++offset];
                            byte c4 = bytes[++offset];
                            c = char4(c1, c2, c3, c4);
                            break;
                        }
                        case 'x': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            c = char2(c1, c2);
                            break;
                        }
                        case '\\':
                        case '"':
                        default:
                            c = char1(c);
                            break;
                    }
                    offset++;
                    hashCode ^= c;
                    hashCode *= Fnv.MAGIC_PRIME;
                    continue;
                }

                if (c == quote) {
                    this.nameLength = i;
                    this.nameEnd = offset;
                    offset++;
                    break;
                }

                offset++;
                hashCode ^= (c & 0xFF);
                hashCode *= Fnv.MAGIC_PRIME;
            }
        }

        byte c;
        if (offset < end) {
            c = bytes[offset];

            while (c <= ' ' && ((1L << c) & SPACE) != 0) {
                offset++;
                c = bytes[offset];
            }
        } else {
            c = EOI;
        }

        if (c != ':') {
            throw new JSONException(info("expect ':', but " + c));
        }

        offset++;
        if (offset == end) {
            c = EOI;
        } else {
            c = bytes[offset];
        }

        while (c <= ' ' && ((1L << c) & SPACE) != 0) {
            offset++;
            c = bytes[offset];
        }

        this.offset = offset + 1;
        this.ch = (char) c;

        return hashCode;
    }

    @Override
    public long readValueHashCode() {
        if (ch != '"' && ch != '\'') {
            return -1;
        }

        final char quote = ch;

        this.nameEscape = false;
        int offset = this.nameBegin = this.offset;

        long nameValue = 0;
        if (MIXED_HASH_ALGORITHM) {
            for (int i = 0; offset < end; offset++, i++) {
                int c = bytes[offset];

                if (c == quote) {
                    if (i == 0) {
                        nameValue = 0;
                        offset = this.nameBegin;
                        break;
                    }

                    this.nameLength = i;
                    this.nameEnd = offset;
                    offset++;
                    break;
                }

                if (c == '\\') {
                    nameEscape = true;
                    c = bytes[++offset];
                    switch (c) {
                        case 'u': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            byte c3 = bytes[++offset];
                            byte c4 = bytes[++offset];
                            c = char4(c1, c2, c3, c4);
                            break;
                        }
                        case 'x': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            c = char2(c1, c2);
                            break;
                        }
                        case '\\':
                        case '"':
                        default:
                            c = char1(c);
                            break;
                    }
                }

                if (c > 0xFF || i >= 8 || (i == 0 && c == 0)) {
                    nameValue = 0;
                    offset = this.nameBegin;
                    break;
                }

                if (i == 0) {
                    nameValue = (byte) c;
                } else {
                    nameValue <<= 8;
                    nameValue += (c & 0xFF);
                }
            }
        }

        long hashCode;
        if (nameValue != 0) {
            hashCode = nameValue;
        } else {
            hashCode = Fnv.MAGIC_HASH_CODE;
            for (int i = 0; ; ++i) {
                int c = bytes[offset];
                if (c == '\\') {
                    nameEscape = true;
                    c = bytes[++offset];
                    switch (c) {
                        case 'u': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            byte c3 = bytes[++offset];
                            byte c4 = bytes[++offset];
                            c = char4(c1, c2, c3, c4);
                            break;
                        }
                        case 'x': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            c = char2(c1, c2);
                            break;
                        }
                        case '\\':
                        case '"':
                        default:
                            c = char1(c);
                            break;
                    }
                    offset++;
                    hashCode ^= c;
                    hashCode *= Fnv.MAGIC_PRIME;
                    continue;
                }

                if (c == '"') {
                    this.nameLength = i;
                    this.nameEnd = offset;
                    this.stringValue = null;
                    offset++;
                    break;
                }

                offset++;
                hashCode ^= c < 0 ? (c & 0xFF) : c;
                hashCode *= Fnv.MAGIC_PRIME;
            }
        }

        byte c;
        if (offset == end) {
            c = EOI;
        } else {
            c = bytes[offset];
        }

        while (c <= ' ' && ((1L << c) & SPACE) != 0) {
            offset++;
            c = bytes[offset];
        }

        if (c == ',') {
            this.comma = true;
            offset++;
            if (offset == end) {
                c = EOI;
            } else {
                c = bytes[offset];
            }

            while (c <= ' ' && ((1L << c) & SPACE) != 0) {
                offset++;
                c = bytes[offset];
            }
        }

        this.offset = offset + 1;
        this.ch = (char) c;

        return hashCode;
    }

    @Override
    public long getNameHashCodeLCase() {
        int offset = nameBegin;

        if (MIXED_HASH_ALGORITHM) {
            long nameValue = 0;
            for (int i = 0; offset < end; offset++) {
                int c = bytes[offset];

                if (c == '\\') {
                    c = bytes[++offset];
                    switch (c) {
                        case 'u': {
                            int c1 = bytes[++offset];
                            int c2 = bytes[++offset];
                            int c3 = bytes[++offset];
                            int c4 = bytes[++offset];
                            c = char4(c1, c2, c3, c4);
                            break;
                        }
                        case 'x': {
                            int c1 = bytes[++offset];
                            int c2 = bytes[++offset];
                            c = char2(c1, c2);
                            break;
                        }
                        case '\\':
                        case '"':
                        default:
                            c = char1(c);
                            break;
                    }
                } else if (c == '"') {
                    break;
                }

                if (c > 0xFF || c < 0 || i >= 8 || (i == 0 && c == 0)) {
                    nameValue = 0;
                    offset = this.nameBegin;
                    break;
                }

                if (c == '_' || c == '-') {
                    byte c1 = bytes[offset + 1];
                    if (c1 != '"' && c1 != '\'' && c1 != c) {
                        continue;
                    }
                }

                if (c >= 'A' && c <= 'Z') {
                    c = (char) (c + 32);
                }

                if (i == 0) {
                    nameValue = (byte) c;
                } else {
                    nameValue <<= 8;
                    nameValue += (c & 0xFF);
                }
                ++i;
            }

            if (nameValue != 0) {
                return nameValue;
            }
        }

        long hashCode = Fnv.MAGIC_HASH_CODE;
        for (; offset < end; ) {
            int c = bytes[offset];

            if (c == '\\') {
                c = bytes[++offset];
                switch (c) {
                    case 'u': {
                        int c1 = bytes[++offset];
                        int c2 = bytes[++offset];
                        int c3 = bytes[++offset];
                        int c4 = bytes[++offset];
                        c = char4(c1, c2, c3, c4);
                        break;
                    }
                    case 'x': {
                        int c1 = bytes[++offset];
                        int c2 = bytes[++offset];
                        c = char2(c1, c2);
                        break;
                    }
                    case '\\':
                    case '"':
                    default:
                        c = char1(c);
                        break;
                }
            } else if (c == '"') {
                break;
            }

            offset++;
            if (c == '_' || c == '-') {
                byte c1 = bytes[offset];
                if (c1 != '"' && c1 != '\'' && c1 != c) {
                    continue;
                }
            }

            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 32);
            }
            hashCode ^= c < 0 ? (c & 0xFF) : c;
            hashCode *= Fnv.MAGIC_PRIME;
        }

        return hashCode;
    }

    @Override
    public String getFieldName() {
        int length = nameEnd - nameBegin;
        if (!nameEscape) {
            if (this.str != null) {
                return this.str.substring(nameBegin, nameEnd);
            } else {
                return new String(bytes, nameBegin, length, StandardCharsets.US_ASCII);
            }
        }

        if (JDKUtils.JVM_VERSION > 8) {
            byte[] chars = new byte[nameLength];

            int offset = nameBegin;
            forStmt:
            for (int i = 0; offset < nameEnd; ++i) {
                byte b = bytes[offset];

                if (b == '\\') {
                    b = bytes[++offset];
                    switch (b) {
                        case 'u': {
                            int c1 = bytes[++offset];
                            int c2 = bytes[++offset];
                            int c3 = bytes[++offset];
                            int c4 = bytes[++offset];
                            char c = char4(c1, c2, c3, c4);
                            if (c > 0xFF) {
                                chars = null;
                                break forStmt;
                            }
                            b = (byte) c;
                            break;
                        }
                        case 'x': {
                            int c1 = bytes[++offset];
                            int c2 = bytes[++offset];
                            char c = char2(c1, c2);
                            if (c > 0xFF) {
                                chars = null;
                                break forStmt;
                            }
                            b = (byte) c;
                            break;
                        }
                        case '\\':
                        case '"':
                        case '.':
                        case '-':
                        case '+':
                        case '*':
                        case '/':
                        case '>':
                        case '<':
                        case '=':
                        case '@':
                        case ':':
                            break;
                        default:
                            b = (byte) char1(b);
                            break;
                    }
                } else if (b == '"') {
                    break;
                }
                chars[i] = b;
                offset++;
            }

            if (chars != null) {
                if (JDKUtils.UNSAFE_ASCII_CREATOR != null) {
                    return JDKUtils.UNSAFE_ASCII_CREATOR.apply(chars);
                }

                return new String(chars, 0, chars.length, StandardCharsets.US_ASCII);
            }
        }

        char[] chars = new char[nameLength];

        int offset = nameBegin;
        for (int i = 0; offset < nameEnd; ++i) {
            char c = (char) bytes[offset];

            if (c == '\\') {
                c = (char) bytes[++offset];
                switch (c) {
                    case 'u': {
                        int c1 = bytes[++offset];
                        int c2 = bytes[++offset];
                        int c3 = bytes[++offset];
                        int c4 = bytes[++offset];
                        c = char4(c1, c2, c3, c4);
                        break;
                    }
                    case 'x': {
                        int c1 = bytes[++offset];
                        int c2 = bytes[++offset];
                        c = char2(c1, c2);
                        break;
                    }
                    case '.':
                    case '-':
                    case '+':
                    case '*':
                    case '/':
                    case '>':
                    case '<':
                    case '=':
                    case '@':
                        break;
                    default:
                        c = char1(c);
                        break;
                }
            } else if (c == '"') {
                break;
            }
            chars[i] = c;
            offset++;
        }

        return new String(chars);
    }

    @Override
    public String readFieldName() {
        if (ch != '"' && ch != '\'') {
            return null;
        }

        final char quote = ch;

        this.nameEscape = false;
        int offset = this.nameBegin = this.offset;
        for (int i = 0; ; ++i) {
            int c = bytes[offset];
            if (c == '\\') {
                nameEscape = true;
                c = bytes[++offset];
                switch (c) {
                    case 'u': {
                        offset += 4;
                        break;
                    }
                    case 'x': {
                        offset += 2;
                        break;
                    }
                    default:
                        // skip
                        break;
                }
                offset++;
                continue;
            }

            if (c == quote) {
                this.nameLength = i;
                this.nameEnd = offset;
                offset++;
                c = bytes[offset];

                while (c <= ' ' && ((1L << c) & SPACE) != 0) {
                    offset++;
                    c = bytes[offset];
                }
                if (c != ':') {
                    throw new JSONException("syntax error : " + offset);
                }

                offset++;
                c = bytes[offset];

                while (c <= ' ' && ((1L << c) & SPACE) != 0) {
                    offset++;
                    c = bytes[offset];
                }

                this.offset = offset + 1;
                this.ch = (char) c;
                break;
            }

            offset++;
        }

        if (!nameEscape) {
            long nameValue0 = -1, nameValue1 = -1;
            int length = nameEnd - nameBegin;
            switch (length) {
                case 1:
                    nameValue0 = bytes[nameBegin];
                    break;
                case 2:
                    nameValue0
                            = (bytes[nameBegin] << 8)
                            + (bytes[nameBegin + 1] & 0xFF);
                    break;
                case 3:
                    nameValue0
                            = (bytes[nameBegin] << 16)
                            + ((bytes[nameBegin + 1] & 0xFF) << 8)
                            + (bytes[nameBegin + 2] & 0xFF);
                    break;
                case 4:
                    nameValue0
                            = (bytes[nameBegin] << 24)
                            + ((bytes[nameBegin + 1] & 0xFF) << 16)
                            + ((bytes[nameBegin + 2] & 0xFF) << 8)
                            + (bytes[nameBegin + 3] & 0xFF);
                    break;
                case 5:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 32)
                            + ((bytes[nameBegin + 1] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 8)
                            + (bytes[nameBegin + 4] & 0xFFL);
                    break;
                case 6:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 40)
                            + ((bytes[nameBegin + 1] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 8)
                            + (bytes[nameBegin + 5] & 0xFFL);
                    break;
                case 7:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 48)
                            + ((bytes[nameBegin + 1] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 8)
                            + (bytes[nameBegin + 6] & 0xFFL);
                    break;
                case 8:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 56)
                            + ((bytes[nameBegin + 1] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 6] & 0xFFL) << 8)
                            + (bytes[nameBegin + 7] & 0xFFL);
                    break;
                case 9:
                    nameValue0 = bytes[nameBegin + 0];
                    nameValue1
                            = (((long) bytes[nameBegin] + 1) << 56)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 6] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 7] & 0xFFL) << 8)
                            + (bytes[nameBegin + 8] & 0xFFL);
                    break;
                case 10:
                    nameValue0
                            = (bytes[nameBegin] << 8)
                            + (bytes[nameBegin + 1]);
                    nameValue1
                            = (((long) bytes[nameBegin + 2]) << 56)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 6] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 7] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 8] & 0xFFL) << 8)
                            + (bytes[nameBegin + 9] & 0xFFL);
                    break;
                case 11:
                    nameValue0
                            = (bytes[nameBegin] << 16)
                            + (bytes[nameBegin + 1] << 8)
                            + (bytes[nameBegin + 2]);
                    nameValue1
                            = (((long) bytes[nameBegin + 3]) << 56)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 6] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 7] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 8] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 9] & 0xFFL) << 8)
                            + (bytes[nameBegin + 10] & 0xFFL);
                    break;
                case 12:
                    nameValue0
                            = (bytes[nameBegin] << 24)
                            + (bytes[nameBegin + 1] << 16)
                            + (bytes[nameBegin + 2] << 8)
                            + (bytes[nameBegin + 3]);
                    nameValue1
                            = (((long) bytes[nameBegin + 4]) << 56)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 6] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 7] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 8] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 9] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 10] & 0xFFL) << 8)
                            + (bytes[nameBegin + 11] & 0xFFL);
                    break;
                case 13:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 32)
                            + (((long) bytes[nameBegin + 1]) << 24)
                            + (((long) bytes[nameBegin + 2]) << 16)
                            + (((long) bytes[nameBegin + 3]) << 8)
                            + ((long) bytes[nameBegin + 4]);
                    nameValue1
                            = (((long) bytes[nameBegin + 5]) << 56)
                            + ((bytes[nameBegin + 6] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 7] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 8] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 9] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 10] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 11] & 0xFFL) << 8)
                            + (bytes[nameBegin + 12] & 0xFFL);
                    break;
                case 14:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 40)
                            + ((bytes[nameBegin + 1] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 8)
                            + (bytes[nameBegin + 5] & 0xFFL);
                    nameValue1
                            = (((long) bytes[nameBegin + 6]) << 56)
                            + ((bytes[nameBegin + 7] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 8] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 9] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 10] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 11] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 12] & 0xFFL) << 8)
                            + (bytes[nameBegin + 13] & 0xFFL);
                    break;
                case 15:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 48)
                            + ((bytes[nameBegin + 1] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 8)
                            + (bytes[nameBegin + 6] & 0xFFL);
                    nameValue1
                            = (((long) bytes[nameBegin + 7]) << 56)
                            + ((bytes[nameBegin + 8] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 9] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 10] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 11] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 12] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 13] & 0xFFL) << 8)
                            + (bytes[nameBegin + 14] & 0xFFL);
                    break;
                case 16:
                    nameValue0
                            = (((long) bytes[nameBegin]) << 56)
                            + ((bytes[nameBegin + 1] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 2] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 3] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 4] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 5] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 6] & 0xFFL) << 8)
                            + (bytes[nameBegin + 7] & 0xFFL);
                    nameValue1
                            = (((long) bytes[nameBegin + 8]) << 56)
                            + ((bytes[nameBegin + 9] & 0xFFL) << 48)
                            + ((bytes[nameBegin + 10] & 0xFFL) << 40)
                            + ((bytes[nameBegin + 11] & 0xFFL) << 32)
                            + ((bytes[nameBegin + 12] & 0xFFL) << 24)
                            + ((bytes[nameBegin + 13] & 0xFFL) << 16)
                            + ((bytes[nameBegin + 14] & 0xFFL) << 8)
                            + (bytes[nameBegin + 15] & 0xFFL);
                    break;
                default:
                    break;
            }

            if (nameValue0 != -1) {
                if (nameValue1 != -1) {
                    int indexMask = ((int) nameValue1) & (NAME_CACHE2.length - 1);
                    JSONFactory.NameCacheEntry2 entry = NAME_CACHE2[indexMask];
                    if (entry == null) {
                        if (STRING_CREATOR_JDK8 == null && !STRING_CREATOR_ERROR) {
                            try {
                                STRING_CREATOR_JDK8 = JDKUtils.getStringCreatorJDK8();
                            } catch (Throwable e) {
                                STRING_CREATOR_ERROR = true;
                            }
                        }

                        char[] chars = new char[length];
                        for (int i = 0; i < length; ++i) {
                            chars[i] = (char) (bytes[nameBegin + i] & 0xFF);
                        }

                        String name;
                        if (STRING_CREATOR_JDK8 != null) {
                            name = STRING_CREATOR_JDK8.apply(chars, Boolean.TRUE);
                        } else {
                            name = new String(chars);
                        }

                        NAME_CACHE2[indexMask] = new JSONFactory.NameCacheEntry2(name, nameValue0, nameValue1);
                        return name;
                    } else if (entry.value0 == nameValue0 && entry.value1 == nameValue1) {
                        return entry.name;
                    }
                } else {
                    int indexMask = ((int) nameValue0) & (NAME_CACHE.length - 1);
                    JSONFactory.NameCacheEntry entry = NAME_CACHE[indexMask];
                    if (entry == null) {
                        if (STRING_CREATOR_JDK8 == null && !STRING_CREATOR_ERROR) {
                            try {
                                STRING_CREATOR_JDK8 = JDKUtils.getStringCreatorJDK8();
                            } catch (Throwable e) {
                                STRING_CREATOR_ERROR = true;
                            }
                        }

                        char[] chars = new char[length];
                        for (int i = 0; i < length; ++i) {
                            chars[i] = (char) (bytes[nameBegin + i] & 0xFF);
                        }

                        String name;
                        if (STRING_CREATOR_JDK8 != null) {
                            name = STRING_CREATOR_JDK8.apply(chars, Boolean.TRUE);
                        } else {
                            name = new String(chars);
                        }

                        NAME_CACHE[indexMask] = new JSONFactory.NameCacheEntry(name, nameValue0);
                        return name;
                    } else if (entry.value == nameValue0) {
                        return entry.name;
                    }
                }
            }
        }

        return getFieldName();
    }

    @Override
    protected void readString0() {
        char quote = this.ch;
        int start = offset;
        int valueLength;
        valueEscape = false;

        _for:
        for (int i = 0; ; ++i) {
            int c = bytes[offset];
            if (c == '\\') {
                valueEscape = true;
                c = bytes[++offset];
                switch (c) {
                    case 'u': {
                        offset += 4;
                        break;
                    }
                    case 'x': {
                        offset += 2;
                        break;
                    }
                    default:
                        break;
                }
                offset++;
                continue;
            }

            if (c == quote) {
                valueLength = i;
                break _for;
            }
            offset++;
        }

        String str;
        if (valueEscape) {
            char[] chars = new char[valueLength];
            offset = start;
            for (int i = 0; ; ++i) {
                char c = (char) bytes[offset];
                if (c == '\\') {
                    c = (char) (bytes[++offset]);
                    switch (c) {
                        case 'u': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            byte c3 = bytes[++offset];
                            byte c4 = bytes[++offset];
                            c = char4(c1, c2, c3, c4);
                            break;
                        }
                        case 'x': {
                            byte c1 = bytes[++offset];
                            byte c2 = bytes[++offset];
                            c = char2(c1, c2);
                            break;
                        }
                        case '\\':
                        case '"':
                            break;
                        default:
                            c = char1(c);
                            break;
                    }
                } else if (c == '"') {
                    break;
                }
                chars[i] = c;
                offset++;
            }

            str = new String(chars);
        } else {
            if (JDKUtils.JVM_VERSION >= 9) {
                if (STRING_CREATOR_JDK11 == null && !STRING_CREATOR_ERROR) {
                    try {
                        STRING_CREATOR_JDK11 = JDKUtils.getStringCreatorJDK11();
                    } catch (Throwable e) {
                        STRING_CREATOR_ERROR = true;
                    }
                }

                if (STRING_CREATOR_JDK11 == null) {
                    str = new String(bytes, start, this.offset - start, StandardCharsets.US_ASCII);
                } else {
                    byte[] bytes = Arrays.copyOfRange(this.bytes, start, offset);
                    str = STRING_CREATOR_JDK11.apply(bytes);
                }
            } else {
                str = new String(bytes, start, this.offset - start, StandardCharsets.US_ASCII);
            }
        }

        int b = bytes[++offset];
        while (b <= ' ' && ((1L << b) & SPACE) != 0) {
            b = bytes[++offset];
        }

        if (b == ',') {
            this.comma = true;
            this.offset = offset + 1;
            next();
        } else {
            this.offset = offset + 1;
            this.ch = (char) b;
        }

        stringValue = str;
    }

    @Override
    public String readString() {
        if (ch == '"' || ch == '\'') {
            final byte quote = (byte) ch;
            final byte slash = (byte) '\\';

            int offset = this.offset;
            int start = offset;
            int valueLength;
            boolean valueEscape = false;

            _for:
            {
                int i = 0;

                // vector optimize
                boolean quoted = false;
                while (offset + 8 <= end) {
                    byte c0 = bytes[offset];
                    byte c1 = bytes[offset + 1];
                    byte c2 = bytes[offset + 2];
                    byte c3 = bytes[offset + 3];
                    byte c4 = bytes[offset + 4];
                    byte c5 = bytes[offset + 5];
                    byte c6 = bytes[offset + 6];
                    byte c7 = bytes[offset + 7];
                    if (c0 == slash || c1 == slash || c2 == slash || c3 == slash || c4 == slash || c5 == slash || c6 == slash || c7 == slash) {
                        break;
                    }
                    if (c0 == quote || c1 == quote || c2 == quote || c3 == quote || c4 == quote || c5 == quote || c6 == quote || c7 == quote) {
                        quoted = true;
                        break;
                    }
                    offset += 8;
                    i += 8;
                }

                // vector optimize
                if (!quoted) {
                    while (offset + 4 <= end) {
                        byte c0 = bytes[offset];
                        byte c1 = bytes[offset + 1];
                        byte c2 = bytes[offset + 2];
                        byte c3 = bytes[offset + 3];
                        if (c0 == slash || c1 == slash || c2 == slash || c3 == slash) {
                            break;
                        }
                        if (c0 == quote || c1 == quote || c2 == quote || c3 == quote) {
                            break;
                        }
                        offset += 4;
                        i += 4;
                    }
                }

                for (; ; ++i) {
                    if (offset >= end) {
                        throw new JSONException("invalid escape character EOI");
                    }

                    byte c = bytes[offset];
                    if (c == slash) {
                        valueEscape = true;
                        c = bytes[++offset];
                        switch (c) {
                            case 'u': {
                                offset += 4;
                                break;
                            }
                            case 'x': {
                                offset += 2;
                                break;
                            }
                            default:
                                // skip
                                break;
                        }
                        offset++;
                        continue;
                    }

                    if (c == quote) {
                        valueLength = i;
                        break _for;
                    }
                    offset++;
                }
            }

            String str;
            if (valueEscape) {
                char[] chars = new char[valueLength];
                offset = start;
                for (int i = 0; ; ++i) {
                    char c = (char) bytes[offset];
                    if (c == '\\') {
                        c = (char) bytes[++offset];
                        switch (c) {
                            case 'u': {
                                char c1 = (char) this.bytes[++offset];
                                char c2 = (char) this.bytes[++offset];
                                char c3 = (char) this.bytes[++offset];
                                char c4 = (char) this.bytes[++offset];
                                c = char4(c1, c2, c3, c4);
                                break;
                            }
                            case 'x': {
                                char c1 = (char) this.bytes[++offset];
                                char c2 = (char) this.bytes[++offset];
                                c = char2(c1, c2);
                                break;
                            }
                            case '\\':
                            case '"':
                                break;
                            default:
                                c = char1(c);
                                break;
                        }
                    } else if (c == quote) {
                        break;
                    }
                    chars[i] = c;
                    offset++;
                }

                str = new String(chars);
            } else {
                if (this.str != null) {
                    str = this.str.substring(this.offset, offset);
                } else if (JDKUtils.JVM_VERSION == 11 && !STRING_CREATOR_ERROR) {
                    if (STRING_CREATOR_JDK11 == null) {
                        try {
                            STRING_CREATOR_JDK11 = JDKUtils.getStringCreatorJDK11();
                        } catch (Throwable e) {
                            STRING_CREATOR_ERROR = true;
                        }
                    }

                    if (STRING_CREATOR_JDK11 == null) {
                        str = new String(bytes, this.offset, offset - this.offset, StandardCharsets.US_ASCII);
                    } else {
                        byte[] bytes = Arrays.copyOfRange(this.bytes, this.offset, offset);
                        str = STRING_CREATOR_JDK11.apply(bytes);
                    }
                } else if (JDKUtils.JVM_VERSION > 8 && JDKUtils.UNSAFE_ASCII_CREATOR != null) {
                    byte[] bytes = Arrays.copyOfRange(this.bytes, this.offset, offset);
                    str = JDKUtils.UNSAFE_ASCII_CREATOR.apply(bytes);
                } else {
                    str = new String(bytes, this.offset, offset - this.offset, StandardCharsets.US_ASCII);
                }
            }

            if ((context.features & Feature.TrimString.mask) != 0) {
                str = str.trim();
            }

            if (offset + 1 == end) {
                this.offset = end;
                this.ch = EOI;
                return str;
            }

            byte b = bytes[++offset];
            while (b <= ' ' && ((1L << b) & SPACE) != 0) {
                b = bytes[++offset];
            }

            if (b == ',') {
                this.comma = true;
                this.offset = offset + 1;

                // inline next
                ch = (char) bytes[this.offset++];
                while (ch <= ' ' && ((1L << ch) & SPACE) != 0) {
                    if (this.offset >= end) {
                        ch = EOI;
                    } else {
                        ch = (char) bytes[this.offset++];
                    }
                }
            } else {
                this.offset = offset + 1;
                this.ch = (char) b;
            }

            return str;
        }

        switch (ch) {
            case '[':
                return toString(
                        readArray());
            case '{':
                return toString(
                        readObject());
            case '-':
            case '+':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                readNumber0();
                Number number = getNumber();
                return number.toString();
            case 't':
            case 'f':
                boolValue = readBoolValue();
                return boolValue ? "true" : "false";
            case 'n': {
                readNull();
                return null;
            }
            default:
                throw new JSONException("TODO : " + ch);
        }
    }
}
