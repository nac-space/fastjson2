## EishayParseBinary
| aliyun ecs spec | jdk version 	|	jsonb	|	fastjson2UTF8Bytes	|	hessian	|	javaSerialize |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	2675.408	|	1489.382 (55.67%)	|	355.608 (13.29%)	|	52.253 (1.95%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	3374.806	|	1545.422 (45.79%)	|	334.6 (9.91%)	|	53.918 (1.6%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	3780.839	|	1615.575 (42.73%)	|	332.009 (8.78%)	|	57.752 (1.53%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1737.086	|	1099.692 (63.31%)	|	294.444 (16.95%)	|	46.877 (2.7%) |
| ecs.g7.xlarge | jdk-11.0.19	|	2721.088	|	1219.212 (44.81%)	|	225.061 (8.27%)	|	49.75 (1.83%) |
| ecs.g7.xlarge | jdk-17.0.7	|	2978.325	|	1336.625 (44.88%)	|	257.531 (8.65%)	|	54.108 (1.82%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	1356.707	|	805.894 (59.4%)	|	194.563 (14.34%)	|	40.059 (2.95%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1865.068	|	1059.111 (56.79%)	|	213.985 (11.47%)	|	40.898 (2.19%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	2014.393	|	1061.48 (52.69%)	|	229.909 (11.41%)	|	41.594 (2.06%) |
| OrangePI5 | jdk1.8.0_371	|	983.412	|	588.589 (59.85%)	|	134.642 (13.69%)	|	26.401 (2.68%) |
| OrangePI5 | jdk-11.0.19	|	1278.773	|	671.359 (52.5%)	|	130.996 (10.24%)	|	25.848 (2.02%) |
| OrangePI5 | jdk-17.0.7	|	1379.213	|	694.25 (50.34%)	|	156.651 (11.36%)	|	29.553 (2.14%) |

## EishayParseBinaryArrayMapping
| aliyun ecs spec | jdk version 	|	jsonb	|	kryo	|	protobuf	|	fastjson2UTF8Bytes |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	4442.654	|	2281.041 (51.34%)	|	1524.777 (34.32%)	|	2272.602 (51.15%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	5084.585	|	2105.846 (41.42%)	|	1669.832 (32.84%)	|	2542.27 (50%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	5870.246	|	2261.314 (38.52%)	|	2022.071 (34.45%)	|	2817.527 (48%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	2619.733	|	1716.718 (65.53%)	|	1045.45 (39.91%)	|	1664.323 (63.53%) |
| ecs.g7.xlarge | jdk-11.0.19	|	3710.841	|	1630.425 (43.94%)	|	1302.412 (35.1%)	|	1928.752 (51.98%) |
| ecs.g7.xlarge | jdk-17.0.7	|	4410.789	|	1836.2 (41.63%)	|	1702.909 (38.61%)	|	2231.598 (50.59%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	2209.794	|	1242.221 (56.21%)	|	749.934 (33.94%)	|	1236.417 (55.95%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	2780.071	|	1361.626 (48.98%)	|	960.236 (34.54%)	|	1543.569 (55.52%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	2849.493	|	1439.197 (50.51%)	|	1147.054 (40.25%)	|	1565.692 (54.95%) |
| OrangePI5 | jdk1.8.0_371	|	1669.667	|	965.143 (57.8%)	|	674.502 (40.4%)	|	863.257 (51.7%) |
| OrangePI5 | jdk-11.0.19	|	1985.55	|	940.782 (47.38%)	|	712.588 (35.89%)	|	1008.038 (50.77%) |
| OrangePI5 | jdk-17.0.7	|	1971.077	|	995.204 (50.49%)	|	846.844 (42.96%)	|	1013.537 (51.42%) |

## EishayParseBinaryAutoType
| aliyun ecs spec | jdk version 	|	fastjson2JSONB	|	hessian	|	javaSerialize |
|-----|-----|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	2073.66	|	378.136 (18.24%)	|	54.302 (2.62%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	2381.55	|	344.034 (14.45%)	|	53.371 (2.24%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	2656.491	|	328.391 (12.36%)	|	58.669 (2.21%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1491.659	|	285.054 (19.11%)	|	46.09 (3.09%) |
| ecs.g7.xlarge | jdk-11.0.19	|	1939.912	|	266.509 (13.74%)	|	46.981 (2.42%) |
| ecs.g7.xlarge | jdk-17.0.7	|	2011.917	|	262.836 (13.06%)	|	53.658 (2.67%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	1136.818	|	216.429 (19.04%)	|	38.375 (3.38%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1481.965	|	217.012 (14.64%)	|	40.62 (2.74%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	1503.654	|	232.438 (15.46%)	|	41.483 (2.76%) |
| OrangePI5 | jdk1.8.0_371	|	628.352	|	133.951 (21.32%)	|	26.504 (4.22%) |
| OrangePI5 | jdk-11.0.19	|	849.948	|	132.14 (15.55%)	|	27.071 (3.19%) |
| OrangePI5 | jdk-17.0.7	|	843.149	|	153.501 (18.21%)	|	29.153 (3.46%) |

## EishayParseString
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1621.642	|	1318.558 (81.31%)	|	658.749 (40.62%)	|	511.125 (31.52%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1566.153	|	1120.536 (71.55%)	|	614.191 (39.22%)	|	538.069 (34.36%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1651.937	|	1603.032 (97.04%)	|	653.524 (39.56%)	|	539.974 (32.69%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1228.732	|	977.168 (79.53%)	|	529.411 (43.09%)	|	426.092 (34.68%) |
| ecs.g7.xlarge | jdk-11.0.19	|	1231.726	|	898.568 (72.95%)	|	468.142 (38.01%)	|	407.976 (33.12%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1233.256	|	1247.705 (101.17%)	|	506.806 (41.09%)	|	440.958 (35.76%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	905.57	|	730.718 (80.69%)	|	364.425 (40.24%)	|	353.498 (39.04%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1058.371	|	824.498 (77.9%)	|	388.054 (36.67%)	|	383.066 (36.19%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	1079.957	|	1086.87 (100.64%)	|	391.753 (36.27%)	|	383.359 (35.5%) |
| OrangePI5 | jdk1.8.0_371	|	658.789	|	557.644 (84.65%)	|	262.431 (39.84%)	|	218.434 (33.16%) |
| OrangePI5 | jdk-11.0.19	|	675.092	|	567.707 (84.09%)	|	261.703 (38.77%)	|	225.041 (33.33%) |
| OrangePI5 | jdk-17.0.7	|	692.677	|	802.211 (115.81%)	|	270.996 (39.12%)	|	224.178 (32.36%) |

## EishayParseStringPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1265.629	|	317.257 (25.07%)	|	584.118 (46.15%)	|	495.042 (39.11%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1149.394	|	306.862 (26.7%)	|	566.207 (49.26%)	|	493.596 (42.94%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1240.21	|	356.468 (28.74%)	|	562.466 (45.35%)	|	489.855 (39.5%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	963.682	|	271.246 (28.15%)	|	455.074 (47.22%)	|	409.351 (42.48%) |
| ecs.g7.xlarge | jdk-11.0.19	|	896.51	|	240.085 (26.78%)	|	422.612 (47.14%)	|	409.115 (45.63%) |
| ecs.g7.xlarge | jdk-17.0.7	|	954.571	|	303.324 (31.78%)	|	431.163 (45.17%)	|	421.307 (44.14%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	699.142	|	201.504 (28.82%)	|	311.221 (44.51%)	|	324.626 (46.43%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	772.312	|	240.396 (31.13%)	|	355.535 (46.04%)	|	348.749 (45.16%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	784.044	|	261.972 (33.41%)	|	357.179 (45.56%)	|	356.599 (45.48%) |
| OrangePI5 | jdk1.8.0_371	|	521.999	|	155.232 (29.74%)	|	240.878 (46.15%)	|	202.117 (38.72%) |
| OrangePI5 | jdk-11.0.19	|	523.165	|	160.572 (30.69%)	|	246.524 (47.12%)	|	211.465 (40.42%) |
| OrangePI5 | jdk-17.0.7	|	533.042	|	185.311 (34.76%)	|	250.14 (46.93%)	|	208.133 (39.05%) |

## EishayParseTreeString
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1202.042	|	657.264 (54.68%)	|	732.443 (60.93%)	|	390.091 (32.45%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1081.43	|	550.246 (50.88%)	|	617.104 (57.06%)	|	373.732 (34.56%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1281.704	|	717.846 (56.01%)	|	655.606 (51.15%)	|	367.278 (28.66%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	988.049	|	486.845 (49.27%)	|	544.864 (55.15%)	|	337.434 (34.15%) |
| ecs.g7.xlarge | jdk-11.0.19	|	834.317	|	392.647 (47.06%)	|	456.077 (54.66%)	|	317.371 (38.04%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1059.564	|	563.777 (53.21%)	|	514.542 (48.56%)	|	312.85 (29.53%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	568.553	|	294.953 (51.88%)	|	282.663 (49.72%)	|	258.463 (45.46%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	740.065	|	368.274 (49.76%)	|	391.67 (52.92%)	|	294.599 (39.81%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	742.456	|	388.579 (52.34%)	|	369.548 (49.77%)	|	300.448 (40.47%) |
| OrangePI5 | jdk1.8.0_371	|	438.136	|	216.497 (49.41%)	|	233.052 (53.19%)	|	176.791 (40.35%) |
| OrangePI5 | jdk-11.0.19	|	477.147	|	238.305 (49.94%)	|	240.754 (50.46%)	|	185.335 (38.84%) |
| OrangePI5 | jdk-17.0.7	|	485.692	|	286.487 (58.99%)	|	260.127 (53.56%)	|	178.733 (36.8%) |

## EishayParseTreeStringPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	997.589	|	571.402 (57.28%)	|	637.905 (63.94%)	|	371.117 (37.2%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	905.197	|	469.754 (51.9%)	|	555.434 (61.36%)	|	354.03 (39.11%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1034.418	|	622.572 (60.19%)	|	591.818 (57.21%)	|	347.354 (33.58%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	778.509	|	454.214 (58.34%)	|	506.838 (65.1%)	|	317.747 (40.81%) |
| ecs.g7.xlarge | jdk-11.0.19	|	703.461	|	344.93 (49.03%)	|	427.458 (60.76%)	|	307.868 (43.76%) |
| ecs.g7.xlarge | jdk-17.0.7	|	818.577	|	490.77 (59.95%)	|	471.29 (57.57%)	|	294.418 (35.97%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	498.184	|	267.267 (53.65%)	|	264.952 (53.18%)	|	243.532 (48.88%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	620.401	|	322.124 (51.92%)	|	334.001 (53.84%)	|	281.603 (45.39%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	626.961	|	348.886 (55.65%)	|	333.246 (53.15%)	|	280.027 (44.66%) |
| OrangePI5 | jdk1.8.0_371	|	384.14	|	205.844 (53.59%)	|	224.636 (58.48%)	|	167.332 (43.56%) |
| OrangePI5 | jdk-11.0.19	|	404.412	|	190.107 (47.01%)	|	228.966 (56.62%)	|	177.179 (43.81%) |
| OrangePI5 | jdk-17.0.7	|	400.598	|	238.139 (59.45%)	|	246.587 (61.55%)	|	170.85 (42.65%) |

## EishayParseTreeUTF8Bytes
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1130.453	|	571.486 (50.55%)	|	775.959 (68.64%)	|	357.579 (31.63%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1147.806	|	500.025 (43.56%)	|	767.397 (66.86%)	|	363.967 (31.71%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1233.26	|	654.667 (53.08%)	|	781.804 (63.39%)	|	359.228 (29.13%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	841.076	|	445.204 (52.93%)	|	586.673 (69.75%)	|	303.403 (36.07%) |
| ecs.g7.xlarge | jdk-11.0.19	|	936.554	|	366.166 (39.1%)	|	523.583 (55.91%)	|	302.682 (32.32%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1019.365	|	499.936 (49.04%)	|	590.909 (57.97%)	|	305.572 (29.98%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	563.551	|	249.954 (44.35%)	|	282.514 (50.13%)	|	231.978 (41.16%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	720.53	|	335.318 (46.54%)	|	410.794 (57.01%)	|	283.461 (39.34%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	744.474	|	357.119 (47.97%)	|	425.046 (57.09%)	|	287.445 (38.61%) |
| OrangePI5 | jdk1.8.0_371	|	406.135	|	176.874 (43.55%)	|	292.207 (71.95%)	|	153.486 (37.79%) |
| OrangePI5 | jdk-11.0.19	|	479.636	|	207.474 (43.26%)	|	291.951 (60.87%)	|	175.221 (36.53%) |
| OrangePI5 | jdk-17.0.7	|	484.403	|	244.426 (50.46%)	|	310.724 (64.15%)	|	170.812 (35.26%) |

## EishayParseTreeUTF8BytesPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	972.045	|	479.942 (49.37%)	|	715.253 (73.58%)	|	331.735 (34.13%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	865.02	|	419.269 (48.47%)	|	615.728 (71.18%)	|	340.704 (39.39%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1041.96	|	520.058 (49.91%)	|	696.018 (66.8%)	|	339.168 (32.55%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	705.923	|	373.771 (52.95%)	|	528.277 (74.83%)	|	291.256 (41.26%) |
| ecs.g7.xlarge | jdk-11.0.19	|	705.382	|	314.028 (44.52%)	|	477.231 (67.66%)	|	290.97 (41.25%) |
| ecs.g7.xlarge | jdk-17.0.7	|	805.016	|	421.945 (52.41%)	|	520.087 (64.61%)	|	293.834 (36.5%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	497.829	|	257.259 (51.68%)	|	276.693 (55.58%)	|	227.554 (45.71%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	604.689	|	288.604 (47.73%)	|	397.009 (65.66%)	|	271.348 (44.87%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	617.203	|	304.027 (49.26%)	|	406.569 (65.87%)	|	275.588 (44.65%) |
| OrangePI5 | jdk1.8.0_371	|	362.165	|	147.891 (40.84%)	|	245.528 (67.79%)	|	141.949 (39.19%) |
| OrangePI5 | jdk-11.0.19	|	402.163	|	165.093 (41.05%)	|	267.135 (66.42%)	|	164.482 (40.9%) |
| OrangePI5 | jdk-17.0.7	|	408.573	|	204.633 (50.08%)	|	288.804 (70.69%)	|	159.671 (39.08%) |

## EishayParseUTF8Bytes
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1448.529	|	1042.98 (72%)	|	723.276 (49.93%)	|	358.017 (24.72%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1537.12	|	981.693 (63.87%)	|	679.992 (44.24%)	|	364.351 (23.7%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1616.565	|	1193.24 (73.81%)	|	725.323 (44.87%)	|	358.849 (22.2%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1115.504	|	817.797 (73.31%)	|	567.374 (50.86%)	|	304.565 (27.3%) |
| ecs.g7.xlarge | jdk-11.0.19	|	1187.295	|	753.285 (63.45%)	|	538.649 (45.37%)	|	307.13 (25.87%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1319.306	|	960.051 (72.77%)	|	546.506 (41.42%)	|	318.748 (24.16%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	795.137	|	674.229 (84.79%)	|	370.15 (46.55%)	|	239.929 (30.17%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1055.207	|	675.879 (64.05%)	|	424.879 (40.26%)	|	294.944 (27.95%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	1082.319	|	823.433 (76.08%)	|	447.528 (41.35%)	|	288.797 (26.68%) |
| OrangePI5 | jdk1.8.0_371	|	584.183	|	400.301 (68.52%)	|	317.547 (54.36%)	|	153.752 (26.32%) |
| OrangePI5 | jdk-11.0.19	|	683.318	|	449.618 (65.8%)	|	302.992 (44.34%)	|	175.227 (25.64%) |
| OrangePI5 | jdk-17.0.7	|	689.944	|	579.496 (83.99%)	|	297.345 (43.1%)	|	168.129 (24.37%) |

## EishayParseUTF8BytesPretty
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1189.501	|	289.303 (24.32%)	|	660.519 (55.53%)	|	338.714 (28.48%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1151.518	|	285.687 (24.81%)	|	624.173 (54.2%)	|	339.233 (29.46%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1260.294	|	325.333 (25.81%)	|	651.543 (51.7%)	|	340.318 (27%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	845.005	|	247.996 (29.35%)	|	502.997 (59.53%)	|	284.904 (33.72%) |
| ecs.g7.xlarge | jdk-11.0.19	|	899.487	|	220.983 (24.57%)	|	500.796 (55.68%)	|	290.295 (32.27%) |
| ecs.g7.xlarge | jdk-17.0.7	|	965.949	|	271.728 (28.13%)	|	499.816 (51.74%)	|	292.435 (30.27%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	663.885	|	196.83 (29.65%)	|	344.33 (51.87%)	|	214.301 (32.28%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	779.17	|	221.85 (28.47%)	|	399.377 (51.26%)	|	271.855 (34.89%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	783.925	|	242.056 (30.88%)	|	400.385 (51.07%)	|	270.873 (34.55%) |
| OrangePI5 | jdk1.8.0_371	|	486.893	|	140.283 (28.81%)	|	279.594 (57.42%)	|	142.338 (29.23%) |
| OrangePI5 | jdk-11.0.19	|	525.902	|	144.994 (27.57%)	|	275.3 (52.35%)	|	164.624 (31.3%) |
| OrangePI5 | jdk-17.0.7	|	536.777	|	163.024 (30.37%)	|	270.777 (50.44%)	|	156.803 (29.21%) |

## EishayWriteBinary
| aliyun ecs spec | jdk version 	|	jsonb	|	fastjson2UTF8Bytes	|	hessian	|	javaSerialize |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	2287.932	|	2004.762 (87.62%)	|	361.474 (15.8%)	|	275.439 (12.04%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	3353.033	|	2087.085 (62.24%)	|	351.499 (10.48%)	|	267.272 (7.97%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	4391.696	|	2568.701 (58.49%)	|	342.251 (7.79%)	|	269.449 (6.14%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	2083.852	|	1583.744 (76%)	|	338.644 (16.25%)	|	221.79 (10.64%) |
| ecs.g7.xlarge | jdk-11.0.19	|	2543.175	|	1603.231 (63.04%)	|	324.614 (12.76%)	|	217.033 (8.53%) |
| ecs.g7.xlarge | jdk-17.0.7	|	3515.606	|	1936.673 (55.09%)	|	320.551 (9.12%)	|	217.297 (6.18%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	1750.218	|	1330.854 (76.04%)	|	339.293 (19.39%)	|	203.945 (11.65%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	2291.742	|	1447.556 (63.16%)	|	365.46 (15.95%)	|	232.902 (10.16%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	2326.174	|	1436.709 (61.76%)	|	341.313 (14.67%)	|	213.313 (9.17%) |
| OrangePI5 | jdk1.8.0_371	|	1068.958	|	841.02 (78.68%)	|	185.045 (17.31%)	|	124.414 (11.64%) |
| OrangePI5 | jdk-11.0.19	|	1380.106	|	916.664 (66.42%)	|	192.28 (13.93%)	|	126.346 (9.15%) |
| OrangePI5 | jdk-17.0.7	|	1513.381	|	955.167 (63.11%)	|	211.04 (13.94%)	|	129.421 (8.55%) |

## EishayWriteBinaryArrayMapping
| aliyun ecs spec | jdk version 	|	jsonb	|	kryo	|	protobuf	|	fastjson2UTF8Bytes |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	3976.008	|	2348.823 (59.07%)	|	1714.636 (43.12%)	|	2388.109 (60.06%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	7081.36	|	2456.796 (34.69%)	|	1707.25 (24.11%)	|	2818.274 (39.8%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	8004.938	|	2504.014 (31.28%)	|	1933.815 (24.16%)	|	2831.9 (35.38%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	3420.1	|	1854.6 (54.23%)	|	1321.198 (38.63%)	|	1977.545 (57.82%) |
| ecs.g7.xlarge | jdk-11.0.19	|	5119.801	|	2051.61 (40.07%)	|	1467.811 (28.67%)	|	2154.608 (42.08%) |
| ecs.g7.xlarge | jdk-17.0.7	|	6212.794	|	1984.712 (31.95%)	|	1665.128 (26.8%)	|	2266.282 (36.48%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	2859.545	|	1455.185 (50.89%)	|	994.066 (34.76%)	|	1614.92 (56.47%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	4445.556	|	1548.904 (34.84%)	|	1282.556 (28.85%)	|	1803.463 (40.57%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	4639.577	|	1531.842 (33.02%)	|	1270.836 (27.39%)	|	1773.506 (38.23%) |
| OrangePI5 | jdk1.8.0_371	|	1640.757	|	820.359 (50%)	|	712.158 (43.4%)	|	1015.154 (61.87%) |
| OrangePI5 | jdk-11.0.19	|	2476.796	|	1006.016 (40.62%)	|	842.347 (34.01%)	|	1085.526 (43.83%) |
| OrangePI5 | jdk-17.0.7	|	2569.268	|	1036.738 (40.35%)	|	921.774 (35.88%)	|	1098.409 (42.75%) |

## EishayWriteBinaryAutoType
| aliyun ecs spec | jdk version 	|	fastjson2JSONB	|	hessian	|	javaSerialize |
|-----|-----|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1708.784	|	357.469 (20.92%)	|	288.086 (16.86%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1952.914	|	356.608 (18.26%)	|	288.06 (14.75%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	2165.508	|	340.7 (15.73%)	|	272.056 (12.56%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1382.169	|	334.523 (24.2%)	|	231.1 (16.72%) |
| ecs.g7.xlarge | jdk-11.0.19	|	1465.398	|	324.201 (22.12%)	|	221.429 (15.11%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1701.095	|	323.521 (19.02%)	|	219.721 (12.92%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	1178.156	|	352.542 (29.92%)	|	206.525 (17.53%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1332.33	|	370.563 (27.81%)	|	219.444 (16.47%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	1305.512	|	359.432 (27.53%)	|	214.39 (16.42%) |
| OrangePI5 | jdk1.8.0_371	|	689.686	|	197.567 (28.65%)	|	121.62 (17.63%) |
| OrangePI5 | jdk-11.0.19	|	793.571	|	181.195 (22.83%)	|	131.472 (16.57%) |
| OrangePI5 | jdk-17.0.7	|	823.651	|	197.848 (24.02%)	|	133.822 (16.25%) |

## EishayWriteString
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	2081.852	|	762.657 (36.63%)	|	1290.47 (61.99%)	|	585.672 (28.13%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1957.322	|	727.893 (37.19%)	|	1178.683 (60.22%)	|	457.153 (23.36%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1898.827	|	789.117 (41.56%)	|	1315.67 (69.29%)	|	246.492 (12.98%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1712.295	|	622.295 (36.34%)	|	1028.523 (60.07%)	|	449.276 (26.24%) |
| ecs.g7.xlarge | jdk-11.0.19	|	1447.373	|	598.034 (41.32%)	|	958.842 (66.25%)	|	358.069 (24.74%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1663.356	|	636.11 (38.24%)	|	1023.048 (61.51%)	|	241.458 (14.52%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	1359.108	|	521.426 (38.37%)	|	637.953 (46.94%)	|	374.484 (27.55%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1349.019	|	596.439 (44.21%)	|	690.609 (51.19%)	|	317.697 (23.55%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	1325.282	|	566.381 (42.74%)	|	685.799 (51.75%)	|	217.381 (16.4%) |
| OrangePI5 | jdk1.8.0_371	|	785.712	|	296.902 (37.79%)	|	393.356 (50.06%)	|	205.971 (26.21%) |
| OrangePI5 | jdk-11.0.19	|	843.32	|	306.708 (36.37%)	|	426.623 (50.59%)	|	205.008 (24.31%) |
| OrangePI5 | jdk-17.0.7	|	853.89	|	361.511 (42.34%)	|	430.296 (50.39%)	|	166.541 (19.5%) |

## EishayWriteStringTree
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	1508.938	|	1010.954 (67%)	|	1181.659 (78.31%)	|	624.185 (41.37%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	1504.782	|	966.903 (64.26%)	|	1144.347 (76.05%)	|	475.26 (31.58%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	1310.261	|	1000.311 (76.34%)	|	1172.485 (89.48%)	|	254.394 (19.42%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1276.544	|	822.104 (64.4%)	|	945.308 (74.05%)	|	482.098 (37.77%) |
| ecs.g7.xlarge | jdk-11.0.19	|	1302.738	|	759.184 (58.28%)	|	888.98 (68.24%)	|	373.502 (28.67%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1238.635	|	808.074 (65.24%)	|	900.744 (72.72%)	|	250.976 (20.26%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	965.25	|	589.634 (61.09%)	|	698.779 (72.39%)	|	437.534 (45.33%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1099.278	|	627.204 (57.06%)	|	711.386 (64.71%)	|	356.512 (32.43%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	1084.069	|	664.893 (61.33%)	|	687.701 (63.44%)	|	226.657 (20.91%) |
| OrangePI5 | jdk1.8.0_371	|	498.008	|	332.468 (66.76%)	|	388.994 (78.11%)	|	225.469 (45.27%) |
| OrangePI5 | jdk-11.0.19	|	616.612	|	364.825 (59.17%)	|	442.558 (71.77%)	|	219.445 (35.59%) |
| OrangePI5 | jdk-17.0.7	|	609.755	|	365.345 (59.92%)	|	411.267 (67.45%)	|	167.974 (27.55%) |

## EishayWriteUTF8Bytes
| aliyun ecs spec | jdk version 	|	fastjson2	|	fastjson1	|	jackson	|	gson |
|-----|-----|----------|----------|----------|-----|
| ecs.g8i.xlarge | jdk1.8.0_371	|	2019.675	|	692.775 (34.3%)	|	1108.676 (54.89%)	|	485.236 (24.03%) |
| ecs.g8i.xlarge | jdk-11.0.19	|	2147.388	|	675.854 (31.47%)	|	1103.739 (51.4%)	|	446.452 (20.79%) |
| ecs.g8i.xlarge | jdk-17.0.7	|	2485.052	|	636.401 (25.61%)	|	1238.227 (49.83%)	|	246.286 (9.91%) |
| ecs.g7.xlarge | jdk1.8.0_371	|	1600.989	|	572.999 (35.79%)	|	930.199 (58.1%)	|	381.374 (23.82%) |
| ecs.g7.xlarge | jdk-11.0.19	|	1605.967	|	554.836 (34.55%)	|	875.346 (54.51%)	|	348.997 (21.73%) |
| ecs.g7.xlarge | jdk-17.0.7	|	1910.674	|	555.388 (29.07%)	|	994.487 (52.05%)	|	240.553 (12.59%) |
| ecs.g8m.xlarge | jdk1.8.0_371	|	1336.315	|	479.496 (35.88%)	|	672.574 (50.33%)	|	319.024 (23.87%) |
| ecs.g8m.xlarge | jdk-11.0.19	|	1458.968	|	485.806 (33.3%)	|	641.318 (43.96%)	|	304.274 (20.86%) |
| ecs.g8m.xlarge | jdk-17.0.7	|	1431.852	|	521.881 (36.45%)	|	711.62 (49.7%)	|	215.675 (15.06%) |
| OrangePI5 | jdk1.8.0_371	|	840.577	|	297.469 (35.39%)	|	403.985 (48.06%)	|	175.45 (20.87%) |
| OrangePI5 | jdk-11.0.19	|	915.255	|	290.285 (31.72%)	|	392.783 (42.92%)	|	193.35 (21.13%) |
| OrangePI5 | jdk-17.0.7	|	942.339	|	318.996 (33.85%)	|	435.127 (46.18%)	|	161.263 (17.11%) |
