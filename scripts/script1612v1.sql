--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.5
-- Dumped by pg_dump version 9.0.3
-- Started on 2011-12-16 17:45:02

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 2262 (class 1262 OID 11826)
-- Dependencies: 2261
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 473 (class 2612 OID 11574)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1665 (class 1259 OID 31965)
-- Dependencies: 6
-- Name: afeccion_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE afeccion_jugador (
    codigo_dato_medico character varying NOT NULL,
    codigo_afeccion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.afeccion_jugador OWNER TO postgres;

--
-- TOC entry 1666 (class 1259 OID 31971)
-- Dependencies: 6
-- Name: ascenso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ascenso (
    codigo_ascenso character varying NOT NULL,
    codigo_roster character varying NOT NULL,
    codigo_tipo_ascenso character varying NOT NULL,
    fecha_ascenso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.ascenso OWNER TO postgres;

--
-- TOC entry 1667 (class 1259 OID 31977)
-- Dependencies: 6
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categoria (
    codigo_categoria character varying NOT NULL,
    nombre character varying NOT NULL,
    edad_inferior integer NOT NULL,
    edad_superior integer NOT NULL,
    cantidad_equipo integer NOT NULL,
    minimo_jugador integer NOT NULL,
    maximo_jugador integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 1668 (class 1259 OID 31983)
-- Dependencies: 6
-- Name: categoria_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categoria_competencia (
    codigo_competencia character varying NOT NULL,
    codigo_categoria character varying NOT NULL,
    duracion_hora time without time zone NOT NULL,
    duracion_inning integer NOT NULL
);


ALTER TABLE public.categoria_competencia OWNER TO postgres;

--
-- TOC entry 1669 (class 1259 OID 31989)
-- Dependencies: 6
-- Name: codigo_area; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE codigo_area (
    codigo_area character varying NOT NULL,
    codigo_de_area character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.codigo_area OWNER TO postgres;

--
-- TOC entry 1670 (class 1259 OID 31995)
-- Dependencies: 6
-- Name: codigo_celular; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE codigo_celular (
    codigo_celular character varying NOT NULL,
    codigo_del_celular character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.codigo_celular OWNER TO postgres;

--
-- TOC entry 1671 (class 1259 OID 32001)
-- Dependencies: 6
-- Name: comision_equipo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE comision_equipo (
    codigo_equipo character varying NOT NULL,
    codigo_clasificacion character varying NOT NULL,
    maximo_comision integer NOT NULL,
    cantidad_comision integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.comision_equipo OWNER TO postgres;

--
-- TOC entry 1672 (class 1259 OID 32007)
-- Dependencies: 6
-- Name: competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE competencia (
    codigo_competencia character varying NOT NULL,
    codigo_temporada character varying NOT NULL,
    codigo_tipo character varying NOT NULL,
    codigo_estado character varying NOT NULL,
    nombre character varying NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    cantidad_equipo integer NOT NULL,
    cantidad_fase integer NOT NULL,
    cantidad_jugador integer NOT NULL,
    monto_inscripcion real NOT NULL,
    condiciones_generales character varying NOT NULL,
    desempate character varying NOT NULL,
    extrainning character varying NOT NULL,
    documento bytea NOT NULL
);


ALTER TABLE public.competencia OWNER TO postgres;

--
-- TOC entry 1673 (class 1259 OID 32013)
-- Dependencies: 6
-- Name: dato_academico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_academico (
    codigo_academico character varying NOT NULL,
    codigo_anno_escolar character varying NOT NULL,
    codigo_curso character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_institucion character varying NOT NULL,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_academico OWNER TO postgres;

--
-- TOC entry 1674 (class 1259 OID 32019)
-- Dependencies: 6
-- Name: dato_basico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_basico (
    codigo_dato_basico character varying NOT NULL,
    codigo_tipo_dato character varying NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying NOT NULL,
    estatus character(1) NOT NULL,
    fecha_registro date NOT NULL,
    responsable character varying NOT NULL,
    hora_registro time without time zone NOT NULL,
    parent_codigo_dato_basico character varying NOT NULL
);


ALTER TABLE public.dato_basico OWNER TO postgres;

--
-- TOC entry 1675 (class 1259 OID 32025)
-- Dependencies: 6
-- Name: dato_conducta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_conducta (
    codigo_dato_conducta character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_periodo_sancion character varying NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date,
    observacion character varying NOT NULL,
    cantidad integer NOT NULL,
    fecha_ocurrencia date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_conducta OWNER TO postgres;

--
-- TOC entry 1676 (class 1259 OID 32031)
-- Dependencies: 6
-- Name: dato_deportivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_deportivo (
    codigo_competencia character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_deportivo OWNER TO postgres;

--
-- TOC entry 1677 (class 1259 OID 32037)
-- Dependencies: 6
-- Name: dato_medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_medico (
    codigo_dato_medico character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    numero_colegio character varying NOT NULL,
    fecha_informe date,
    fecha_reincorporacion date,
    observacion character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_medico OWNER TO postgres;

--
-- TOC entry 1678 (class 1259 OID 32043)
-- Dependencies: 6
-- Name: dato_social; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_social (
    codigo_dato_social character varying NOT NULL,
    codigo_actividad_social character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_institucion character varying NOT NULL,
    horas_dedicadas integer,
    fecha_inicio character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_social OWNER TO postgres;

--
-- TOC entry 1679 (class 1259 OID 32049)
-- Dependencies: 6
-- Name: desempenno_colectivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE desempenno_colectivo (
    codigo_equipo_juego character varying NOT NULL,
    valor integer NOT NULL,
    inning integer NOT NULL
);


ALTER TABLE public.desempenno_colectivo OWNER TO postgres;

--
-- TOC entry 1680 (class 1259 OID 32055)
-- Dependencies: 6
-- Name: divisa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE divisa (
    codigo_divisa character varying NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying NOT NULL,
    telefono character varying NOT NULL,
    correo_electronico character varying NOT NULL,
    persona_contacto character varying NOT NULL,
    logo bytea NOT NULL
);


ALTER TABLE public.divisa OWNER TO postgres;

--
-- TOC entry 1681 (class 1259 OID 32061)
-- Dependencies: 6
-- Name: documento_academico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_academico (
    codigo_documento_entregado character varying NOT NULL,
    codigo_academico character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_academico OWNER TO postgres;

--
-- TOC entry 1682 (class 1259 OID 32067)
-- Dependencies: 6
-- Name: documento_ascenso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_ascenso (
    codigo_documento_entregado character varying NOT NULL,
    codigo_ascenso character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_ascenso OWNER TO postgres;

--
-- TOC entry 1683 (class 1259 OID 32073)
-- Dependencies: 6
-- Name: documento_conducta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_conducta (
    codigo_documento_entregado character varying NOT NULL,
    codigo_dato_conducta character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_conducta OWNER TO postgres;

--
-- TOC entry 1684 (class 1259 OID 32079)
-- Dependencies: 6
-- Name: documento_entregado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_entregado (
    codigo_documento_entregado character varying NOT NULL,
    codigo_recaudo_por_proceso character varying NOT NULL,
    documento bytea NOT NULL,
    fecha date NOT NULL,
    estatus character(1) NOT NULL,
    cantidad integer NOT NULL
);


ALTER TABLE public.documento_entregado OWNER TO postgres;

--
-- TOC entry 1685 (class 1259 OID 32085)
-- Dependencies: 6
-- Name: documento_medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_medico (
    codigo_dato_medico character varying NOT NULL,
    codigo_documento_entregado character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_medico OWNER TO postgres;

--
-- TOC entry 1686 (class 1259 OID 32091)
-- Dependencies: 6
-- Name: equipo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE equipo (
    codigo_equipo character varying NOT NULL,
    codigo_clasificacion character varying NOT NULL,
    codigo_categoria character varying NOT NULL,
    codigo_divisa character varying NOT NULL,
    nombre character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.equipo OWNER TO postgres;

--
-- TOC entry 1687 (class 1259 OID 32097)
-- Dependencies: 6
-- Name: equipo_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE equipo_competencia (
    codigo_equipo_competencia character varying NOT NULL,
    codigo_equipo character varying NOT NULL,
    codigo_competencia character varying NOT NULL
);


ALTER TABLE public.equipo_competencia OWNER TO postgres;

--
-- TOC entry 1688 (class 1259 OID 32103)
-- Dependencies: 6
-- Name: equipo_juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE equipo_juego (
    codigo_equipo_juego character varying NOT NULL,
    codigo_equipo_competencia character varying NOT NULL,
    home_club boolean NOT NULL,
    codigo_juego character varying NOT NULL
);


ALTER TABLE public.equipo_juego OWNER TO postgres;

--
-- TOC entry 1689 (class 1259 OID 32109)
-- Dependencies: 6
-- Name: estadio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estadio (
    codigo_estadio character varying NOT NULL,
    codigo_parroquia character varying NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying NOT NULL
);


ALTER TABLE public.estadio OWNER TO postgres;

--
-- TOC entry 1690 (class 1259 OID 32115)
-- Dependencies: 6
-- Name: familiar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE familiar (
    cedula_rif character varying NOT NULL,
    codigo_profesion character varying NOT NULL
);


ALTER TABLE public.familiar OWNER TO postgres;

--
-- TOC entry 1691 (class 1259 OID 32121)
-- Dependencies: 6
-- Name: familiar_comision_equipo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE familiar_comision_equipo (
    codigo_equipo character varying NOT NULL,
    codigo_comision character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    cedula_familiar character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.familiar_comision_equipo OWNER TO postgres;

--
-- TOC entry 1692 (class 1259 OID 32127)
-- Dependencies: 6
-- Name: familiar_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE familiar_jugador (
    cedula_rif character varying NOT NULL,
    cedula_familiar character varying NOT NULL,
    codigo_parentesco character varying NOT NULL,
    "esRepresentante" boolean NOT NULL,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.familiar_jugador OWNER TO postgres;

--
-- TOC entry 1693 (class 1259 OID 32133)
-- Dependencies: 6
-- Name: fase_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fase_competencia (
    codigo_competencia character varying NOT NULL,
    numero_fase integer NOT NULL,
    equipo_ingresan integer NOT NULL,
    equipo_clasifican integer NOT NULL
);


ALTER TABLE public.fase_competencia OWNER TO postgres;

--
-- TOC entry 1694 (class 1259 OID 32139)
-- Dependencies: 6
-- Name: hospedaje; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE hospedaje (
    codigo_hospedaje character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    cedula_familiar character varying NOT NULL,
    codigo_competencia character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.hospedaje OWNER TO postgres;

--
-- TOC entry 1695 (class 1259 OID 32145)
-- Dependencies: 6
-- Name: hospedaje_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE hospedaje_jugador (
    codigo_hospedaje character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    cedula_familiar character varying NOT NULL,
    codigo_categoria character varying NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    direccion character varying NOT NULL,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.hospedaje_jugador OWNER TO postgres;

--
-- TOC entry 1696 (class 1259 OID 32151)
-- Dependencies: 6
-- Name: ingreso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ingreso (
    numero_documento character varying NOT NULL,
    fecha_pago date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.ingreso OWNER TO postgres;

--
-- TOC entry 1697 (class 1259 OID 32157)
-- Dependencies: 6
-- Name: ingreso_forma_pago; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ingreso_forma_pago (
    numero_documento character varying NOT NULL,
    codigo_dato_basico character varying NOT NULL,
    codigo_forma_pago character varying NOT NULL,
    codigo_banco character varying NOT NULL,
    monto real NOT NULL,
    codigo_tarjeta character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.ingreso_forma_pago OWNER TO postgres;

--
-- TOC entry 1698 (class 1259 OID 32163)
-- Dependencies: 6
-- Name: institucion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE institucion (
    codigo_institucion character varying NOT NULL,
    codigo_parroquia character varying NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.institucion OWNER TO postgres;

--
-- TOC entry 1699 (class 1259 OID 32169)
-- Dependencies: 6
-- Name: juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE juego (
    codigo_juego character varying NOT NULL,
    codigo_estadio character varying NOT NULL,
    codigo_competencia character varying NOT NULL,
    codigo_estado character varying NOT NULL,
    hora_inicio time without time zone NOT NULL,
    fecha date NOT NULL,
    anotador character varying NOT NULL
);


ALTER TABLE public.juego OWNER TO postgres;

--
-- TOC entry 1700 (class 1259 OID 32175)
-- Dependencies: 6
-- Name: jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE jugador (
    cedula_rif character varying NOT NULL,
    codigo_parroquia character varying NOT NULL,
    numero integer NOT NULL,
    tipo_de_sangre character varying NOT NULL,
    peso double precision NOT NULL,
    altura double precision NOT NULL,
    brazo_lanzar character varying NOT NULL,
    posicion_bateo character varying NOT NULL
);


ALTER TABLE public.jugador OWNER TO postgres;

--
-- TOC entry 1701 (class 1259 OID 32181)
-- Dependencies: 6
-- Name: logro_por_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE logro_por_jugador (
    codigo_competencia character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_logro character varying NOT NULL,
    observacion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.logro_por_jugador OWNER TO postgres;

--
-- TOC entry 1702 (class 1259 OID 32187)
-- Dependencies: 6
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE medico (
    numero_colegio character varying NOT NULL,
    codigo_especialidad character varying NOT NULL,
    matricula character varying,
    cedula_medico character varying,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    telefono_oficina character varying,
    telefono_celular character varying,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- TOC entry 1703 (class 1259 OID 32193)
-- Dependencies: 6
-- Name: motivo_sancion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE motivo_sancion (
    codigo_motivo character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.motivo_sancion OWNER TO postgres;

--
-- TOC entry 1704 (class 1259 OID 32199)
-- Dependencies: 6
-- Name: participante_plan; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE participante_plan (
    codigo_participante character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_categoria character varying NOT NULL,
    codigo_talla_indumentaria character varying NOT NULL,
    tipo_jugador character varying NOT NULL,
    cedula_jugador character varying NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    fecha_nacimiento date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.participante_plan OWNER TO postgres;

--
-- TOC entry 1705 (class 1259 OID 32205)
-- Dependencies: 6
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
    cedula_rif character varying NOT NULL,
    codigo_parroquia character varying NOT NULL,
    telefono_habitacion character varying NOT NULL,
    fecha_ingreso date NOT NULL,
    correo_electronico character varying NOT NULL,
    facebook character varying NOT NULL,
    twitter character varying NOT NULL,
    direccion character varying NOT NULL,
    fecha_egreso date NOT NULL,
    fecha_nacimiento date NOT NULL,
    sexo character(1) NOT NULL
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 1706 (class 1259 OID 32211)
-- Dependencies: 6
-- Name: persona_juridica; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona_juridica (
    cedula_rif character varying NOT NULL,
    nit character varying NOT NULL,
    fax character varying NOT NULL,
    razon_social character varying NOT NULL
);


ALTER TABLE public.persona_juridica OWNER TO postgres;

--
-- TOC entry 1707 (class 1259 OID 32217)
-- Dependencies: 6
-- Name: persona_natural; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona_natural (
    cedula_rif character varying NOT NULL,
    celular character varying NOT NULL,
    primer_nombre character varying NOT NULL,
    segundo_nombre character varying NOT NULL,
    primer_apellido character varying NOT NULL,
    segundo_apellido character varying NOT NULL,
    foto bytea NOT NULL
);


ALTER TABLE public.persona_natural OWNER TO postgres;

--
-- TOC entry 1708 (class 1259 OID 32223)
-- Dependencies: 6
-- Name: plan_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE plan_jugador (
    codigo_plan character varying NOT NULL,
    codigo_participante character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.plan_jugador OWNER TO postgres;

--
-- TOC entry 1709 (class 1259 OID 32229)
-- Dependencies: 6
-- Name: plan_vacacional; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE plan_vacacional (
    codigo_plan character varying NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    cupo integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.plan_vacacional OWNER TO postgres;

--
-- TOC entry 1710 (class 1259 OID 32235)
-- Dependencies: 6
-- Name: recaudo_por_proceso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recaudo_por_proceso (
    codigo_recaudo_por_proceso character varying NOT NULL,
    codigo_importancia character varying NOT NULL,
    codigo_proceso character varying NOT NULL,
    codigo_documento character varying NOT NULL,
    cantidad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.recaudo_por_proceso OWNER TO postgres;

--
-- TOC entry 1711 (class 1259 OID 32241)
-- Dependencies: 6
-- Name: regla; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE regla (
    codigo_regla character varying NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE public.regla OWNER TO postgres;

--
-- TOC entry 1712 (class 1259 OID 32247)
-- Dependencies: 6
-- Name: regla_categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE regla_categoria (
    codigo_regla character varying NOT NULL,
    codigo_categoria character varying NOT NULL
);


ALTER TABLE public.regla_categoria OWNER TO postgres;

--
-- TOC entry 1713 (class 1259 OID 32253)
-- Dependencies: 6
-- Name: representante; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE representante (
    cedula_rif character varying NOT NULL,
    cedula_familiar character varying NOT NULL,
    fecha_asignacion date NOT NULL,
    codigo_parentesco character varying NOT NULL,
    fecha_retiro date NOT NULL
);


ALTER TABLE public.representante OWNER TO postgres;

--
-- TOC entry 1714 (class 1259 OID 32259)
-- Dependencies: 6
-- Name: roster; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE roster (
    codigo_roster character varying NOT NULL,
    codigo_equipo character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.roster OWNER TO postgres;

--
-- TOC entry 1715 (class 1259 OID 32265)
-- Dependencies: 6
-- Name: talla_por_indumentaria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE talla_por_indumentaria (
    codigo_talla_indumentaria character varying NOT NULL,
    codigo_talla character varying NOT NULL,
    codigo_indumentaria character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.talla_por_indumentaria OWNER TO postgres;

--
-- TOC entry 1716 (class 1259 OID 32271)
-- Dependencies: 6
-- Name: talla_por_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE talla_por_jugador (
    cedula_rif character varying NOT NULL,
    codigo_talla_indumentaria character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.talla_por_jugador OWNER TO postgres;

--
-- TOC entry 1717 (class 1259 OID 32277)
-- Dependencies: 6
-- Name: temporada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE temporada (
    codigo_temporada character varying NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    descripcion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.temporada OWNER TO postgres;

--
-- TOC entry 1718 (class 1259 OID 32283)
-- Dependencies: 6
-- Name: tipo_dato; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_dato (
    codigo_tipo_dato character varying NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying NOT NULL,
    estatus character(1) NOT NULL,
    parent_codigo_tipo_dato character varying NOT NULL
);


ALTER TABLE public.tipo_dato OWNER TO postgres;

--
-- TOC entry 1719 (class 1259 OID 32289)
-- Dependencies: 6
-- Name: umpire; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE umpire (
    codigo_umpire character varying NOT NULL,
    nombre character varying NOT NULL
);


ALTER TABLE public.umpire OWNER TO postgres;

--
-- TOC entry 1720 (class 1259 OID 32295)
-- Dependencies: 6
-- Name: umpire_juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE umpire_juego (
    codigo_umpire character varying NOT NULL,
    codigo_juego character varying NOT NULL
);


ALTER TABLE public.umpire_juego OWNER TO postgres;

--
-- TOC entry 2203 (class 0 OID 31965)
-- Dependencies: 1665
-- Data for Name: afeccion_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY afeccion_jugador (codigo_dato_medico, codigo_afeccion, estatus) FROM stdin;
\.


--
-- TOC entry 2204 (class 0 OID 31971)
-- Dependencies: 1666
-- Data for Name: ascenso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ascenso (codigo_ascenso, codigo_roster, codigo_tipo_ascenso, fecha_ascenso, estatus) FROM stdin;
\.


--
-- TOC entry 2205 (class 0 OID 31977)
-- Dependencies: 1667
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY categoria (codigo_categoria, nombre, edad_inferior, edad_superior, cantidad_equipo, minimo_jugador, maximo_jugador, estatus) FROM stdin;
\.


--
-- TOC entry 2206 (class 0 OID 31983)
-- Dependencies: 1668
-- Data for Name: categoria_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY categoria_competencia (codigo_competencia, codigo_categoria, duracion_hora, duracion_inning) FROM stdin;
\.


--
-- TOC entry 2207 (class 0 OID 31989)
-- Dependencies: 1669
-- Data for Name: codigo_area; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY codigo_area (codigo_area, codigo_de_area, estatus) FROM stdin;
\.


--
-- TOC entry 2208 (class 0 OID 31995)
-- Dependencies: 1670
-- Data for Name: codigo_celular; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY codigo_celular (codigo_celular, codigo_del_celular, estatus) FROM stdin;
\.


--
-- TOC entry 2209 (class 0 OID 32001)
-- Dependencies: 1671
-- Data for Name: comision_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY comision_equipo (codigo_equipo, codigo_clasificacion, maximo_comision, cantidad_comision, estatus) FROM stdin;
\.


--
-- TOC entry 2210 (class 0 OID 32007)
-- Dependencies: 1672
-- Data for Name: competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY competencia (codigo_competencia, codigo_temporada, codigo_tipo, codigo_estado, nombre, fecha_inicio, fecha_fin, cantidad_equipo, cantidad_fase, cantidad_jugador, monto_inscripcion, condiciones_generales, desempate, extrainning, documento) FROM stdin;
\.


--
-- TOC entry 2211 (class 0 OID 32013)
-- Dependencies: 1673
-- Data for Name: dato_academico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dato_academico (codigo_academico, codigo_anno_escolar, codigo_curso, cedula_rif, codigo_institucion, fecha_ingreso, estatus) FROM stdin;
\.


--
-- TOC entry 2212 (class 0 OID 32019)
-- Dependencies: 1674
-- Data for Name: dato_basico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dato_basico (codigo_dato_basico, codigo_tipo_dato, nombre, descripcion, estatus, fecha_registro, responsable, hora_registro, parent_codigo_dato_basico) FROM stdin;
\.


--
-- TOC entry 2213 (class 0 OID 32025)
-- Dependencies: 1675
-- Data for Name: dato_conducta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dato_conducta (codigo_dato_conducta, cedula_rif, codigo_periodo_sancion, fecha_inicio, fecha_fin, observacion, cantidad, fecha_ocurrencia, estatus) FROM stdin;
\.


--
-- TOC entry 2214 (class 0 OID 32031)
-- Dependencies: 1676
-- Data for Name: dato_deportivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dato_deportivo (codigo_competencia, cedula_rif, estatus) FROM stdin;
\.


--
-- TOC entry 2215 (class 0 OID 32037)
-- Dependencies: 1677
-- Data for Name: dato_medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dato_medico (codigo_dato_medico, cedula_rif, numero_colegio, fecha_informe, fecha_reincorporacion, observacion, estatus) FROM stdin;
\.


--
-- TOC entry 2216 (class 0 OID 32043)
-- Dependencies: 1678
-- Data for Name: dato_social; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dato_social (codigo_dato_social, codigo_actividad_social, cedula_rif, codigo_institucion, horas_dedicadas, fecha_inicio, estatus) FROM stdin;
\.


--
-- TOC entry 2217 (class 0 OID 32049)
-- Dependencies: 1679
-- Data for Name: desempenno_colectivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY desempenno_colectivo (codigo_equipo_juego, valor, inning) FROM stdin;
\.


--
-- TOC entry 2218 (class 0 OID 32055)
-- Dependencies: 1680
-- Data for Name: divisa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY divisa (codigo_divisa, nombre, direccion, telefono, correo_electronico, persona_contacto, logo) FROM stdin;
\.


--
-- TOC entry 2219 (class 0 OID 32061)
-- Dependencies: 1681
-- Data for Name: documento_academico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY documento_academico (codigo_documento_entregado, codigo_academico, estatus) FROM stdin;
\.


--
-- TOC entry 2220 (class 0 OID 32067)
-- Dependencies: 1682
-- Data for Name: documento_ascenso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY documento_ascenso (codigo_documento_entregado, codigo_ascenso, estatus) FROM stdin;
\.


--
-- TOC entry 2221 (class 0 OID 32073)
-- Dependencies: 1683
-- Data for Name: documento_conducta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY documento_conducta (codigo_documento_entregado, codigo_dato_conducta, estatus) FROM stdin;
\.


--
-- TOC entry 2222 (class 0 OID 32079)
-- Dependencies: 1684
-- Data for Name: documento_entregado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY documento_entregado (codigo_documento_entregado, codigo_recaudo_por_proceso, documento, fecha, estatus, cantidad) FROM stdin;
\.


--
-- TOC entry 2223 (class 0 OID 32085)
-- Dependencies: 1685
-- Data for Name: documento_medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY documento_medico (codigo_dato_medico, codigo_documento_entregado, estatus) FROM stdin;
\.


--
-- TOC entry 2224 (class 0 OID 32091)
-- Dependencies: 1686
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY equipo (codigo_equipo, codigo_clasificacion, codigo_categoria, codigo_divisa, nombre, estatus) FROM stdin;
\.


--
-- TOC entry 2225 (class 0 OID 32097)
-- Dependencies: 1687
-- Data for Name: equipo_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY equipo_competencia (codigo_equipo_competencia, codigo_equipo, codigo_competencia) FROM stdin;
\.


--
-- TOC entry 2226 (class 0 OID 32103)
-- Dependencies: 1688
-- Data for Name: equipo_juego; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY equipo_juego (codigo_equipo_juego, codigo_equipo_competencia, home_club, codigo_juego) FROM stdin;
\.


--
-- TOC entry 2227 (class 0 OID 32109)
-- Dependencies: 1689
-- Data for Name: estadio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY estadio (codigo_estadio, codigo_parroquia, nombre, direccion) FROM stdin;
\.


--
-- TOC entry 2228 (class 0 OID 32115)
-- Dependencies: 1690
-- Data for Name: familiar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY familiar (cedula_rif, codigo_profesion) FROM stdin;
\.


--
-- TOC entry 2229 (class 0 OID 32121)
-- Dependencies: 1691
-- Data for Name: familiar_comision_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY familiar_comision_equipo (codigo_equipo, codigo_comision, cedula_rif, cedula_familiar, estatus) FROM stdin;
\.


--
-- TOC entry 2230 (class 0 OID 32127)
-- Dependencies: 1692
-- Data for Name: familiar_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY familiar_jugador (cedula_rif, cedula_familiar, codigo_parentesco, "esRepresentante", fecha_ingreso, estatus) FROM stdin;
\.


--
-- TOC entry 2231 (class 0 OID 32133)
-- Dependencies: 1693
-- Data for Name: fase_competencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY fase_competencia (codigo_competencia, numero_fase, equipo_ingresan, equipo_clasifican) FROM stdin;
\.


--
-- TOC entry 2232 (class 0 OID 32139)
-- Dependencies: 1694
-- Data for Name: hospedaje; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hospedaje (codigo_hospedaje, cedula_rif, cedula_familiar, codigo_competencia, estatus) FROM stdin;
\.


--
-- TOC entry 2233 (class 0 OID 32145)
-- Dependencies: 1695
-- Data for Name: hospedaje_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hospedaje_jugador (codigo_hospedaje, cedula_rif, cedula_familiar, codigo_categoria, nombre, apellido, direccion, fecha_ingreso, estatus) FROM stdin;
\.


--
-- TOC entry 2234 (class 0 OID 32151)
-- Dependencies: 1696
-- Data for Name: ingreso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ingreso (numero_documento, fecha_pago, estatus) FROM stdin;
\.


--
-- TOC entry 2235 (class 0 OID 32157)
-- Dependencies: 1697
-- Data for Name: ingreso_forma_pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ingreso_forma_pago (numero_documento, codigo_dato_basico, codigo_forma_pago, codigo_banco, monto, codigo_tarjeta, estatus) FROM stdin;
\.


--
-- TOC entry 2236 (class 0 OID 32163)
-- Dependencies: 1698
-- Data for Name: institucion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY institucion (codigo_institucion, codigo_parroquia, nombre, direccion, estatus) FROM stdin;
\.


--
-- TOC entry 2237 (class 0 OID 32169)
-- Dependencies: 1699
-- Data for Name: juego; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY juego (codigo_juego, codigo_estadio, codigo_competencia, codigo_estado, hora_inicio, fecha, anotador) FROM stdin;
\.


--
-- TOC entry 2238 (class 0 OID 32175)
-- Dependencies: 1700
-- Data for Name: jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY jugador (cedula_rif, codigo_parroquia, numero, tipo_de_sangre, peso, altura, brazo_lanzar, posicion_bateo) FROM stdin;
\.


--
-- TOC entry 2239 (class 0 OID 32181)
-- Dependencies: 1701
-- Data for Name: logro_por_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY logro_por_jugador (codigo_competencia, cedula_rif, codigo_logro, observacion, estatus) FROM stdin;
\.


--
-- TOC entry 2240 (class 0 OID 32187)
-- Dependencies: 1702
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY medico (numero_colegio, codigo_especialidad, matricula, cedula_medico, nombre, apellido, telefono_oficina, telefono_celular, fecha_ingreso, estatus) FROM stdin;
\.


--
-- TOC entry 2241 (class 0 OID 32193)
-- Dependencies: 1703
-- Data for Name: motivo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY motivo_sancion (codigo_motivo, estatus) FROM stdin;
\.


--
-- TOC entry 2242 (class 0 OID 32199)
-- Dependencies: 1704
-- Data for Name: participante_plan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY participante_plan (codigo_participante, cedula_rif, codigo_categoria, codigo_talla_indumentaria, tipo_jugador, cedula_jugador, nombre, apellido, fecha_nacimiento, estatus) FROM stdin;
\.


--
-- TOC entry 2243 (class 0 OID 32205)
-- Dependencies: 1705
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persona (cedula_rif, codigo_parroquia, telefono_habitacion, fecha_ingreso, correo_electronico, facebook, twitter, direccion, fecha_egreso, fecha_nacimiento, sexo) FROM stdin;
\.


--
-- TOC entry 2244 (class 0 OID 32211)
-- Dependencies: 1706
-- Data for Name: persona_juridica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persona_juridica (cedula_rif, nit, fax, razon_social) FROM stdin;
\.


--
-- TOC entry 2245 (class 0 OID 32217)
-- Dependencies: 1707
-- Data for Name: persona_natural; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persona_natural (cedula_rif, celular, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, foto) FROM stdin;
\.


--
-- TOC entry 2246 (class 0 OID 32223)
-- Dependencies: 1708
-- Data for Name: plan_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY plan_jugador (codigo_plan, codigo_participante, estatus) FROM stdin;
\.


--
-- TOC entry 2247 (class 0 OID 32229)
-- Dependencies: 1709
-- Data for Name: plan_vacacional; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY plan_vacacional (codigo_plan, fecha_inicio, fecha_fin, cupo, estatus) FROM stdin;
\.


--
-- TOC entry 2248 (class 0 OID 32235)
-- Dependencies: 1710
-- Data for Name: recaudo_por_proceso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recaudo_por_proceso (codigo_recaudo_por_proceso, codigo_importancia, codigo_proceso, codigo_documento, cantidad, estatus) FROM stdin;
\.


--
-- TOC entry 2249 (class 0 OID 32241)
-- Dependencies: 1711
-- Data for Name: regla; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY regla (codigo_regla, nombre, descripcion) FROM stdin;
\.


--
-- TOC entry 2250 (class 0 OID 32247)
-- Dependencies: 1712
-- Data for Name: regla_categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY regla_categoria (codigo_regla, codigo_categoria) FROM stdin;
\.


--
-- TOC entry 2251 (class 0 OID 32253)
-- Dependencies: 1713
-- Data for Name: representante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY representante (cedula_rif, cedula_familiar, fecha_asignacion, codigo_parentesco, fecha_retiro) FROM stdin;
\.


--
-- TOC entry 2252 (class 0 OID 32259)
-- Dependencies: 1714
-- Data for Name: roster; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY roster (codigo_roster, codigo_equipo, cedula_rif, fecha_ingreso, estatus) FROM stdin;
\.


--
-- TOC entry 2253 (class 0 OID 32265)
-- Dependencies: 1715
-- Data for Name: talla_por_indumentaria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY talla_por_indumentaria (codigo_talla_indumentaria, codigo_talla, codigo_indumentaria, estatus) FROM stdin;
\.


--
-- TOC entry 2254 (class 0 OID 32271)
-- Dependencies: 1716
-- Data for Name: talla_por_jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY talla_por_jugador (cedula_rif, codigo_talla_indumentaria, estatus) FROM stdin;
\.


--
-- TOC entry 2255 (class 0 OID 32277)
-- Dependencies: 1717
-- Data for Name: temporada; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY temporada (codigo_temporada, fecha_inicio, fecha_fin, descripcion, estatus) FROM stdin;
\.


--
-- TOC entry 2256 (class 0 OID 32283)
-- Dependencies: 1718
-- Data for Name: tipo_dato; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_dato (codigo_tipo_dato, nombre, descripcion, estatus, parent_codigo_tipo_dato) FROM stdin;
\.


--
-- TOC entry 2257 (class 0 OID 32289)
-- Dependencies: 1719
-- Data for Name: umpire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY umpire (codigo_umpire, nombre) FROM stdin;
\.


--
-- TOC entry 2258 (class 0 OID 32295)
-- Dependencies: 1720
-- Data for Name: umpire_juego; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY umpire_juego (codigo_umpire, codigo_juego) FROM stdin;
\.


--
-- TOC entry 1999 (class 2606 OID 32302)
-- Dependencies: 1665 1665 1665
-- Name: afeccion_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT afeccion_jugador_pk PRIMARY KEY (codigo_dato_medico, codigo_afeccion);


--
-- TOC entry 2001 (class 2606 OID 32304)
-- Dependencies: 1666 1666
-- Name: ascenso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ascenso
    ADD CONSTRAINT ascenso_pk PRIMARY KEY (codigo_ascenso);


--
-- TOC entry 2005 (class 2606 OID 32306)
-- Dependencies: 1668 1668 1668
-- Name: categoria_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT categoria_competencia_pk PRIMARY KEY (codigo_competencia, codigo_categoria);


--
-- TOC entry 2003 (class 2606 OID 32308)
-- Dependencies: 1667 1667
-- Name: categoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY (codigo_categoria);


--
-- TOC entry 2007 (class 2606 OID 32310)
-- Dependencies: 1669 1669
-- Name: codigo_area_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY codigo_area
    ADD CONSTRAINT codigo_area_pk PRIMARY KEY (codigo_area);


--
-- TOC entry 2009 (class 2606 OID 32312)
-- Dependencies: 1670 1670
-- Name: codigo_celular_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY codigo_celular
    ADD CONSTRAINT codigo_celular_pk PRIMARY KEY (codigo_celular);


--
-- TOC entry 2011 (class 2606 OID 32314)
-- Dependencies: 1671 1671 1671
-- Name: comision_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT comision_equipo_pk PRIMARY KEY (codigo_equipo, codigo_clasificacion);


--
-- TOC entry 2013 (class 2606 OID 32316)
-- Dependencies: 1672 1672
-- Name: competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT competencia_pk PRIMARY KEY (codigo_competencia);


--
-- TOC entry 2015 (class 2606 OID 32318)
-- Dependencies: 1673 1673
-- Name: dato_academico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_academico_pk PRIMARY KEY (codigo_academico);


--
-- TOC entry 2017 (class 2606 OID 32320)
-- Dependencies: 1674 1674
-- Name: dato_basico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT dato_basico_pk PRIMARY KEY (codigo_dato_basico);


--
-- TOC entry 2019 (class 2606 OID 32322)
-- Dependencies: 1675 1675
-- Name: dato_conducta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT dato_conducta_pk PRIMARY KEY (codigo_dato_conducta);


--
-- TOC entry 2021 (class 2606 OID 32324)
-- Dependencies: 1676 1676 1676
-- Name: dato_deportivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT dato_deportivo_pk PRIMARY KEY (codigo_competencia, cedula_rif);


--
-- TOC entry 2023 (class 2606 OID 32326)
-- Dependencies: 1677 1677
-- Name: dato_medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT dato_medico_pk PRIMARY KEY (codigo_dato_medico);


--
-- TOC entry 2025 (class 2606 OID 32328)
-- Dependencies: 1678 1678
-- Name: dato_social_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT dato_social_pk PRIMARY KEY (codigo_dato_social);


--
-- TOC entry 2027 (class 2606 OID 32330)
-- Dependencies: 1679 1679
-- Name: desempenno_colectivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT desempenno_colectivo_pk PRIMARY KEY (codigo_equipo_juego);


--
-- TOC entry 2029 (class 2606 OID 32332)
-- Dependencies: 1680 1680
-- Name: divisa_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY divisa
    ADD CONSTRAINT divisa_pk PRIMARY KEY (codigo_divisa);


--
-- TOC entry 2031 (class 2606 OID 32334)
-- Dependencies: 1681 1681 1681
-- Name: documento_academico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT documento_academico_pk PRIMARY KEY (codigo_documento_entregado, codigo_academico);


--
-- TOC entry 2033 (class 2606 OID 32336)
-- Dependencies: 1682 1682 1682
-- Name: documento_ascenso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT documento_ascenso_pk PRIMARY KEY (codigo_documento_entregado, codigo_ascenso);


--
-- TOC entry 2035 (class 2606 OID 32338)
-- Dependencies: 1683 1683 1683
-- Name: documento_conducta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT documento_conducta_pk PRIMARY KEY (codigo_documento_entregado, codigo_dato_conducta);


--
-- TOC entry 2037 (class 2606 OID 32340)
-- Dependencies: 1684 1684
-- Name: documento_entregado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_entregado
    ADD CONSTRAINT documento_entregado_pk PRIMARY KEY (codigo_documento_entregado);


--
-- TOC entry 2039 (class 2606 OID 32342)
-- Dependencies: 1685 1685 1685
-- Name: documento_medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT documento_medico_pk PRIMARY KEY (codigo_dato_medico, codigo_documento_entregado);


--
-- TOC entry 2043 (class 2606 OID 32344)
-- Dependencies: 1687 1687
-- Name: equipo_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT equipo_competencia_pk PRIMARY KEY (codigo_equipo_competencia);


--
-- TOC entry 2045 (class 2606 OID 32346)
-- Dependencies: 1688 1688
-- Name: equipo_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT equipo_juego_pk PRIMARY KEY (codigo_equipo_juego);


--
-- TOC entry 2041 (class 2606 OID 32348)
-- Dependencies: 1686 1686
-- Name: equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT equipo_pk PRIMARY KEY (codigo_equipo);


--
-- TOC entry 2047 (class 2606 OID 32350)
-- Dependencies: 1689 1689
-- Name: estadio_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estadio
    ADD CONSTRAINT estadio_pk PRIMARY KEY (codigo_estadio);


--
-- TOC entry 2051 (class 2606 OID 32352)
-- Dependencies: 1691 1691 1691 1691 1691
-- Name: familiar_comision_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT familiar_comision_equipo_pk PRIMARY KEY (codigo_equipo, codigo_comision, cedula_rif, cedula_familiar);


--
-- TOC entry 2053 (class 2606 OID 32354)
-- Dependencies: 1692 1692 1692
-- Name: familiar_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT familiar_jugador_pk PRIMARY KEY (cedula_rif, cedula_familiar);


--
-- TOC entry 2049 (class 2606 OID 32356)
-- Dependencies: 1690 1690
-- Name: familiar_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT familiar_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2055 (class 2606 OID 32358)
-- Dependencies: 1693 1693 1693
-- Name: fase_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fase_competencia
    ADD CONSTRAINT fase_competencia_pk PRIMARY KEY (codigo_competencia, numero_fase);


--
-- TOC entry 2059 (class 2606 OID 32360)
-- Dependencies: 1695 1695 1695 1695
-- Name: hospedaje_judador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hospedaje_jugador
    ADD CONSTRAINT hospedaje_judador_pk PRIMARY KEY (codigo_hospedaje, cedula_rif, cedula_familiar);


--
-- TOC entry 2057 (class 2606 OID 32362)
-- Dependencies: 1694 1694 1694 1694
-- Name: hospedaje_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT hospedaje_pk PRIMARY KEY (codigo_hospedaje, cedula_rif, cedula_familiar);


--
-- TOC entry 2063 (class 2606 OID 32364)
-- Dependencies: 1697 1697
-- Name: ingreso_forma_pago_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT ingreso_forma_pago_pk PRIMARY KEY (codigo_dato_basico);


--
-- TOC entry 2061 (class 2606 OID 32366)
-- Dependencies: 1696 1696
-- Name: ingreso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso
    ADD CONSTRAINT ingreso_pk PRIMARY KEY (numero_documento);


--
-- TOC entry 2065 (class 2606 OID 32368)
-- Dependencies: 1698 1698
-- Name: institucion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT institucion_pk PRIMARY KEY (codigo_institucion);


--
-- TOC entry 2067 (class 2606 OID 32370)
-- Dependencies: 1699 1699
-- Name: juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT juego_pk PRIMARY KEY (codigo_juego);


--
-- TOC entry 2069 (class 2606 OID 32372)
-- Dependencies: 1700 1700
-- Name: jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT jugador_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2071 (class 2606 OID 32374)
-- Dependencies: 1701 1701 1701 1701
-- Name: logro_por_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT logro_por_jugador_pk PRIMARY KEY (codigo_competencia, cedula_rif, codigo_logro);


--
-- TOC entry 2073 (class 2606 OID 32376)
-- Dependencies: 1702 1702
-- Name: medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT medico_pk PRIMARY KEY (numero_colegio);


--
-- TOC entry 2075 (class 2606 OID 32378)
-- Dependencies: 1703 1703
-- Name: motivo_sancion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT motivo_sancion_pk PRIMARY KEY (codigo_motivo);


--
-- TOC entry 2077 (class 2606 OID 32380)
-- Dependencies: 1704 1704
-- Name: participante_plan_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY participante_plan
    ADD CONSTRAINT participante_plan_pk PRIMARY KEY (codigo_participante);


--
-- TOC entry 2081 (class 2606 OID 32382)
-- Dependencies: 1706 1706
-- Name: persona_juridica_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona_juridica
    ADD CONSTRAINT persona_juridica_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2083 (class 2606 OID 32384)
-- Dependencies: 1707 1707
-- Name: persona_natural_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT persona_natural_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2079 (class 2606 OID 32386)
-- Dependencies: 1705 1705
-- Name: persona_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2085 (class 2606 OID 32388)
-- Dependencies: 1708 1708 1708
-- Name: plan_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_jugador
    ADD CONSTRAINT plan_jugador_pk PRIMARY KEY (codigo_plan, codigo_participante);


--
-- TOC entry 2087 (class 2606 OID 32390)
-- Dependencies: 1709 1709
-- Name: plan_vacacional_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_vacacional
    ADD CONSTRAINT plan_vacacional_pk PRIMARY KEY (codigo_plan);


--
-- TOC entry 2089 (class 2606 OID 32392)
-- Dependencies: 1710 1710
-- Name: recaudo_por_proceso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT recaudo_por_proceso_pk PRIMARY KEY (codigo_recaudo_por_proceso);


--
-- TOC entry 2093 (class 2606 OID 32394)
-- Dependencies: 1712 1712 1712
-- Name: regla_categoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY regla_categoria
    ADD CONSTRAINT regla_categoria_pk PRIMARY KEY (codigo_regla, codigo_categoria);


--
-- TOC entry 2091 (class 2606 OID 32396)
-- Dependencies: 1711 1711
-- Name: regla_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY regla
    ADD CONSTRAINT regla_pk PRIMARY KEY (codigo_regla);


--
-- TOC entry 2095 (class 2606 OID 32398)
-- Dependencies: 1713 1713 1713
-- Name: representante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY representante
    ADD CONSTRAINT representante_pk PRIMARY KEY (cedula_rif, cedula_familiar);


--
-- TOC entry 2097 (class 2606 OID 32400)
-- Dependencies: 1714 1714
-- Name: roster_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT roster_pk PRIMARY KEY (codigo_roster);


--
-- TOC entry 2099 (class 2606 OID 32402)
-- Dependencies: 1715 1715
-- Name: talla_por_indumentaria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT talla_por_indumentaria_pk PRIMARY KEY (codigo_talla_indumentaria);


--
-- TOC entry 2101 (class 2606 OID 32404)
-- Dependencies: 1716 1716 1716
-- Name: talla_por_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT talla_por_jugador_pk PRIMARY KEY (cedula_rif, codigo_talla_indumentaria);


--
-- TOC entry 2103 (class 2606 OID 32406)
-- Dependencies: 1717 1717
-- Name: temporada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY temporada
    ADD CONSTRAINT temporada_pk PRIMARY KEY (codigo_temporada);


--
-- TOC entry 2105 (class 2606 OID 32408)
-- Dependencies: 1718 1718
-- Name: tipo_dato_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_dato
    ADD CONSTRAINT tipo_dato_pk PRIMARY KEY (codigo_tipo_dato);


--
-- TOC entry 2109 (class 2606 OID 32410)
-- Dependencies: 1720 1720 1720
-- Name: umpire_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY umpire_juego
    ADD CONSTRAINT umpire_juego_pk PRIMARY KEY (codigo_umpire, codigo_juego);


--
-- TOC entry 2107 (class 2606 OID 32412)
-- Dependencies: 1719 1719
-- Name: umpire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY umpire
    ADD CONSTRAINT umpire_pk PRIMARY KEY (codigo_umpire);


--
-- TOC entry 2140 (class 2606 OID 32413)
-- Dependencies: 1666 2000 1682
-- Name: ascenso_documento_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT ascenso_documento_ascenso_fk FOREIGN KEY (codigo_ascenso) REFERENCES ascenso(codigo_ascenso);


--
-- TOC entry 2114 (class 2606 OID 32418)
-- Dependencies: 1668 1667 2002
-- Name: categoria_categoria_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT categoria_categoria_competencia_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2147 (class 2606 OID 32423)
-- Dependencies: 1686 2002 1667
-- Name: categoria_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT categoria_equipo_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2165 (class 2606 OID 32428)
-- Dependencies: 2002 1667 1695
-- Name: categoria_hospedaje_judador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje_jugador
    ADD CONSTRAINT categoria_hospedaje_judador_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2180 (class 2606 OID 32433)
-- Dependencies: 1667 1704 2002
-- Name: categoria_participante_plan_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY participante_plan
    ADD CONSTRAINT categoria_participante_plan_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2191 (class 2606 OID 32438)
-- Dependencies: 1667 1712 2002
-- Name: categoria_regla_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regla_categoria
    ADD CONSTRAINT categoria_regla_categoria_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2157 (class 2606 OID 32443)
-- Dependencies: 1671 1691 1691 1671 2010
-- Name: comision_equipo_familiar_comision_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT comision_equipo_familiar_comision_fk FOREIGN KEY (codigo_equipo, codigo_comision) REFERENCES comision_equipo(codigo_equipo, codigo_clasificacion);


--
-- TOC entry 2115 (class 2606 OID 32448)
-- Dependencies: 1668 2012 1672
-- Name: competencia_categoria_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT competencia_categoria_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2130 (class 2606 OID 32453)
-- Dependencies: 1676 1672 2012
-- Name: competencia_dato_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT competencia_dato_deportivo_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2150 (class 2606 OID 32458)
-- Dependencies: 1687 2012 1672
-- Name: competencia_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT competencia_equipo_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2162 (class 2606 OID 32463)
-- Dependencies: 1693 1672 2012
-- Name: competencia_fase_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fase_competencia
    ADD CONSTRAINT competencia_fase_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2163 (class 2606 OID 32468)
-- Dependencies: 1694 2012 1672
-- Name: competencia_hospedaje_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT competencia_hospedaje_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2171 (class 2606 OID 32473)
-- Dependencies: 2012 1672 1699
-- Name: competencia_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT competencia_juego_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2138 (class 2606 OID 32478)
-- Dependencies: 2014 1681 1673
-- Name: dato_academico_documento_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT dato_academico_documento_academico_fk FOREIGN KEY (codigo_academico) REFERENCES dato_academico(codigo_academico);


--
-- TOC entry 2110 (class 2606 OID 32483)
-- Dependencies: 2016 1674 1665
-- Name: dato_basico_afeccion_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT dato_basico_afeccion_jugador_fk FOREIGN KEY (codigo_afeccion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2112 (class 2606 OID 32488)
-- Dependencies: 1674 2016 1666
-- Name: dato_basico_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ascenso
    ADD CONSTRAINT dato_basico_ascenso_fk FOREIGN KEY (codigo_tipo_ascenso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2116 (class 2606 OID 32493)
-- Dependencies: 1674 2016 1671
-- Name: dato_basico_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT dato_basico_comision_equipo_fk FOREIGN KEY (codigo_clasificacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2118 (class 2606 OID 32498)
-- Dependencies: 2016 1672 1674
-- Name: dato_basico_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2119 (class 2606 OID 32503)
-- Dependencies: 1672 1674 2016
-- Name: dato_basico_competencia_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk1 FOREIGN KEY (codigo_tipo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2121 (class 2606 OID 32508)
-- Dependencies: 1673 1674 2016
-- Name: dato_basico_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_basico_dato_academico_fk FOREIGN KEY (codigo_anno_escolar) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2122 (class 2606 OID 32513)
-- Dependencies: 2016 1673 1674
-- Name: dato_basico_dato_academico_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_basico_dato_academico_fk1 FOREIGN KEY (codigo_curso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2125 (class 2606 OID 32518)
-- Dependencies: 1674 2016 1674
-- Name: dato_basico_dato_basico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT dato_basico_dato_basico_fk FOREIGN KEY (parent_codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2128 (class 2606 OID 32523)
-- Dependencies: 1675 1674 2016
-- Name: dato_basico_dato_conduct_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT dato_basico_dato_conduct_fk FOREIGN KEY (codigo_periodo_sancion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2134 (class 2606 OID 32528)
-- Dependencies: 2016 1674 1678
-- Name: dato_basico_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT dato_basico_dato_social_fk FOREIGN KEY (codigo_actividad_social) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2188 (class 2606 OID 32533)
-- Dependencies: 2016 1674 1710
-- Name: dato_basico_documento_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_documento_fk1 FOREIGN KEY (codigo_documento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2189 (class 2606 OID 32538)
-- Dependencies: 1710 1674 2016
-- Name: dato_basico_documento_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_documento_fk2 FOREIGN KEY (codigo_proceso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2148 (class 2606 OID 32543)
-- Dependencies: 2016 1686 1674
-- Name: dato_basico_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT dato_basico_equipo_fk FOREIGN KEY (codigo_clasificacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2154 (class 2606 OID 32548)
-- Dependencies: 2016 1689 1674
-- Name: dato_basico_estadio_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estadio
    ADD CONSTRAINT dato_basico_estadio_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2155 (class 2606 OID 32553)
-- Dependencies: 1674 1690 2016
-- Name: dato_basico_familiar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT dato_basico_familiar_fk FOREIGN KEY (codigo_profesion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2159 (class 2606 OID 32558)
-- Dependencies: 2016 1674 1692
-- Name: dato_basico_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT dato_basico_familiar_jugador_fk FOREIGN KEY (codigo_parentesco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2167 (class 2606 OID 32563)
-- Dependencies: 2016 1697 1674
-- Name: dato_basico_ingreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk FOREIGN KEY (codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2168 (class 2606 OID 32568)
-- Dependencies: 1697 1674 2016
-- Name: dato_basico_ingreso_forma_pago_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk1 FOREIGN KEY (codigo_banco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2170 (class 2606 OID 32573)
-- Dependencies: 1698 2016 1674
-- Name: dato_basico_institucion_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT dato_basico_institucion_fk1 FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2172 (class 2606 OID 32578)
-- Dependencies: 1699 2016 1674
-- Name: dato_basico_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT dato_basico_juego_fk FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2174 (class 2606 OID 32583)
-- Dependencies: 1700 2016 1674
-- Name: dato_basico_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT dato_basico_jugador_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2176 (class 2606 OID 32588)
-- Dependencies: 1701 1674 2016
-- Name: dato_basico_logro_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT dato_basico_logro_por_jugador_fk FOREIGN KEY (codigo_logro) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2178 (class 2606 OID 32593)
-- Dependencies: 2016 1674 1702
-- Name: dato_basico_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT dato_basico_medico_fk FOREIGN KEY (codigo_especialidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2179 (class 2606 OID 32598)
-- Dependencies: 1674 2016 1703
-- Name: dato_basico_motivo_sancion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT dato_basico_motivo_sancion_fk FOREIGN KEY (codigo_motivo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2183 (class 2606 OID 32603)
-- Dependencies: 2016 1674 1705
-- Name: dato_basico_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT dato_basico_persona_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2190 (class 2606 OID 32608)
-- Dependencies: 1674 2016 1710
-- Name: dato_basico_recaudo_por_proceso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_recaudo_por_proceso_fk FOREIGN KEY (codigo_importancia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2196 (class 2606 OID 32613)
-- Dependencies: 2016 1715 1674
-- Name: dato_basico_talla_por_indumentaria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT dato_basico_talla_por_indumentaria_fk FOREIGN KEY (codigo_talla) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2197 (class 2606 OID 32618)
-- Dependencies: 2016 1674 1715
-- Name: dato_basico_talla_por_indumentaria_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT dato_basico_talla_por_indumentaria_fk1 FOREIGN KEY (codigo_indumentaria) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2142 (class 2606 OID 32623)
-- Dependencies: 1675 1683 2018
-- Name: dato_conducta_documento_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT dato_conducta_documento_conducta_fk FOREIGN KEY (codigo_dato_conducta) REFERENCES dato_conducta(codigo_dato_conducta);


--
-- TOC entry 2177 (class 2606 OID 32628)
-- Dependencies: 1701 1701 1676 1676 2020
-- Name: dato_deportivo_logro_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT dato_deportivo_logro_por_jugador_fk FOREIGN KEY (codigo_competencia, cedula_rif) REFERENCES dato_deportivo(codigo_competencia, cedula_rif);


--
-- TOC entry 2111 (class 2606 OID 32633)
-- Dependencies: 1677 2022 1665
-- Name: dato_medico_afeccion_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT dato_medico_afeccion_jugador_fk FOREIGN KEY (codigo_dato_medico) REFERENCES dato_medico(codigo_dato_medico);


--
-- TOC entry 2145 (class 2606 OID 32638)
-- Dependencies: 1677 2022 1685
-- Name: dato_medico_documento_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT dato_medico_documento_medico_fk FOREIGN KEY (codigo_dato_medico) REFERENCES dato_medico(codigo_dato_medico);


--
-- TOC entry 2149 (class 2606 OID 32643)
-- Dependencies: 1680 1686 2028
-- Name: divisa_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT divisa_equipo_fk FOREIGN KEY (codigo_divisa) REFERENCES divisa(codigo_divisa);


--
-- TOC entry 2139 (class 2606 OID 32648)
-- Dependencies: 1681 1684 2036
-- Name: documento_entregado_documento_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT documento_entregado_documento_academico_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2141 (class 2606 OID 32653)
-- Dependencies: 2036 1684 1682
-- Name: documento_entregado_documento_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT documento_entregado_documento_ascenso_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2143 (class 2606 OID 32658)
-- Dependencies: 1684 2036 1683
-- Name: documento_entregado_documento_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT documento_entregado_documento_conducta_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2146 (class 2606 OID 32663)
-- Dependencies: 2036 1684 1685
-- Name: documento_entregado_documento_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT documento_entregado_documento_medico_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2117 (class 2606 OID 32668)
-- Dependencies: 2040 1686 1671
-- Name: equipo_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT equipo_comision_equipo_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2152 (class 2606 OID 32673)
-- Dependencies: 1687 2042 1688
-- Name: equipo_competencia_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT equipo_competencia_equipo_juego_fk FOREIGN KEY (codigo_equipo_competencia) REFERENCES equipo_competencia(codigo_equipo_competencia);


--
-- TOC entry 2151 (class 2606 OID 32678)
-- Dependencies: 2040 1687 1686
-- Name: equipo_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT equipo_equipo_competencia_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2137 (class 2606 OID 32683)
-- Dependencies: 1688 2044 1679
-- Name: equipo_juego_desempenno_colectivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT equipo_juego_desempenno_colectivo_fk FOREIGN KEY (codigo_equipo_juego) REFERENCES equipo_juego(codigo_equipo_juego);


--
-- TOC entry 2194 (class 2606 OID 32688)
-- Dependencies: 2040 1686 1714
-- Name: equipo_roster_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT equipo_roster_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2173 (class 2606 OID 32693)
-- Dependencies: 1699 2046 1689
-- Name: estadio_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT estadio_juego_fk FOREIGN KEY (codigo_estadio) REFERENCES estadio(codigo_estadio);


--
-- TOC entry 2160 (class 2606 OID 32698)
-- Dependencies: 1690 2048 1692
-- Name: familiar_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT familiar_familiar_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES familiar(cedula_rif);


--
-- TOC entry 2158 (class 2606 OID 32703)
-- Dependencies: 1691 1692 1692 2052 1691
-- Name: familiar_jugador_familiar_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT familiar_jugador_familiar_comision_equipo_fk FOREIGN KEY (cedula_rif, cedula_familiar) REFERENCES familiar_jugador(cedula_rif, cedula_familiar);


--
-- TOC entry 2164 (class 2606 OID 32708)
-- Dependencies: 1692 1694 2052 1694 1692
-- Name: familiar_jugador_hospedaje_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT familiar_jugador_hospedaje_fk FOREIGN KEY (cedula_rif, cedula_familiar) REFERENCES familiar_jugador(cedula_rif, cedula_familiar);


--
-- TOC entry 2193 (class 2606 OID 32713)
-- Dependencies: 1692 1713 1713 1692 2052
-- Name: familiar_jugador_representante_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY representante
    ADD CONSTRAINT familiar_jugador_representante_fk FOREIGN KEY (cedula_rif, cedula_familiar) REFERENCES familiar_jugador(cedula_rif, cedula_familiar);


--
-- TOC entry 2166 (class 2606 OID 32718)
-- Dependencies: 2056 1694 1694 1694 1695 1695 1695
-- Name: hospedaje_hospedaje_judador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje_jugador
    ADD CONSTRAINT hospedaje_hospedaje_judador_fk FOREIGN KEY (cedula_familiar, codigo_hospedaje, cedula_rif) REFERENCES hospedaje(cedula_familiar, codigo_hospedaje, cedula_rif);


--
-- TOC entry 2126 (class 2606 OID 32723)
-- Dependencies: 1674 1697 2062
-- Name: ingreso_forma_pago_dato_basico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT ingreso_forma_pago_dato_basico_fk FOREIGN KEY (codigo_dato_basico) REFERENCES ingreso_forma_pago(codigo_dato_basico);


--
-- TOC entry 2169 (class 2606 OID 32728)
-- Dependencies: 2060 1697 1696
-- Name: ingreso_ingreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT ingreso_ingreso_forma_pago_fk FOREIGN KEY (numero_documento) REFERENCES ingreso(numero_documento);


--
-- TOC entry 2123 (class 2606 OID 32733)
-- Dependencies: 2064 1698 1673
-- Name: institucion_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT institucion_dato_academico_fk FOREIGN KEY (codigo_institucion) REFERENCES institucion(codigo_institucion);


--
-- TOC entry 2135 (class 2606 OID 32738)
-- Dependencies: 1698 2064 1678
-- Name: institucion_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT institucion_dato_social_fk FOREIGN KEY (codigo_institucion) REFERENCES institucion(codigo_institucion);


--
-- TOC entry 2153 (class 2606 OID 32743)
-- Dependencies: 2066 1688 1699
-- Name: juego_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT juego_equipo_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2201 (class 2606 OID 32748)
-- Dependencies: 1699 2066 1720
-- Name: juego_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY umpire_juego
    ADD CONSTRAINT juego_umpire_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2124 (class 2606 OID 32753)
-- Dependencies: 1700 2068 1673
-- Name: jugador_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT jugador_dato_academico_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2129 (class 2606 OID 32758)
-- Dependencies: 1675 2068 1700
-- Name: jugador_dato_conduct_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT jugador_dato_conduct_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2131 (class 2606 OID 32763)
-- Dependencies: 1676 1700 2068
-- Name: jugador_dato_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT jugador_dato_deportivo_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2132 (class 2606 OID 32768)
-- Dependencies: 1677 1700 2068
-- Name: jugador_dato_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT jugador_dato_medico_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2136 (class 2606 OID 32773)
-- Dependencies: 2068 1700 1678
-- Name: jugador_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT jugador_dato_social_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2161 (class 2606 OID 32778)
-- Dependencies: 2068 1692 1700
-- Name: jugador_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT jugador_familiar_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2181 (class 2606 OID 32783)
-- Dependencies: 2068 1700 1704
-- Name: jugador_participante_plan_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY participante_plan
    ADD CONSTRAINT jugador_participante_plan_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2195 (class 2606 OID 32788)
-- Dependencies: 2068 1700 1714
-- Name: jugador_roster_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT jugador_roster_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2198 (class 2606 OID 32793)
-- Dependencies: 2068 1716 1700
-- Name: jugador_talla_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT jugador_talla_por_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2133 (class 2606 OID 32798)
-- Dependencies: 1702 1677 2072
-- Name: medico_dato_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT medico_dato_medico_fk FOREIGN KEY (numero_colegio) REFERENCES medico(numero_colegio);


--
-- TOC entry 2186 (class 2606 OID 32803)
-- Dependencies: 2076 1704 1708
-- Name: participante_plan_plan_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_jugador
    ADD CONSTRAINT participante_plan_plan_jugador_fk FOREIGN KEY (codigo_participante) REFERENCES participante_plan(codigo_participante);


--
-- TOC entry 2156 (class 2606 OID 32808)
-- Dependencies: 1690 2078 1705
-- Name: persona_familiar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT persona_familiar_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2175 (class 2606 OID 32813)
-- Dependencies: 1705 2078 1700
-- Name: persona_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT persona_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2184 (class 2606 OID 32818)
-- Dependencies: 1705 2078 1706
-- Name: persona_persona_juridica_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_juridica
    ADD CONSTRAINT persona_persona_juridica_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2185 (class 2606 OID 32823)
-- Dependencies: 1705 1707 2078
-- Name: persona_persona_natural_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT persona_persona_natural_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2187 (class 2606 OID 32828)
-- Dependencies: 2086 1709 1708
-- Name: plan_vacacional_plan_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_jugador
    ADD CONSTRAINT plan_vacacional_plan_jugador_fk FOREIGN KEY (codigo_plan) REFERENCES plan_vacacional(codigo_plan);


--
-- TOC entry 2144 (class 2606 OID 32833)
-- Dependencies: 1710 2088 1684
-- Name: recaudo_por_proceso_documentos_entregados_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_entregado
    ADD CONSTRAINT recaudo_por_proceso_documentos_entregados_fk FOREIGN KEY (codigo_recaudo_por_proceso) REFERENCES recaudo_por_proceso(codigo_recaudo_por_proceso);


--
-- TOC entry 2192 (class 2606 OID 32838)
-- Dependencies: 1712 1711 2090
-- Name: regla_regla_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY regla_categoria
    ADD CONSTRAINT regla_regla_categoria_fk FOREIGN KEY (codigo_regla) REFERENCES regla(codigo_regla);


--
-- TOC entry 2113 (class 2606 OID 32843)
-- Dependencies: 1666 1714 2096
-- Name: roster_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ascenso
    ADD CONSTRAINT roster_ascenso_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2182 (class 2606 OID 32848)
-- Dependencies: 2098 1704 1715
-- Name: talla_por_indumentaria_participante_plan_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY participante_plan
    ADD CONSTRAINT talla_por_indumentaria_participante_plan_fk FOREIGN KEY (codigo_talla_indumentaria) REFERENCES talla_por_indumentaria(codigo_talla_indumentaria);


--
-- TOC entry 2199 (class 2606 OID 32853)
-- Dependencies: 2098 1716 1715
-- Name: talla_por_indumentaria_talla_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT talla_por_indumentaria_talla_por_jugador_fk FOREIGN KEY (codigo_talla_indumentaria) REFERENCES talla_por_indumentaria(codigo_talla_indumentaria);


--
-- TOC entry 2120 (class 2606 OID 32858)
-- Dependencies: 2102 1672 1717
-- Name: temporada_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT temporada_competencia_fk FOREIGN KEY (codigo_temporada) REFERENCES temporada(codigo_temporada);


--
-- TOC entry 2127 (class 2606 OID 32863)
-- Dependencies: 1718 1674 2104
-- Name: tipo_dato_dato_basico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT tipo_dato_dato_basico_fk FOREIGN KEY (codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 2200 (class 2606 OID 32868)
-- Dependencies: 1718 1718 2104
-- Name: tipo_dato_tipo_dato_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_dato
    ADD CONSTRAINT tipo_dato_tipo_dato_fk FOREIGN KEY (parent_codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 2202 (class 2606 OID 32873)
-- Dependencies: 1719 2106 1720
-- Name: umpire_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY umpire_juego
    ADD CONSTRAINT umpire_umpire_juego_fk FOREIGN KEY (codigo_umpire) REFERENCES umpire(codigo_umpire);


--
-- TOC entry 2264 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2011-12-16 17:45:02

--
-- PostgreSQL database dump complete
--

