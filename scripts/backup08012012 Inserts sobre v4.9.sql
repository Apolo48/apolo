--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.5
-- Dumped by pg_dump version 9.0.3
-- Started on 2012-01-08 12:19:56

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 3136 (class 0 OID 0)
-- Dependencies: 1919
-- Name: actividad_calendario_codigo_actividad_calendario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('actividad_calendario_codigo_actividad_calendario_seq', 1, false);


--
-- TOC entry 3137 (class 0 OID 0)
-- Dependencies: 1920
-- Name: actividad_codigo_actividad_seq_6_1_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('actividad_codigo_actividad_seq_6_1_1', 1, false);


--
-- TOC entry 3138 (class 0 OID 0)
-- Dependencies: 1922
-- Name: actividad_entrenamiento_cod_actividad_entrenamiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('actividad_entrenamiento_cod_actividad_entrenamiento_seq', 1, false);


--
-- TOC entry 3139 (class 0 OID 0)
-- Dependencies: 1925
-- Name: actividades_ejecutadas_codigo_actividad_ejecutada_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('actividades_ejecutadas_codigo_actividad_ejecutada_seq', 1, false);


--
-- TOC entry 3140 (class 0 OID 0)
-- Dependencies: 1929
-- Name: almacen_codigo_almacen_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('almacen_codigo_almacen_seq_1', 1, false);


--
-- TOC entry 3141 (class 0 OID 0)
-- Dependencies: 1931
-- Name: ascenso_codigo_ascenso_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ascenso_codigo_ascenso_seq_1', 1, false);


--
-- TOC entry 3142 (class 0 OID 0)
-- Dependencies: 1933
-- Name: asistencia_jugador_codigo_asistencia_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('asistencia_jugador_codigo_asistencia_seq_1', 1, false);


--
-- TOC entry 3143 (class 0 OID 0)
-- Dependencies: 1936
-- Name: categoria_codigo_categoria_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('categoria_codigo_categoria_seq_1', 1, false);


--
-- TOC entry 3144 (class 0 OID 0)
-- Dependencies: 1940
-- Name: comision_equipo_codigo_comision_equipo_seq_1_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('comision_equipo_codigo_comision_equipo_seq_1_1', 1, false);


--
-- TOC entry 3145 (class 0 OID 0)
-- Dependencies: 1942
-- Name: competencia_codigo_competencia_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('competencia_codigo_competencia_seq_1', 1, false);


--
-- TOC entry 3146 (class 0 OID 0)
-- Dependencies: 1944
-- Name: concepto_nomina_codigo_concepto_nomina_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('concepto_nomina_codigo_concepto_nomina_seq', 1, false);


--
-- TOC entry 3147 (class 0 OID 0)
-- Dependencies: 1948
-- Name: constante_categoria_codigo_constante_categoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('constante_categoria_codigo_constante_categoria_seq', 1, false);


--
-- TOC entry 3148 (class 0 OID 0)
-- Dependencies: 1949
-- Name: constante_codigo_constante_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('constante_codigo_constante_seq_1', 1, false);


--
-- TOC entry 3149 (class 0 OID 0)
-- Dependencies: 1953
-- Name: dato_academico_codigo_academico_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dato_academico_codigo_academico_seq_1', 5, true);


--
-- TOC entry 3150 (class 0 OID 0)
-- Dependencies: 1955
-- Name: dato_academico_personal_codigo_dato_academico_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dato_academico_personal_codigo_dato_academico_seq', 1, false);


--
-- TOC entry 3151 (class 0 OID 0)
-- Dependencies: 1957
-- Name: dato_basico_codigo_dato_basico_seq_2_5; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dato_basico_codigo_dato_basico_seq_2_5', 285, true);


--
-- TOC entry 3152 (class 0 OID 0)
-- Dependencies: 1959
-- Name: dato_basico_dia_semana_seq_2_11; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dato_basico_dia_semana_seq_2_11', 1, false);


--
-- TOC entry 3153 (class 0 OID 0)
-- Dependencies: 1961
-- Name: dato_conducta_codigo_dato_conducta_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dato_conducta_codigo_dato_conducta_seq_1', 1, false);


--
-- TOC entry 3154 (class 0 OID 0)
-- Dependencies: 1964
-- Name: dato_medico_codigo_dato_medico_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dato_medico_codigo_dato_medico_seq_1', 9, true);


--
-- TOC entry 3155 (class 0 OID 0)
-- Dependencies: 1966
-- Name: dato_social_codigo_dato_social_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('dato_social_codigo_dato_social_seq_1', 3, true);


--
-- TOC entry 3156 (class 0 OID 0)
-- Dependencies: 1972
-- Name: divisa_codigo_divisa_seq_2; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('divisa_codigo_divisa_seq_2', 1, false);


--
-- TOC entry 3157 (class 0 OID 0)
-- Dependencies: 1975
-- Name: documento_acreedor_codigo_documento_acreedor_seq_3_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('documento_acreedor_codigo_documento_acreedor_seq_3_1', 1, false);


--
-- TOC entry 3158 (class 0 OID 0)
-- Dependencies: 1983
-- Name: documentos_entregados_codigo_documento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('documentos_entregados_codigo_documento_seq', 9, true);


--
-- TOC entry 3159 (class 0 OID 0)
-- Dependencies: 1989
-- Name: equipo_codigo_equipo_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('equipo_codigo_equipo_seq_1', 1, false);


--
-- TOC entry 3160 (class 0 OID 0)
-- Dependencies: 1991
-- Name: equipo_competencia_codigo_equipo_competencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('equipo_competencia_codigo_equipo_competencia_seq', 1, false);


--
-- TOC entry 3161 (class 0 OID 0)
-- Dependencies: 1993
-- Name: equipo_juego_codigo_equipo_juego_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('equipo_juego_codigo_equipo_juego_seq', 1, false);


--
-- TOC entry 3162 (class 0 OID 0)
-- Dependencies: 1995
-- Name: escala_medicion_codigo_escala_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('escala_medicion_codigo_escala_seq_1', 1, false);


--
-- TOC entry 3163 (class 0 OID 0)
-- Dependencies: 1997
-- Name: estadio_codigo_estadio_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estadio_codigo_estadio_seq_1', 1, false);


--
-- TOC entry 3164 (class 0 OID 0)
-- Dependencies: 2002
-- Name: familiar_jugador_codigo_familiar_jugador_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('familiar_jugador_codigo_familiar_jugador_seq_1', 1, false);


--
-- TOC entry 3165 (class 0 OID 0)
-- Dependencies: 2005
-- Name: horario_codigo_horario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('horario_codigo_horario_seq', 1, false);


--
-- TOC entry 3166 (class 0 OID 0)
-- Dependencies: 2007
-- Name: hospedaje_codigo_hospedaje_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hospedaje_codigo_hospedaje_seq_1', 1, false);


--
-- TOC entry 3167 (class 0 OID 0)
-- Dependencies: 2010
-- Name: indicador_actividad_escala_codigo_indicador_actividad_escala21; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_actividad_escala_codigo_indicador_actividad_escala21', 1, false);


--
-- TOC entry 3168 (class 0 OID 0)
-- Dependencies: 2012
-- Name: indicador_categoria_competencia_codigo_indicador_competencia77; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_categoria_competencia_codigo_indicador_competencia77', 1, false);


--
-- TOC entry 3169 (class 0 OID 0)
-- Dependencies: 2013
-- Name: indicador_codigo_indicador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_codigo_indicador_seq', 1, false);


--
-- TOC entry 3170 (class 0 OID 0)
-- Dependencies: 2015
-- Name: indicador_test_codigo_indicador_test_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_test_codigo_indicador_test_seq', 1, false);


--
-- TOC entry 3171 (class 0 OID 0)
-- Dependencies: 2020
-- Name: instalacion_codigo_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('instalacion_codigo_instalacion_seq', 1, false);


--
-- TOC entry 3172 (class 0 OID 0)
-- Dependencies: 2022
-- Name: institucion_codigo_institucion_seq_1_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('institucion_codigo_institucion_seq_1_1', 1, false);


--
-- TOC entry 3173 (class 0 OID 0)
-- Dependencies: 2024
-- Name: juego_codigo_juego_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('juego_codigo_juego_seq_1', 1, false);


--
-- TOC entry 3174 (class 0 OID 0)
-- Dependencies: 2027
-- Name: jugador_foraneo_cedula_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('jugador_foraneo_cedula_seq', 1, false);


--
-- TOC entry 3175 (class 0 OID 0)
-- Dependencies: 2029
-- Name: lapso_deportivo_codigo_lapso_deportivo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('lapso_deportivo_codigo_lapso_deportivo_seq', 1, false);


--
-- TOC entry 3176 (class 0 OID 0)
-- Dependencies: 2032
-- Name: liga_codigo_liga_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('liga_codigo_liga_seq', 1, false);


--
-- TOC entry 3177 (class 0 OID 0)
-- Dependencies: 2035
-- Name: line_up_codigo_line_up_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('line_up_codigo_line_up_seq', 1, false);


--
-- TOC entry 3178 (class 0 OID 0)
-- Dependencies: 2039
-- Name: material_actividad_codigo_material_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('material_actividad_codigo_material_actividad_seq', 1, false);


--
-- TOC entry 3179 (class 0 OID 0)
-- Dependencies: 2041
-- Name: material_codigo_material_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('material_codigo_material_seq', 1, false);


--
-- TOC entry 3180 (class 0 OID 0)
-- Dependencies: 2044
-- Name: modalidad_competencia_codigo_modalidad_competencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('modalidad_competencia_codigo_modalidad_competencia_seq', 1, false);


--
-- TOC entry 3181 (class 0 OID 0)
-- Dependencies: 2047
-- Name: movimiento_codigo_movimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('movimiento_codigo_movimiento_seq', 1, false);


--
-- TOC entry 3182 (class 0 OID 0)
-- Dependencies: 2049
-- Name: nomina_codigo_nomina_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nomina_codigo_nomina_seq_1', 1, false);


--
-- TOC entry 3183 (class 0 OID 0)
-- Dependencies: 2051
-- Name: nota_entrega_codigo_nota_entrega_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nota_entrega_codigo_nota_entrega_seq_1', 1, false);


--
-- TOC entry 3184 (class 0 OID 0)
-- Dependencies: 2053
-- Name: periodicidad_codigo_periodicidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('periodicidad_codigo_periodicidad_seq', 1, false);


--
-- TOC entry 3185 (class 0 OID 0)
-- Dependencies: 2061
-- Name: personal_cargo_codigo_personal_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_cargo_codigo_personal_cargo_seq', 1, false);


--
-- TOC entry 3186 (class 0 OID 0)
-- Dependencies: 2063
-- Name: personal_concepto_nomina_codigo_personal_concepto_nomina_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_concepto_nomina_codigo_personal_concepto_nomina_seq', 1, false);


--
-- TOC entry 3187 (class 0 OID 0)
-- Dependencies: 2065
-- Name: personal_contrato_codigo_personal_contrato_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_contrato_codigo_personal_contrato_seq', 1, false);


--
-- TOC entry 3188 (class 0 OID 0)
-- Dependencies: 2067
-- Name: personal_equipo_codigo_personal_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_equipo_codigo_personal_equipo_seq', 1, false);


--
-- TOC entry 3189 (class 0 OID 0)
-- Dependencies: 2070
-- Name: personal_foraneo_codigo_personal_foraneo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_foraneo_codigo_personal_foraneo_seq', 1, false);


--
-- TOC entry 3190 (class 0 OID 0)
-- Dependencies: 2074
-- Name: personal_tipo_nomina_codigo_personal_tipo_nomina_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_tipo_nomina_codigo_personal_tipo_nomina_seq', 1, false);


--
-- TOC entry 3191 (class 0 OID 0)
-- Dependencies: 2076
-- Name: plan_entrenamiento_codigo_plan_entrenamiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('plan_entrenamiento_codigo_plan_entrenamiento_seq', 1, false);


--
-- TOC entry 3192 (class 0 OID 0)
-- Dependencies: 2078
-- Name: plan_rotacion_codigo_plan_rotacion_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('plan_rotacion_codigo_plan_rotacion_seq_1', 1, false);


--
-- TOC entry 3193 (class 0 OID 0)
-- Dependencies: 2080
-- Name: plan_temporada_codigo_plan_temporada_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('plan_temporada_codigo_plan_temporada_seq', 1, false);


--
-- TOC entry 3194 (class 0 OID 0)
-- Dependencies: 2082
-- Name: planificacion_actividad_codigo_planificacion_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('planificacion_actividad_codigo_planificacion_actividad_seq', 1, false);


--
-- TOC entry 3195 (class 0 OID 0)
-- Dependencies: 2085
-- Name: recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1', 1, false);


--
-- TOC entry 3196 (class 0 OID 0)
-- Dependencies: 2089
-- Name: requisicion_codigo_requisicion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('requisicion_codigo_requisicion_seq', 1, false);


--
-- TOC entry 3197 (class 0 OID 0)
-- Dependencies: 2093
-- Name: roster_codigo_roster_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roster_codigo_roster_seq_1', 3, true);


--
-- TOC entry 3198 (class 0 OID 0)
-- Dependencies: 2095
-- Name: roster_competencia_codigo_roster_competencia_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roster_competencia_codigo_roster_competencia_seq_1', 1, false);


--
-- TOC entry 3199 (class 0 OID 0)
-- Dependencies: 2097
-- Name: seguridad_funcional_codigo_seguridad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seguridad_funcional_codigo_seguridad_seq', 1, false);


--
-- TOC entry 3200 (class 0 OID 0)
-- Dependencies: 2098
-- Name: sesion_codigo_sesion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sesion_codigo_sesion_seq', 1, false);


--
-- TOC entry 3201 (class 0 OID 0)
-- Dependencies: 2100
-- Name: sesion_ejecutada_codigo_sesion_ejecutada_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sesion_ejecutada_codigo_sesion_ejecutada_seq', 1, false);


--
-- TOC entry 3202 (class 0 OID 0)
-- Dependencies: 2102
-- Name: solicitud_mantenimiento_codigo_solicitud_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('solicitud_mantenimiento_codigo_solicitud_seq_1', 1, false);


--
-- TOC entry 3203 (class 0 OID 0)
-- Dependencies: 2104
-- Name: talla_por_indumentaria_codigo_talla_indumentaria_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('talla_por_indumentaria_codigo_talla_indumentaria_seq_1', 1, false);


--
-- TOC entry 3204 (class 0 OID 0)
-- Dependencies: 2107
-- Name: tarea_actividad_codigo_tarea_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tarea_actividad_codigo_tarea_actividad_seq', 1, false);


--
-- TOC entry 3205 (class 0 OID 0)
-- Dependencies: 2109
-- Name: tarea_actividad_planificada_codigo_personal_actividad_planif18; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tarea_actividad_planificada_codigo_personal_actividad_planif18', 1, false);


--
-- TOC entry 3206 (class 0 OID 0)
-- Dependencies: 2111
-- Name: test_evaluativo_codigo_test_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('test_evaluativo_codigo_test_seq', 1, false);


--
-- TOC entry 3207 (class 0 OID 0)
-- Dependencies: 2114
-- Name: tipo_competencia_codigo_tipo_competencia_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_competencia_codigo_tipo_competencia_seq_1', 1, false);


--
-- TOC entry 3208 (class 0 OID 0)
-- Dependencies: 2116
-- Name: tipo_dato_codigo_tipo_dato_seq_1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_dato_codigo_tipo_dato_seq_1', 98, true);


--
-- TOC entry 3209 (class 0 OID 0)
-- Dependencies: 2118
-- Name: tipo_pago_representante_codigo_tipo_pago_representante_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_pago_representante_codigo_tipo_pago_representante_seq', 1, false);


--
-- TOC entry 3210 (class 0 OID 0)
-- Dependencies: 2121
-- Name: valor_escala_codigo_valor_escala_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('valor_escala_codigo_valor_escala_seq', 1, false);


--
-- TOC entry 3130 (class 0 OID 54907)
-- Dependencies: 2115
-- Data for Name: tipo_dato; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (1, 'FASE', 'FASES DEL ENTRENAMIENTO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (2, 'ACTIVIDAD ENTRENAMIENTO', 'ACTIVIDADES REALIZADAS EN EL ENTRENAMIENTO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (3, 'ACTIVIDAD PLANIFICADA', 'ACTIVIDADES QUE SE PLANIFICAN EN EL ENTRENAMIENTO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (4, 'ACTIVIDADES EJECUTADAS', 'ACTIVIDADES QUE SON EJECUTADAS EN EL ENTRENAMIENTO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (5, 'ASISTENCIA JUGADOR', 'ASISTENCIA DE LOS JUGADORES A LA SESION', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (6, 'ASISTENCIA PERSONAL ENTRENAMIENTO', 'ASISTENCIA DE LOS MANAGERS Y MONITORES A LA SESION', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (7, 'DESEMPENNO JUGADOR', 'DESEMPEÑO DEL JUGADOR DURANTE LOS ENTRENAMIENTOS', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (8, 'ESCALA MEDICION', 'ESCALAS USADAS PARA MEDIR EL DESEMPEÑO DEL JUGADOR', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (9, 'HORARIO', 'HORARIO DE LAS CATEGORIAS PARA ENTRENAR', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (10, 'INDICADOR ACTIVIDAD ESCALA', 'INDICADORES EVALUADOS EN UNA ACTIVIDAD ESPECIFICA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (11, 'INDICADOR TEST', 'INDICADORES EVALUADOS EN LOS TEST EVALUATIVOS', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (12, 'LAPSO DEPORTIVO', 'LAPSO DE TIEMPO EN EL CUAL SE DESENVUELVEN LAS ACTIVIDADES DE LA ESCUELA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (13, 'PLAN ENTRENAMIENTO', 'PLANIFICACION DE LOS ENTRENAMIENTOS EN UN PERIODO DE TIEMPO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (14, 'PLAN ROTACION', 'PLANIFICACION DE LAS INSTALACIONES PARA UN DIA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (15, 'PLAN TEMPORADA', 'PLANIFICACION DE LOS MANAGERS Y HORARIOS EN UN LAPSO DEPORTIVO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (16, 'SESION', 'SESION DE ENTRENAMIENTO PLANIFICADA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (17, 'SESION EJECUTADA', 'SESION DE ENTRENAMIENTO EJECUTADA EN UNA FECHA ESPECIFICA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (18, 'TEST EVALUATIVO', 'TEST REALIZADOS A UN EQUIPO ESPECIFICO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (19, 'TEST JUGADOR', 'TEST REALIZADOS A LOS JUGADORES EN EL ENTRENAMIENTO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (20, 'VALOR ESCALA', 'VALORES DE LAS ESCALAS USADAS PARA MEDIR EL DESEMPEÑO JUGADOR', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (21, 'CONCEPTO NOMINA', 'CONEPTO DE LA NOMINA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (22, 'PERSONAL CONCEPTO NOMINA', 'CONCEPTO ASOCIADOS A LOS EMPLEADOS ', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (23, 'DATO ACADEMICO PERSONAL', 'LOS ESTUDIOS REALIZADOS POR LOS EMPLEADOS', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (24, 'PERSONAL CONTRATO', 'CONTIENE LA MODALIDAD DE CONTRATO Y EL HORARIO DE TRABAJO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (25, 'AFECCION PERSONAL', 'LAS ALERGIAS ASOCIADAS A LOS EMPLEADOS ', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (26, 'PERSONAL', 'MANTIENE LA INFORMACION DE LOS EMPLEADOS Y EL PERSONAL ADHONOREN', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (27, 'DOCUMENTO ACREEDOR MATERIAL', 'ALMACENA LOS MATERIALES POR LAS DONACIONES', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (28, 'INGRESO DOCUMENTO ACREEDOR', 'ALMACENA  EL INGRESO DE DINERO GENERADOS POR LAS CUENTAS POR COBRAR', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (29, 'INGRESO', 'INGRESO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (30, 'DOCUMENTO ACREEDOR', 'AMACENA TODAS LAS CUENTAS POR COBRAR', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (31, 'PERSONAL TIPO NOMINA', ' GUARDA LOS DIFREENTES TIPO DE NOMINA POR LO QUE PASA EL EMPLEADO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (32, 'DOCUMENTO INDUMENTARIA', 'ALMACENA LOS DIVERSOS VESTUARIOS QUE COMPRA UN REPRESENTANTE', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (33, 'INGRESO FORMA DE PAGO', 'GUARDA LAS DIVERSAS MANERAS CON QUE CANCENLAN LAS CUENTAS', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (34, 'PERSONAL CARGO', 'ALMACENA TODOS LOS CARGOS QUE HA OCUPADO UN EMPLEADO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (35, 'NOMINA', 'ALAMCENA LOS DISTINTAS PERIODOS CON LOS TIPO DE NOMINA RESPECTIVO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (36, 'EGRESO CUENTA PAGAR', 'ALMACENA LOS CEUNTAS POR PAGAR QUE HAN SIDO CANCELADA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (37, 'PERSONAL CARGO', 'ALMACENA TODOS LOS CARGOS QUE HA OCUPADO UN EMPLEADO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (38, 'CUENTA PAGAR', 'REPRESENTA LOS DIVERSOS COMPROMISOS ADQUIRIDOS', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (39, 'PERSONAL CARGO', 'ALAMACENA TODOS LOS CARGOS QUE HA OCUPADO UN EMPLEADO', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (40, 'EGRESO', 'REPRESENTAN LOS PAGOS  REALIZADOS', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (41, 'EGRESO FORMA PAGO', ' REPRESENTA LAS DIVERSAS FORMAS EN QUE SE PUEDE CANCELAR', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (42, 'EGRESO', 'REPRESENTAN LOS PAGOS  REALIZADOS', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (43, 'CUENTA PAGAR MATERIAL', 'REPRESENTAN LOS MATERIALES QUE SE ADQUIERE A TRAVES DE UNA COMPRA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (44, 'PROVEEDOR BANCO', 'ALMACENA LAS DISTINTAS CUENTAS BANCARIAS QUE POSEEN LOS PROVEEDORES', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (45, 'PERSONA', 'ALMACENA PARTE DE LOS DATOS BASICOS DE LA PERSONA ', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (46, 'PERSONA NATURAL', 'ALMACENA DATOS BASICOS QUE NO SE ENCUENTRA EN PERSONA Y ESTAN ASOCIADOS A PERSONA NATURAL', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (47, 'PERSONA JURIDICA', 'ALMACENA DATOS BASICOS QUE NO SE ENCUENTRA EN PERSONA Y ESTAN ASOCIADOS A PERSONA JURIDICA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (48, 'PERSONA JURIDICA', 'ALMACENA DATOS BASICOS QUE NO SE ENCUENTRA EN PERSONA Y ESTAN ASOCIADOS A PERSONA JURIDICA', 'A', false, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (49, 'AFECCION', 'ALMACENA TODAS LA POSIBLES ENFERMEDADES ALERGIAS U OTRA QUE PUEDA PADECER UN JUGADOR O EMPLEADO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (50, 'PERIODICIDAD DE LA NOMINA', 'GUARDA LOS PERIODOS EN QUE SE CANCELA LA NOMINA', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (51, 'TIPO NOMINA', 'GUARDA LOS DIFERENTES TIPO DE NOMINA QUE PUEDE PERTENECER UN EMPLEADO', 'A', true, 49);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (52, 'TIPO CONCEPTO NOMINA', 'GUARDA SI ES DEDUCCIONES O ASIGNACIONES', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (53, 'CARGO', 'GUARDA LOS POSIBLES CARGOS QUE PUEDE EJERCER UN EMPLEADO O PERSONA ADHONOREN', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (54, 'TIPO PERSONA', 'ALMACENA LAS DIFERENTES PERSONA', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (55, 'TIPO INGRESO', 'TIPO INGRESO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (56, 'TIPO EGRESO', 'TIPO INGRESO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (57, 'ENTIDAD BANCARIA', 'GUARDA LOS DIFERENTES NOBRE DE LOS BANCO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (58, 'FORMA DE PAGO', 'FORMA DE PAGO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (59, 'DOCUMENTO', 'ALMACENA LOS DOCUMENTOS ACREEDORES Y DEUDORES DE LAS OPERACIONES', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (60, 'HORARIO DE TRABAJO', 'HORARIO DE TRABAJO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (61, 'CUENTA BANCARIA', 'ALMACENA EL TIPO DE CUENTA  ', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (62, 'TARJETA CREDITO', 'ALAMCENA LOS DIFERENTES TIPO QUE PUEDE SER UNA TARJETA DE CREDITO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (63, 'MODALIDAD DE CONTRATO', 'ALMACENA EL TIPO DE MODALIDAD EN QUE PUEDE SER CONTRATADO UN EMPLEADO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (64, 'PAIS', 'ALMACENA LOS DIFERENTES PAISES', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (65, 'ESTADO_VENEZUELA', 'GUARDA TODOS LOS ESTADOS DE VENEZUELA', 'A', true, 64);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (66, 'MUNICIPIO', 'GUARDA TODOS LOS MUNICIPIOS', 'A', true, 65);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (67, 'PARROQUIA', 'GUARDA TODOS LAS PARROQUIAS', 'A', true, 66);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (68, 'CODIGO_AREA', 'CONTIENE LOS DIFERENTES CODIGOS DE AREA DE LOS ESTADOS', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (69, 'CODIGO_CELULAR', 'CONTIENE LOS DIFERENTES CODIGOS DE CELULALES', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (70, 'GRUPO_SANGUINEO', 'CONTIENE TODOS LOS TIPOS DE GRUPOS SANGUINEOS', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (71, 'FACTOR_SANGUINEO', 'CONTIENE TODOS LOS TIPOS DE FACTORES SANGUINEOS', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (72, 'TIPO_AFECCION', 'CONTIENE LOS TIPOS DE AFECCION QUE PUEDE TENER UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (73, 'CURSO', 'ALMACENA LOS CURSOS ESCOLARES DE UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (74, 'ANNO_ESCOLAR', 'ALMACENA LOS DIFERENTES AÑOS ESCOLARES DE UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (75, 'ACTIVIDAD_SOCIAL', 'ALMACENA LAS ACTIVIDADES EXTRAS QUE REALIZA UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (76, 'CLASIFICACION', 'ALMACENA LA CLASIFICACION QUE TIENE UN EQUIPO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (77, 'INDUMENTARIA', 'ALMACENA LOS TIPOS DE INDUMENTARIA', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (86, 'TIPO_INSTITUCION', 'ALMACENA LOS DIFERENTES TIPOS DE INSTITUCION QUE PUEDE TENER UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (87, 'SANCION', 'ALMACENA LOS DIFERENTES MOTIVOS DE SANCIONES QUE PUEDE TENER UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (88, 'SUSPENSION', 'ALMACENA LOS TIPOS DE SUSPENSION QUE PUEDE TENER UN JUGADOR POR COMETER UNA SANCION', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (89, 'RETIRO', 'ALMACENA LOS DIFERENTES MOTIVOS DE RETIROS DE UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (90, 'ESPECIALIDAD', 'ALMACENA LAS ESPECIALIDADES QUE PUEDE TENER UN MEDICO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (91, 'LOGRO', 'ALMACENA LOS DIFERENTES LOGROS O MERITOS QUE PUEDE RECIBIR UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (79, 'PARENTESCO', 'ALMACENA LOS DIFERENETES PARENTESCO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (80, 'PROFESION', 'ALMACENA LAS DIFERENTES PROFESIONES ', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (82, 'PROCESO', 'ALMACENA LOS DIFERENETES PROCESOS QUE PUEDE TENER UN RECAUDO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (84, 'TIPO_DOCUMENTO', 'ALMACENA LOS TIPOS DE DOCUMENTOS QUE PUEDE TENER UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (85, 'INSCRIPCION', 'ALMACENA LOS TIPOS DE INSCRIPCIONES QUE PUEDE TENER UN JUGADOR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (83, 'DOCUMENTO', 'ALMACENA LOS DOCUMENTOS QUE LE SON SOLICITADOS A UN JUGADOR', 'A', true, 84);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (81, 'IMPORTANCIA', 'ALMACENA LA IMPORTANCIA DEL DOCUMENTO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (93, 'INDICADOR ENTRENAMIENTO', 'INDICADORES A EVALUAR  EN EL ENTRENAMIENTO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (94, 'TIPO LAPSO DEPORTIVO', 'TIPIFICACION LAPSO DEPORTIVO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (95, 'DIA SEMANA', 'DIAS DE LA SEMANA', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (96, 'BRAZO_LANZAR', 'ALMACENA EL BRAZO QUE UTILIZA EL JUGADOR PARA LANZAR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (97, 'POSICION_BATEO', 'ALMACENA LA POSICION QUE USA EL JUGADOR PARA BATEAR', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (78, 'TALLA_INDUMENTARIA', 'ALMACENA LAS TALLAS DISPONIBLES POR INDUMENTARIA', 'A', true, 77);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (99, 'ESTADO CIVIL', 'ESTADO CIVIL', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (100, 'TIPO INSTALACION', 'ALMACENA LOS TIPOS DE INSTALACIONES CON LOS QUE CUENTA LA ESCUELA', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (101, 'TIPO TAREA', 'ALMACENA LOS TIPOS DE TAREAS QUE SE REALIZAN DENTRO DE LA ESCUELA', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (102, 'COMISION', 'ALMACENA LAS COMISIONES DE REPRESENTANTES QUE EXISTEN EN LA ESCUELA', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (103, 'UNIDAD DE MEDIDA', 'ALMACENA LAS UNIDADES DE MEDIDA QUE POSEEN LOS MATERIALES DEL ALMACEN', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (104, 'ESTADO ACTIVIDAD', 'ALMACENA LOS DISTINTOS ESTADOS POR LOS QUE PASA UNA ACTIVIDAD', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (105, 'RESULTADO ACTIVIDAD', 'ALMACENA LOS DISTINTOS RESULTADOS OBTENIDOS AL EJECUTAR UNA ACTIVIDAD', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (106, 'TIPO MATERIAL', 'ALMACENA EL TIPO DE UN MATERIAL. SI ES DEPORTIVO, DE MANTENIMIENTO, ETC', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (107, 'CLASIFICACION MATERIAL', 'ALMACENA LA CLASE DE UN MATERIAL DEPENDIENDO DEL TIPO AL QUE PERTENECE', 'A', true, 106);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (108, 'TIPO MANTENIMIENTO', 'ALMACENA EL TIPO DE UN MANTENIMIENTO. SI ES PREVENTIVO, CORRECTIVO , ETC', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (109, 'CLASIFICACION DE MANTENIMIENTO', 'ALMACENA LA CLASE DE UN MANTENIMIENTO DEPENDIENDO DE SU TIPO', 'A', true, 108);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (110, 'TAREA', 'ALMACENA LAS TAREAS NECESARIAS PARA COMPLETAR UNA ACTIVIDAD', 'A', true, 101);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (98, 'GENERO', 'GENERO', 'A', true, NULL);
INSERT INTO tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, tipo, parent_codigo_tipo_dato) VALUES (92, 'ASCENSO', 'ALMACENA LOS TIPOS DE ASCENSO DE CATEGORIA QUE PUEDE TENER UN JUGADOR', 'A', true, NULL);


--
-- TOC entry 3028 (class 0 OID 54291)
-- Dependencies: 1956 3130
-- Data for Name: dato_basico; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (145, 82, 'INSCRIPCION', 'PROCESO DE LA ORGANIZACION', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (146, 82, 'ASCENSO', 'PROCESO DE LA ORGANIZACION', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (1, 64, 'VENEZUELA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (147, 84, 'PERSONAL', 'DOCUMENTOS PERSONALES', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (3, 65, 'ANZOATEGUI', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (2, 65, 'AMAZONAS', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (4, 65, 'APURE', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (5, 65, 'ARAGUA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (6, 65, 'BARINAS', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (7, 65, 'BOLIVAR', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (8, 65, 'CARABOBO', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (9, 65, 'COJEDES', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (10, 65, 'DELTA AMACURO', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (11, 65, 'DISTRITO CAPITAL', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (12, 65, 'FALCON', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (15, 65, 'MERIDA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (13, 65, 'GUARICO', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (14, 65, 'LARA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (18, 65, 'NUEVA ESPARTA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (17, 65, 'MONAGAS', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (19, 65, 'PORTUGUESA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (16, 65, 'MIRANDA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (20, 65, 'SUCRE', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (23, 65, 'VARGAS', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (21, 65, 'TACHIRA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (22, 65, 'TRUJILLO', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (25, 65, 'ZULIA', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (27, 66, 'CRESPO', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (24, 65, 'YARACUY', NULL, 'A', 1);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (26, 66, 'ANDRES ELOY BLANCO', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (28, 66, 'IRIBARREN', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (29, 66, 'JIMENEZ', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (30, 66, 'MORAN', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (31, 66, 'PALAVECINOS', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (32, 66, 'SIMON PLANAS', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (33, 66, 'TORRES', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (34, 66, 'URDANETA', NULL, 'A', 14);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (35, 67, 'SANTA ROSA', NULL, 'A', 28);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (36, 67, 'CATEDRAL', NULL, 'A', 28);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (37, 67, 'CONCEPCION', NULL, 'A', 28);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (38, 68, '0251', 'BARQUISIMETO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (39, 68, '0254', 'SAN FELIPE', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (40, 68, '0255', 'ACARIGUA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (41, 69, '0412', 'DIGITEL', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (42, 69, '0414', 'MOVISTAR', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (43, 69, '0416', 'MOVILNET', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (44, 69, '0424', 'MOVISTAR', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (45, 69, '0426', 'MOVILNET', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (46, 70, 'A', 'GRUPO A', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (47, 70, 'B', 'GRUPO B', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (48, 70, 'AB', 'GRUPO AB', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (49, 70, 'O', 'GRUPO O', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (50, 71, 'RH+', 'POSITIVO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (51, 71, 'RH-', 'NEGATIVO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (53, 72, 'LESION', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (52, 72, 'AFECCION', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (55, 49, 'ASMA', NULL, 'A', 52);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (56, 49, 'SINUSITIS', NULL, 'A', 52);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (54, 49, 'ALERGIA', NULL, 'A', 52);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (61, 73, '2DO NIVEL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (57, 49, 'FRACTURA DE MUÑECA', NULL, 'A', 53);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (58, 49, 'TORCEDURA DEL TOBILLO', NULL, 'A', 53);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (59, 49, 'FRACTURA DE RADIO', NULL, 'A', 53);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (63, 73, '1ER GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (62, 73, '3ER NIVEL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (64, 73, '2DO GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (65, 73, '3ER GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (67, 73, '5TO GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (66, 73, '4TO GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (68, 73, '6TO GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (69, 73, '7MO GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (70, 73, '8VO GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (72, 73, 'CUARTO AÑO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (71, 73, '9NO GRADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (73, 73, 'QUINTO AÑO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (76, 74, '2010-2011', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (74, 73, 'SEXTO AÑO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (60, 73, '1ER NIVEL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (75, 74, '2009-2010', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (77, 74, '2011-2012', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (78, 74, '2012-2013', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (79, 75, 'DANZA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (82, 75, 'TEATRO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (81, 75, 'PINTURA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (83, 75, 'FUTBOL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (85, 75, 'OTRO DEPORTE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (84, 75, 'BASKETBALL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (86, 75, 'OTRA ACTIVIDAD', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (80, 75, 'MUSICA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (87, 76, 'A', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (89, 76, 'C', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (88, 76, 'B', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (90, 76, 'D', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (91, 76, 'E', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (92, 76, 'F', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (95, 77, 'CALZADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (114, 79, 'ABUELO(A)', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (93, 77, 'CAMISA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (113, 79, 'MADRE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (115, 79, 'HERMANO(A)', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (116, 79, 'TIO(A)', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (118, 79, 'OTRO(A)', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (117, 79, 'PRIMO(A)', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (120, 80, 'LIC.EN EDUCACION', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (112, 79, 'PADRE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (122, 80, 'PINTOR', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (121, 80, 'INGENIERO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (123, 80, 'MEDICO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (124, 80, 'QUIMICO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (128, 81, 'OPCIONAL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (126, 92, 'ESPECIAL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (125, 92, 'EDAD', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (119, 80, 'ABOGADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (131, 86, 'EDUCATIVA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (127, 81, 'OBLIGATORIO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (130, 85, 'REINGRESO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (129, 85, 'NUEVO INGRESO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (132, 86, 'RECREATIVA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (139, 90, 'CIRUJANO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (135, 88, 'DIA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (136, 88, 'JUEGO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (137, 89, 'POR ENFERMEDAD', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (138, 89, 'POR VIAJE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (140, 90, 'OTORRINOLARINGOLOGO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (134, 87, 'Mala Conducta', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (133, 87, 'FALTA A UN COMPAÑERO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (142, 91, 'CHAMPION EN PITCHEO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (141, 91, 'CHAMPION EN BATEO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (148, 84, 'ACADEMICO', 'DOCUMENTO ACADEMICO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (149, 82, 'ACTUALIZACION', 'PROCESO DE LA ORGANIZACION', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (150, 84, 'MEDICO', 'DOCUMENTO MEDICO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (151, 83, 'PARTIDA DE NACIMIENTO', 'PARTIDA DE NACIMIENTO', 'A', 147);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (152, 83, 'CONSTANCIA DE ESTUDIOS', 'CONSTANCIA DE ESTUDIOS', 'A', 148);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (153, 1, 'CALENTAMIENTO', 'ETAPA PREVIA PARA CALENTAR LOS MUSCULOS', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (154, 1, 'TECNICA', 'ETAPA DONDE SE PRACTICAN LAS HABILIDADES TECNICAS', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (155, 8, 'CUALITATIVA', 'ESCALA NO CONTABILIZABLE', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (156, 9, 'CUANTITATIVA', 'ESCALA CONTABILIZABLE', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (157, 93, 'FUERZA', '---', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (158, 93, 'VELOCIDAD', '---', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (159, 94, 'PLAN VACACIONAL', '---', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (160, 94, 'TEMPORADA REGULAR', '---', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (161, 50, 'SEMANAL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (162, 50, 'QUINCENAL', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (205, 51, 'OBRERO', NULL, 'A', 161);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (206, 51, 'EMPLEADO', NULL, 'A', 162);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (163, 52, 'ASIGNACION', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (164, 52, 'DEDUCCION', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (165, 53, 'SECRETARIA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (166, 53, 'MANAGER', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (167, 53, 'MONITOR', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (168, 53, 'MANTENIMIENTO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (169, 54, 'PERSONAL REMUNERADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (170, 54, 'PERSONAL ADHONOREN', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (171, 54, 'REPRESENTANTE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (172, 54, 'JUGADOR', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (173, 54, 'CLIENTE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (174, 54, 'PROVEEDOR DE SERVICIO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (175, 54, 'PROVEEDOR DE MATERIALES', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (176, 55, 'PAGO REPRESENTANTE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (177, 55, 'PUBLICIDAD', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (178, 55, 'APORTE ESPECIALES', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (179, 55, 'DONACION', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (180, 55, 'PAGO REPRESENTANTE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (181, 56, 'NOMINA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (182, 56, 'ADQUISION', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (183, 56, 'SERVICIO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (184, 56, 'BONOS Y VIATICOS', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (185, 56, 'LIQUIDACION EMPLEADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (186, 57, 'VENEZUELA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (187, 57, 'BOD', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (188, 57, 'BANESCO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (189, 58, 'TARJETA DE CREDITO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (190, 58, 'EFECTIVO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (191, 58, 'CHEQUE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (192, 58, 'TRANSFERENCIA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (193, 58, 'TARJETA DE DEBITO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (194, 58, 'DEPOSITO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (195, 59, 'FACTURA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (196, 59, 'RECIBO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (197, 59, 'ORDEN DE PAGO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (198, 60, 'TIEMPO COMPLETO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (199, 60, 'MEDIO TIEMPO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (200, 61, 'AHORRRO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (201, 61, 'CORRIENTE', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (202, 62, 'MASTER CARD', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (203, 63, 'FIJO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (204, 63, 'CONTRATO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (207, 96, 'ZURDO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (208, 96, 'DERECHO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (209, 96, 'AMBIDIESTRO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (210, 97, 'ZURDO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (211, 97, 'DERECHO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (213, 97, 'AMBIDIESTRO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (214, 98, 'MASCULINO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (215, 98, 'FEMENINO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (216, 99, 'SOLTERO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (217, 99, 'CASADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (218, 99, 'VIUDO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (219, 99, 'DIVORCIADO', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (220, 100, 'AREAS VERDES', 'AREAS VERDES DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (221, 100, 'TERRENO DEL CAMPO', 'LUGAR DONDE SE REALIZAN LAS COMPETENCIAS Y ENTRENAMIENTOS DE LOS NIÑOS', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (222, 100, 'AREAS INTERNAS ', 'AREAS INTERNAS DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (223, 101, 'TAREA DE MANTENIMIENTO', 'TAREAS REALIZADAS POR EL PERSONAL DE MANTENIMIENTO DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (224, 101, 'TAREA PARA ACTIVIDADES COMPLEMENTARIAS', 'TAREAS REALIZADAS PARA LLEVAR ACABO LAS ACTIVIDADES COMPLEMENTARIAS', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (225, 110, 'CORTAR CESPED', 'TAREA REALIZADA PARA MANTENER EL CESPED A LA ALTURA CORRECTA', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (226, 110, 'IRRIGAR EL CAMPO', 'TAREA REALIZADA PARA PROPORCIONAR EL AGUA NECESRIA AL CAMPO', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (227, 110, 'EXPLANAR CAMPO', 'TAREA REALIZADA PARA ALISAR LAS AREAS SIN CESPED', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (228, 110, 'RASTRILLAR CAMPO', 'TAREA REALIZADA PARA ALISAR AREAS SECAS DEL CAMPO', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (229, 110, 'MARCAR CAMPO', 'TAREA QUE PERMITE REALIZAR LA SEPARACION DE LAS AREAS DEL CAMPO', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (230, 110, 'APISIONAR CAMPO', 'TAREA REALIZADA PARA COMPACTAR LA ARCILLA EN LAS AREAS DEL MONTICULO Y HOME', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (231, 110, 'COLOCAR LONA', 'TAREA REALIZADA PARA PROTEGER AL CAMPO DE LA LLUVIA', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (232, 110, 'AIREACION DEL CAMPO', 'TAREA REALIZADA PARA MANTENER AL CAMPO EN BUENAS CONDICIONES', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (233, 110, 'FERTILIZAR EL CAMPO', 'TAREA REALIZADA PARA MANTENER EL CAMPO CON LOS NUTRIENTES QUE NECESITA', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (234, 110, 'ASEAR OFICINAS', 'TAREA REALIZADA PARA MANTENER LAS OFICINAS EN OPTIMAS CONDICIONES', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (235, 110, 'ASEAR BANNOS', 'TAREA REALIZADA PARA MANTENER LOS BANNOS EN BUENAS CONDICIONES', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (236, 110, 'CORTAR GRAMA', 'TAREA REALIZADA PARA MANTENER LAS AREAS VERDES DE LA ESCUELA', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (237, 110, 'REGAR GRAMA', 'TAREA REALIZADA PARA PROPORCIONAR LA HUMEDAD NECESATRIA A LAS AREAS VERDES DE LA ESCUELA', 'A', 223);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (238, 110, 'ADORNAR INSTALACIONES', 'TAREA REALIZADA PARA AMBIENTAR LAS INSTLACIONES', 'A', 224);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (239, 110, 'CONTRATAR SONIDO', 'TAREA REALIZADA PARA BRINDAR SONIDO A LAS ACTIVIDADES', 'A', 224);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (240, 110, 'CONTRATAR FESTEJO', 'TAREA REALIZADA PARA CONTRATAR EL FESTEJO PARA UNA ACTIVIDAD', 'A', 224);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (241, 110, 'PREPARAR COMIDA', 'TAREA REALIZADA PARA PROPORCIONAR LA COMIDA NECESARIA A LAS ACTIVIDADES', 'A', 224);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (242, 110, 'SUPLIR BEBIDAS', 'TAREA REALIZADA PARA PROPORCINAR LAS BEBIDAS NECESARIAS A LAS ACTIVIDADES', 'A', 224);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (243, 102, 'COMISION DE DISCIPLINA', 'COMISION ENCARGADA DE MANTENER EL BUEN COMPORTAMIENTO DE LOS JUGADORES', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (96, 78, 'SS', NULL, 'A', 93);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (94, 77, 'PANTALON', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (98, 78, 'M', NULL, 'A', 93);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (97, 78, 'S', NULL, 'A', 93);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (99, 78, 'L', NULL, 'A', 93);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (101, 78, 'XS', NULL, 'A', 94);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (100, 78, 'XL', NULL, 'A', 93);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (102, 78, 'S-7', NULL, 'A', 94);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (103, 78, 'M-8/10', NULL, 'A', 94);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (105, 78, 'XL-16', NULL, 'A', 94);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (104, 78, 'L-12/14', NULL, 'A', 94);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (106, 78, 'XXL', NULL, 'A', 94);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (107, 78, '25', NULL, 'A', 95);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (109, 78, '27', NULL, 'A', 95);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (108, 78, '26', NULL, 'A', 95);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (110, 78, '28', NULL, 'A', 95);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (111, 78, '29', NULL, 'A', 95);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (144, 91, 'JUGADOR MAS VALIOSO DE LA TEMPORADA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (244, 102, 'COMISION DE CAMPO', 'COMISION ENCARGADA DE COLABORAR EN LOS ENTRENAMIENTOS DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (245, 102, 'COMISION DE EVENTOS ESPECIALES', 'COMISION ENCARGADA DE LA ORGANIZACION DE LOS EVENTOS DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (246, 102, 'COMISION DE MEDIOS', 'COMISION ENCARGADA DE LOS MEDIOS DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (247, 103, 'KG', 'UNIDAD DE MEDIDA QUE INDICA EL PESO DE UN MATERIAL', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (248, 103, 'GR', 'UNIDAD DE MEDIDA QUE INDICA EL PESO ENKILOGRAMOS DE UN MATERIAL', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (249, 103, 'LTRS', 'UNIDAD DE MEDIDA QUE INDICA LOS LITROS DE UN MATERIAL', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (250, 103, 'MLTRS', 'UNIDAD DE MEDIDA QUE INDICA LOS MILILITROS DE UN MATERIAL ', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (251, 104, 'POR EJECUTAR', 'ESTADO QUE INDICA QUE UNA ACTIVIDAD AUN NO SE ESTA REALIZANDO ', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (252, 104, 'EJECUTANDOSE', 'ESTADO QUE INDICA QUE UNA ACTIVIDAD ESTA SIENDO LLEVASA ACABO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (253, 104, 'SUSPENDIDA', 'ESTADO QUE INDICA QUE UNA ACTIVIDAD FUE SUSPENDIDA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (254, 104, 'TERMINADA', 'ESTADO QUE INDICA QUE UNA ACTIVIDAD SE CULMINO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (255, 105, 'EJECUTADA SEGUN LO PLANIFICADO', 'RESULTADO QUE INDICA QUE UNA ACTIVIDAD FUE LLEVADA ACABO SEGUN SE PLANIFICO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (256, 105, 'SUSPENDIDA POR FALTA DE MATERIAL', 'RESULTADO QUE UNA ACTIVIDAD NO SE LLEVO ACABO POR FALTA DE MATERIALES', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (257, 105, 'SUSPENDIDA POR FALTA DE PERSONAL', 'RESULTADO QUE INDICA QUE UNA ACTIVIDAD NO SE EJECUTO POR FALTA DE PERSONAL', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (258, 105, 'EJECUTADA CON MENOS MATERIALES DE LO PREVISTO', 'RESULTADO QUE INDICA QUE UNA ACTIVIDAD FUE LLEVADA ACABO PERO NO SEGUN LO PLANIFICADO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (259, 105, 'EJECUTADA CON MENOS DEL PERSONAL DE LO PREVISTO', 'RESULTADO QUE INDICA QUE UNA ACTIVIDAD FUE LLEVADA ACABO PERO NO SEGUN LO PLANIFICADO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (260, 106, 'MATERIALES DE OFICINA', 'MATERIALES USADOS PARA LAS LABORES DE OFICINA DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (261, 106, 'MATERIALES DE MANTENIMIENTO', 'MATERIALES USADOS PARA LAS MANTENIMIENTOS DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (262, 106, 'MATERIALES DEPORTIVOS', 'MATERIALES USADOS PARA LAS ACTIVIDADES DEPORTIVAS DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (263, 107, 'HOJAS BLANCA', 'MATERIALES USADOS PARA IMPRIMIR DOCUMENTOS', 'A', 260);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (264, 107, 'GRAPAS', 'MATERIALES USADOS PARA LA GRAPADORA', 'A', 260);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (265, 107, 'BOLIGRAFOS', 'MATERIALES USADOS PARA ESCRIBIR', 'A', 260);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (266, 107, 'CAL', 'MATERIALES USADOS PARA MARCAR EL CAMPO', 'A', 261);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (267, 107, 'RASTRILLO', 'MATERIALES USADOS PARA RASTRILLAR EL CAMPO', 'A', 261);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (268, 107, 'FERTILIZANTE', 'MATERIALES USADOS PARA FERTILIZAR EL CAMPO', 'A', 261);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (269, 107, 'CLORO', 'MATERIALES USADOS PARA ASEAR LAS INSTALACIONES INTERNAS', 'A', 261);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (270, 107, 'CEPILLO PARA BARRER', 'MATERIALES USADOS PARA QUITAR RESIDUO DELAS INSTALACIONES INTERNAS', 'A', 261);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (271, 107, 'DESINFECTANTE', 'MATERIALES USADOS PARA EL ASEO DE LAS INSTALACIONES INTERNAS', 'A', 261);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (272, 107, 'GUANTE', 'MATERIALES USADO PARA ATAJAR LAS PELOTAS', 'A', 262);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (273, 107, 'CASCO', 'MATERIALES USADO PROTEGER EL CRANEO DE LOS JUGADORES', 'A', 262);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (274, 108, 'PREVENTIVO', 'MANTENIMIENTO REALIZADO PARA PREVEER EL MAL ESTADO DE UN AREA DE LA ESCUELA', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (275, 108, 'CORRECTIVO', 'MANTENIMIENTO REALIZADO UNA VEZ QUE UN AREA DE LA ESCUELA SE ENCUENTRA EN MAL ESTADO', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (276, 109, 'MANTENIMIENTO DEL CAMPO', 'MANTENIMIENTO REALIZADO PARA PREVEER EL MAL ESTADO DEL CAMPO', 'A', 274);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (277, 109, 'LIMPIAR AREAS INTERNAS', 'MANTENIMIENTO REALIZADO PARA PREVEER EL MAL ESTADO DE LAS INSTALACIONES DE LA ESCUELA', 'A', 274);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (278, 109, 'REPARAR APLANADORA', 'MANTENIMIENTO REALIZADO EN CASO DE QUE SE DESCOMPONGA LA APLANADORA DEL CAMPO', 'A', 275);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (279, 109, 'CAMBIAR GRIFOS', 'MANTENIMIENTO REALIZADO EN CASO DE QUE SE DESCOMPONGA UN GRIFO DE AGUA', 'A', 275);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (143, 91, 'JUGADOR MAS VALIOSO DE LA CATEGORIA', NULL, 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (280, 83, 'INFORME MEDICO', NULL, 'A', 150);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (281, 84, 'ESPECIAL', 'DOCUMENTOS DE ASCENSO ESPECIAL', 'A', NULL);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (282, 83, 'INFORME DEL REPRESENTANTE', NULL, 'A', 281);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (283, 83, 'INFORME DEL MANAGER', NULL, 'A', 281);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (284, 83, 'INFORME DEL DELEGADO', NULL, 'A', 281);
INSERT INTO dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_dato_basico) VALUES (285, 83, 'INFORME DEL PRESIDENTE DEL DIRECTORIO DE LIGA', NULL, 'A', 281);


--
-- TOC entry 3071 (class 0 OID 54529)
-- Dependencies: 2019 3028
-- Data for Name: instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3110 (class 0 OID 54779)
-- Dependencies: 2081 3028 3071
-- Data for Name: planificacion_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3004 (class 0 OID 54141)
-- Dependencies: 1917 3110
-- Data for Name: actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3076 (class 0 OID 54567)
-- Dependencies: 2028 3028
-- Data for Name: lapso_deportivo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3129 (class 0 OID 54899)
-- Dependencies: 2113
-- Data for Name: tipo_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3019 (class 0 OID 54231)
-- Dependencies: 1941 3028 3028 3028 3076 3129
-- Data for Name: competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3056 (class 0 OID 54447)
-- Dependencies: 1996 3028
-- Data for Name: estadio; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3073 (class 0 OID 54545)
-- Dependencies: 2023 3019 3028 3056
-- Data for Name: juego; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3005 (class 0 OID 54144)
-- Dependencies: 1918 3004 3019 3028 3073
-- Data for Name: actividad_calendario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3015 (class 0 OID 54212)
-- Dependencies: 1935
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) VALUES (1, 'Preparatorio I Nivel', 3, 5, 6, 12, 20, 'A');
INSERT INTO categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) VALUES (2, 'Preparatorio II Nivel', 6, 7, 6, 12, 20, 'A');
INSERT INTO categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) VALUES (3, 'Preinfantil', 8, 9, 6, 12, 20, 'A');
INSERT INTO categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) VALUES (4, 'Infantil', 10, 11, 6, 12, 20, 'A');
INSERT INTO categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) VALUES (5, 'PreJunior', 12, 13, 6, 12, 20, 'A');
INSERT INTO categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) VALUES (6, 'Junior', 14, 15, 6, 12, 20, 'A');
INSERT INTO categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) VALUES (7, 'Juvenil', 16, 17, 6, 12, 20, 'A');


--
-- TOC entry 3006 (class 0 OID 54154)
-- Dependencies: 1921 3015 3028
-- Data for Name: actividad_entrenamiento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3038 (class 0 OID 54349)
-- Dependencies: 1971 3028
-- Data for Name: divisa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO divisa (codigo_divisa, codigo_parroquia, nombre, direccion, telefono, correo_electronico, persona_contacto, logo, estatus) VALUES (1, 28, 'Fundalara', 'Oficina Barquisimeto Este, Urbanización Fundalara Av Caroní con Bélgica', '0251-2530910', 'jose_mt@hotmail.co', 'Jose Luis Montero', NULL, 'A');


--
-- TOC entry 3052 (class 0 OID 54418)
-- Dependencies: 1988 3015 3028 3038
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO equipo (codigo_equipo, codigo_clasificacion, codigo_categoria, codigo_divisa, nombre, estatus) VALUES (1, 87, 1, 1, 'Preparatoriol I A', 'A');
INSERT INTO equipo (codigo_equipo, codigo_clasificacion, codigo_categoria, codigo_divisa, nombre, estatus) VALUES (2, 88, 1, 1, 'Preparatorio I B', 'A');
INSERT INTO equipo (codigo_equipo, codigo_clasificacion, codigo_categoria, codigo_divisa, nombre, estatus) VALUES (3, 87, 2, 1, 'Preparatoriol II A', 'A');
INSERT INTO equipo (codigo_equipo, codigo_clasificacion, codigo_categoria, codigo_divisa, nombre, estatus) VALUES (4, 88, 2, 1, 'Preparatorio II B', 'A');
INSERT INTO equipo (codigo_equipo, codigo_clasificacion, codigo_categoria, codigo_divisa, nombre, estatus) VALUES (5, 87, 3, 1, 'Preinfantil A', 'A');
INSERT INTO equipo (codigo_equipo, codigo_clasificacion, codigo_categoria, codigo_divisa, nombre, estatus) VALUES (6, 88, 3, 1, 'Preinfantil B', 'A');


--
-- TOC entry 3055 (class 0 OID 54439)
-- Dependencies: 1994 3028
-- Data for Name: escala_medicion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3065 (class 0 OID 54494)
-- Dependencies: 2009 3006 3028 3055
-- Data for Name: indicador_actividad_escala; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3092 (class 0 OID 54668)
-- Dependencies: 2054 3028 3028
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

--
-- TOC entry 3085 (class 0 OID 54619)
-- Dependencies: 2042 3028
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO medico (numero_colegio, codigo_especialidad, matricula, cedula_medico, nombre, apellido, telefono_oficina, telefono_celular, fecha_ingreso, estatus) VALUES ('123456', 140, '12345', 'V-15100100', 'Gregory', 'House', '0416-1002020', '0416-2010101', '2011-10-10', 'A');


--
-- TOC entry 3032 (class 0 OID 54318)
-- Dependencies: 1963 3074 3085
-- Data for Name: dato_medico; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3009 (class 0 OID 54173)
-- Dependencies: 1926 3028 3032
-- Data for Name: afeccion_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 3010 (class 0 OID 54176)
-- Dependencies: 1927 3028 3095
-- Data for Name: afeccion_personal; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3011 (class 0 OID 54182)
-- Dependencies: 1928 3071
-- Data for Name: almacen; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3118 (class 0 OID 54827)
-- Dependencies: 2092 3052 3074
-- Data for Name: roster; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 3012 (class 0 OID 54190)
-- Dependencies: 1930 3118
-- Data for Name: ascenso; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3013 (class 0 OID 54198)
-- Dependencies: 1932 3028 3118 3121
-- Data for Name: asistencia_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3101 (class 0 OID 54728)
-- Dependencies: 2066 3052 3073 3095 3109
-- Data for Name: personal_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3014 (class 0 OID 54206)
-- Dependencies: 1934 3101 3121 3132
-- Data for Name: asistencia_personal_entrenamiento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3016 (class 0 OID 54220)
-- Dependencies: 1937 3015 3019
-- Data for Name: categoria_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3017 (class 0 OID 54223)
-- Dependencies: 1938 3004 3028
-- Data for Name: comision_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3018 (class 0 OID 54226)
-- Dependencies: 1939 3028 3052
-- Data for Name: comision_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3020 (class 0 OID 54239)
-- Dependencies: 1943 3028
-- Data for Name: concepto_nomina; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3021 (class 0 OID 54247)
-- Dependencies: 1945 3028 3129
-- Data for Name: condicion_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3022 (class 0 OID 54250)
-- Dependencies: 1946
-- Data for Name: constante; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3023 (class 0 OID 54256)
-- Dependencies: 1947 3015 3022
-- Data for Name: constante_categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3024 (class 0 OID 54263)
-- Dependencies: 1950 3028 3028 3092
-- Data for Name: cuenta_pagar; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3082 (class 0 OID 54600)
-- Dependencies: 2037 3011 3028 3028
-- Data for Name: material; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3025 (class 0 OID 54269)
-- Dependencies: 1951 3024 3082 3082
-- Data for Name: cuenta_pagar_material; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3072 (class 0 OID 54537)
-- Dependencies: 2021 3028 3028
-- Data for Name: institucion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO institucion (codigo_institucion, codigo_parroquia, codigo_tipo_institucion, nombre, direccion, estatus) VALUES (1, 37, 131, 'Escuela Bolivariana Bolivia Tovar', 'Barquisimeto', 'A');
INSERT INTO institucion (codigo_institucion, codigo_parroquia, codigo_tipo_institucion, nombre, direccion, estatus) VALUES (2, 37, 131, 'Escuela Bolivariana Dr. Ramón Gualdron', 'Barquisimeto', 'A');
INSERT INTO institucion (codigo_institucion, codigo_parroquia, codigo_tipo_institucion, nombre, direccion, estatus) VALUES (3, 37, 132, 'Escuela de Fútbol Menor Polideportivo Máximo Viloria', 'Barquisimeto', 'A');
INSERT INTO institucion (codigo_institucion, codigo_parroquia, codigo_tipo_institucion, nombre, direccion, estatus) VALUES (4, 37, 132, 'Conservatorio Vicente Emilio Sojo', 'Barquisimeto', 'A');


--
-- TOC entry 3026 (class 0 OID 54275)
-- Dependencies: 1952 3028 3028 3072 3074
-- Data for Name: dato_academico; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 3027 (class 0 OID 54283)
-- Dependencies: 1954 3095
-- Data for Name: dato_academico_personal; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3030 (class 0 OID 54304)
-- Dependencies: 1960 3028 3074
-- Data for Name: dato_conducta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3031 (class 0 OID 54312)
-- Dependencies: 1962 3019 3074
-- Data for Name: dato_deportivo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3033 (class 0 OID 54326)
-- Dependencies: 1965 3028 3072 3074
-- Data for Name: dato_social; Type: TABLE DATA; Schema: public; Owner: postgres
--

--
-- TOC entry 3053 (class 0 OID 54426)
-- Dependencies: 1990 3019 3052 3092
-- Data for Name: equipo_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3054 (class 0 OID 54434)
-- Dependencies: 1992 3053 3073
-- Data for Name: equipo_juego; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3064 (class 0 OID 54488)
-- Dependencies: 2008 3028 3028
-- Data for Name: indicador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3066 (class 0 OID 54499)
-- Dependencies: 2011 3015 3019 3064
-- Data for Name: indicador_categoria_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3034 (class 0 OID 54334)
-- Dependencies: 1967 3054 3066
-- Data for Name: desempenno_colectivo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3119 (class 0 OID 54835)
-- Dependencies: 2094 3019 3028 3028 3118
-- Data for Name: roster_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3080 (class 0 OID 54589)
-- Dependencies: 2034 3028 3028 3073 3119
-- Data for Name: line_up; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3035 (class 0 OID 54337)
-- Dependencies: 1968 3066 3080
-- Data for Name: desempenno_individual; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3036 (class 0 OID 54340)
-- Dependencies: 1969 3008 3013 3132
-- Data for Name: desempeo_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3115 (class 0 OID 54807)
-- Dependencies: 2088 3095
-- Data for Name: requisicion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3037 (class 0 OID 54346)
-- Dependencies: 1970 3082 3115
-- Data for Name: detalle_requisicion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3112 (class 0 OID 54790)
-- Dependencies: 2084 3028 3028 3028
-- Data for Name: recaudo_por_proceso; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO recaudo_por_proceso (codigo_recaudo_por_proceso, codigo_importancia, codigo_proceso, codigo_documento, cantidad, estatus) VALUES (1, 127, 129, 152, 2, 'A');
INSERT INTO recaudo_por_proceso (codigo_recaudo_por_proceso, codigo_importancia, codigo_proceso, codigo_documento, cantidad, estatus) VALUES (2, 127, 129, 151, 1, 'A');
INSERT INTO recaudo_por_proceso (codigo_recaudo_por_proceso, codigo_importancia, codigo_proceso, codigo_documento, cantidad, estatus) VALUES (3, 128, 129, 280, 1, 'A');


--
-- TOC entry 3044 (class 0 OID 54377)
-- Dependencies: 1979 3112
-- Data for Name: documento_entregado; Type: TABLE DATA; Schema: public; Owner: postgres
--


INSERT INTO talla_por_indumentaria (codigo_talla_indumentaria, codigo_talla, precio, estatus) VALUES (1, 96, 50, 'A');
INSERT INTO talla_por_indumentaria (codigo_talla_indumentaria, codigo_talla, precio, estatus) VALUES (2, 101, 50, 'A');
INSERT INTO talla_por_indumentaria (codigo_talla_indumentaria, codigo_talla, precio, estatus) VALUES (3, 107, 50, 'A');


--
-- TOC entry 3045 (class 0 OID 54383)
-- Dependencies: 1980 3040 3123
-- Data for Name: documento_indumentaria; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3046 (class 0 OID 54386)
-- Dependencies: 1981 3032 3044
-- Data for Name: documento_medico; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 3047 (class 0 OID 54389)
-- Dependencies: 1982 3044 3074
-- Data for Name: documento_personal; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 3048 (class 0 OID 54397)
-- Dependencies: 1984 3040 3082
-- Data for Name: donacion_material; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3049 (class 0 OID 54400)
-- Dependencies: 1985
-- Data for Name: egreso; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3050 (class 0 OID 54406)
-- Dependencies: 1986 3024 3049
-- Data for Name: egreso_cuenta_pagar; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3051 (class 0 OID 54412)
-- Dependencies: 1987 3028 3028 3049
-- Data for Name: egreso_forma_pago; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3057 (class 0 OID 54455)
-- Dependencies: 1998 3004 3028
-- Data for Name: estado_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3058 (class 0 OID 54458)
-- Dependencies: 1999 3028 3092
-- Data for Name: familiar; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3060 (class 0 OID 54467)
-- Dependencies: 2001 3028 3058 3074
-- Data for Name: familiar_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3059 (class 0 OID 54464)
-- Dependencies: 2000 3018 3060
-- Data for Name: familiar_comision_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3061 (class 0 OID 54475)
-- Dependencies: 2003 3019
-- Data for Name: fase_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3062 (class 0 OID 54478)
-- Dependencies: 2004 3028 3109
-- Data for Name: horario; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3063 (class 0 OID 54483)
-- Dependencies: 2006 3019 3060
-- Data for Name: hospedaje; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3127 (class 0 OID 54888)
-- Dependencies: 2110 3052
-- Data for Name: test_evaluativo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3067 (class 0 OID 54506)
-- Dependencies: 2014 3028 3055 3127
-- Data for Name: indicador_test; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3068 (class 0 OID 54511)
-- Dependencies: 2016 3028
-- Data for Name: ingreso; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3069 (class 0 OID 54517)
-- Dependencies: 2017 3040 3068
-- Data for Name: ingreso_documento_acreedor; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3070 (class 0 OID 54523)
-- Dependencies: 2018 3028 3028 3028 3068
-- Data for Name: ingreso_forma_pago; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3075 (class 0 OID 54559)
-- Dependencies: 2026 3028 3053 3073
-- Data for Name: jugador_foraneo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3077 (class 0 OID 54575)
-- Dependencies: 2030 3028
-- Data for Name: liga; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3078 (class 0 OID 54581)
-- Dependencies: 2031 3015 3077
-- Data for Name: liga_categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3079 (class 0 OID 54586)
-- Dependencies: 2033 3019 3077
-- Data for Name: liga_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3081 (class 0 OID 54594)
-- Dependencies: 2036 3028 3031
-- Data for Name: logro_por_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3083 (class 0 OID 54606)
-- Dependencies: 2038 3004 3082
-- Data for Name: material_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3084 (class 0 OID 54614)
-- Dependencies: 2040 3082 3110
-- Data for Name: material_actividad_planificada; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3086 (class 0 OID 54625)
-- Dependencies: 2043 3129
-- Data for Name: modalidad_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3087 (class 0 OID 54633)
-- Dependencies: 2045 3028 3030
-- Data for Name: motivo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3089 (class 0 OID 54644)
-- Dependencies: 2048 3024 3028
-- Data for Name: nomina; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3088 (class 0 OID 54636)
-- Dependencies: 2046 3020 3089 3095
-- Data for Name: movimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3090 (class 0 OID 54652)
-- Dependencies: 2050 3024 3040
-- Data for Name: nota_entrega; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3091 (class 0 OID 54660)
-- Dependencies: 2052 3110
-- Data for Name: periodicidad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3093 (class 0 OID 54674)
-- Dependencies: 2055 3092
-- Data for Name: persona_juridica; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3096 (class 0 OID 54692)
-- Dependencies: 2058 3004 3095
-- Data for Name: personal_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3097 (class 0 OID 54698)
-- Dependencies: 2059 3095 3110
-- Data for Name: personal_actividad_planificada; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3098 (class 0 OID 54704)
-- Dependencies: 2060 3028 3095
-- Data for Name: personal_cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3099 (class 0 OID 54712)
-- Dependencies: 2062 3020 3095
-- Data for Name: personal_concepto_nomina; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3100 (class 0 OID 54720)
-- Dependencies: 2064 3028 3028 3095
-- Data for Name: personal_contrato; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3102 (class 0 OID 54736)
-- Dependencies: 2068 3054 3101
-- Data for Name: personal_equipo_juego; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3103 (class 0 OID 54739)
-- Dependencies: 2069 3028
-- Data for Name: personal_foraneo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3104 (class 0 OID 54747)
-- Dependencies: 2071 3028 3073 3103
-- Data for Name: personal_foraneo_juego; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3105 (class 0 OID 54750)
-- Dependencies: 2072 3028 3073 3095
-- Data for Name: personal_juego; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3106 (class 0 OID 54756)
-- Dependencies: 2073 3028 3095
-- Data for Name: personal_tipo_nomina; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3111 (class 0 OID 54784)
-- Dependencies: 2083 3028 3093
-- Data for Name: proveedor_banco; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3113 (class 0 OID 54795)
-- Dependencies: 2086 3082 3090
-- Data for Name: recepcion_material; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3114 (class 0 OID 54801)
-- Dependencies: 2087 3060
-- Data for Name: representante; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3116 (class 0 OID 54815)
-- Dependencies: 2090 3004 3028
-- Data for Name: resultado_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3117 (class 0 OID 54821)
-- Dependencies: 2091 3028 3074
-- Data for Name: retiro_traslado; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3120 (class 0 OID 54840)
-- Dependencies: 2096 3028 3130 3132
-- Data for Name: seguridad_funcional; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3122 (class 0 OID 54855)
-- Dependencies: 2101 3004 3028
-- Data for Name: solicitud_mantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3124 (class 0 OID 54865)
-- Dependencies: 2105 3074 3123
-- Data for Name: talla_por_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

--
-- TOC entry 3125 (class 0 OID 54872)
-- Dependencies: 2106 3004 3028 3096
-- Data for Name: tarea_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3126 (class 0 OID 54880)
-- Dependencies: 2108 3028 3097 3110
-- Data for Name: tarea_actividad_planificada; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3128 (class 0 OID 54893)
-- Dependencies: 2112 3067 3118
-- Data for Name: test_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3131 (class 0 OID 54915)
-- Dependencies: 2117 3028
-- Data for Name: tipo_pago_representante; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3133 (class 0 OID 54929)
-- Dependencies: 2120 3055
-- Data for Name: valor_escala; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2012-01-08 12:19:59

--
-- PostgreSQL database dump complete
--

