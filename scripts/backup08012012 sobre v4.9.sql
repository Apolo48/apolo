--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.5
-- Dumped by pg_dump version 9.0.3
-- Started on 2012-01-08 12:16:25

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 3006 (class 1262 OID 11826)
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 3007 (class 1262 OID 11826)
-- Dependencies: 3006
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 725 (class 2612 OID 11574)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1917 (class 1259 OID 54141)
-- Dependencies: 6
-- Name: actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE actividad (
    codigo_actividad integer NOT NULL,
    codigo_planificacion_actividad integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_culminacion date NOT NULL,
    estatus character(1) NOT NULL,
    hora_inicio time without time zone NOT NULL,
    hora_fin time without time zone NOT NULL
);


ALTER TABLE public.actividad OWNER TO postgres;

--
-- TOC entry 1918 (class 1259 OID 54144)
-- Dependencies: 6
-- Name: actividad_calendario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE actividad_calendario (
    codigo_actividad_calendario integer NOT NULL,
    codigo_juego integer NOT NULL,
    codigo_competencia integer NOT NULL,
    codigo_tipo_actividad integer NOT NULL,
    codigo_actividad integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_culminacion date NOT NULL,
    descripcion character varying NOT NULL,
    estatus character(1) NOT NULL,
    color character varying,
    hora_inicio time without time zone NOT NULL,
    hora_fin time without time zone NOT NULL
);


ALTER TABLE public.actividad_calendario OWNER TO postgres;

--
-- TOC entry 1919 (class 1259 OID 54150)
-- Dependencies: 6 1918
-- Name: actividad_calendario_codigo_actividad_calendario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE actividad_calendario_codigo_actividad_calendario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.actividad_calendario_codigo_actividad_calendario_seq OWNER TO postgres;

--
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 1919
-- Name: actividad_calendario_codigo_actividad_calendario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividad_calendario_codigo_actividad_calendario_seq OWNED BY actividad_calendario.codigo_actividad_calendario;


--
-- TOC entry 1920 (class 1259 OID 54152)
-- Dependencies: 6 1917
-- Name: actividad_codigo_actividad_seq_6_1_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE actividad_codigo_actividad_seq_6_1_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.actividad_codigo_actividad_seq_6_1_1 OWNER TO postgres;

--
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 1920
-- Name: actividad_codigo_actividad_seq_6_1_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividad_codigo_actividad_seq_6_1_1 OWNED BY actividad.codigo_actividad;


--
-- TOC entry 1921 (class 1259 OID 54154)
-- Dependencies: 6
-- Name: actividad_entrenamiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE actividad_entrenamiento (
    cod_actividad_entrenamiento integer NOT NULL,
    fase integer NOT NULL,
    codigo_categoria integer NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.actividad_entrenamiento OWNER TO postgres;

--
-- TOC entry 1922 (class 1259 OID 54160)
-- Dependencies: 6 1921
-- Name: actividad_entrenamiento_cod_actividad_entrenamiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE actividad_entrenamiento_cod_actividad_entrenamiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.actividad_entrenamiento_cod_actividad_entrenamiento_seq OWNER TO postgres;

--
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 1922
-- Name: actividad_entrenamiento_cod_actividad_entrenamiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividad_entrenamiento_cod_actividad_entrenamiento_seq OWNED BY actividad_entrenamiento.cod_actividad_entrenamiento;


--
-- TOC entry 1923 (class 1259 OID 54162)
-- Dependencies: 6
-- Name: actividad_planificada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE actividad_planificada (
    codigo_indicador_actividad_escala integer NOT NULL,
    codigo_sesion integer NOT NULL,
    cedula_rif character varying NOT NULL,
    tiempo time without time zone NOT NULL,
    estatus character(1) NOT NULL,
    fecha_creacion date NOT NULL,
    hora_creacion time without time zone NOT NULL,
    fecha_modificacion date NOT NULL,
    hora_modificacion time without time zone NOT NULL
);


ALTER TABLE public.actividad_planificada OWNER TO postgres;

--
-- TOC entry 1924 (class 1259 OID 54168)
-- Dependencies: 6
-- Name: actividades_ejecutadas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE actividades_ejecutadas (
    codigo_actividad_ejecutada integer NOT NULL,
    codigo_indicador_actividad_escala integer NOT NULL,
    codigo_sesion_ejecutada integer NOT NULL,
    tiempo time without time zone NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.actividades_ejecutadas OWNER TO postgres;

--
-- TOC entry 1925 (class 1259 OID 54171)
-- Dependencies: 6 1924
-- Name: actividades_ejecutadas_codigo_actividad_ejecutada_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE actividades_ejecutadas_codigo_actividad_ejecutada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.actividades_ejecutadas_codigo_actividad_ejecutada_seq OWNER TO postgres;

--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 1925
-- Name: actividades_ejecutadas_codigo_actividad_ejecutada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividades_ejecutadas_codigo_actividad_ejecutada_seq OWNED BY actividades_ejecutadas.codigo_actividad_ejecutada;


--
-- TOC entry 1926 (class 1259 OID 54173)
-- Dependencies: 6
-- Name: afeccion_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE afeccion_jugador (
    codigo_afeccion integer NOT NULL,
    codigo_dato_medico integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.afeccion_jugador OWNER TO postgres;

--
-- TOC entry 1927 (class 1259 OID 54176)
-- Dependencies: 6
-- Name: afeccion_personal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE afeccion_personal (
    cedula_rif character varying NOT NULL,
    codigo_tipo_afeccion integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.afeccion_personal OWNER TO postgres;

--
-- TOC entry 1928 (class 1259 OID 54182)
-- Dependencies: 6
-- Name: almacen; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE almacen (
    codigo_almacen integer NOT NULL,
    codigo_instalacion integer NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying NOT NULL,
    capacidad character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.almacen OWNER TO postgres;

--
-- TOC entry 1929 (class 1259 OID 54188)
-- Dependencies: 6 1928
-- Name: almacen_codigo_almacen_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE almacen_codigo_almacen_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.almacen_codigo_almacen_seq_1 OWNER TO postgres;

--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 1929
-- Name: almacen_codigo_almacen_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE almacen_codigo_almacen_seq_1 OWNED BY almacen.codigo_almacen;


--
-- TOC entry 1930 (class 1259 OID 54190)
-- Dependencies: 6
-- Name: ascenso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ascenso (
    codigo_ascenso integer NOT NULL,
    codigo_roster integer NOT NULL,
    fecha_ascenso date NOT NULL,
    estatus character(1) NOT NULL,
    tipo_ascenso character varying NOT NULL
);


ALTER TABLE public.ascenso OWNER TO postgres;

--
-- TOC entry 1931 (class 1259 OID 54196)
-- Dependencies: 1930 6
-- Name: ascenso_codigo_ascenso_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ascenso_codigo_ascenso_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ascenso_codigo_ascenso_seq_1 OWNER TO postgres;

--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 1931
-- Name: ascenso_codigo_ascenso_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ascenso_codigo_ascenso_seq_1 OWNED BY ascenso.codigo_ascenso;


--
-- TOC entry 1932 (class 1259 OID 54198)
-- Dependencies: 6
-- Name: asistencia_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE asistencia_jugador (
    codigo_asistencia integer NOT NULL,
    codigo_roster integer NOT NULL,
    codigo_sesion_ejecutada integer NOT NULL,
    eventualidad integer NOT NULL,
    asistencia boolean NOT NULL,
    observacion character varying NOT NULL
);


ALTER TABLE public.asistencia_jugador OWNER TO postgres;

--
-- TOC entry 1933 (class 1259 OID 54204)
-- Dependencies: 1932 6
-- Name: asistencia_jugador_codigo_asistencia_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE asistencia_jugador_codigo_asistencia_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asistencia_jugador_codigo_asistencia_seq_1 OWNER TO postgres;

--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 1933
-- Name: asistencia_jugador_codigo_asistencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE asistencia_jugador_codigo_asistencia_seq_1 OWNED BY asistencia_jugador.codigo_asistencia;


--
-- TOC entry 1934 (class 1259 OID 54206)
-- Dependencies: 6
-- Name: asistencia_personal_entrenamiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE asistencia_personal_entrenamiento (
    codigo_sesion_ejecutada integer NOT NULL,
    codigo_personal_equipo integer NOT NULL,
    cedula_rif character varying NOT NULL,
    asistencia boolean NOT NULL,
    observacion character varying NOT NULL,
    fecha_creacion date NOT NULL,
    hora_creacion time without time zone NOT NULL,
    fecha_modificacion date NOT NULL,
    hora_modificacion time without time zone NOT NULL
);


ALTER TABLE public.asistencia_personal_entrenamiento OWNER TO postgres;

--
-- TOC entry 1935 (class 1259 OID 54212)
-- Dependencies: 6
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categoria (
    codigo_categoria integer NOT NULL,
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
-- TOC entry 1936 (class 1259 OID 54218)
-- Dependencies: 1935 6
-- Name: categoria_codigo_categoria_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE categoria_codigo_categoria_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_codigo_categoria_seq_1 OWNER TO postgres;

--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 1936
-- Name: categoria_codigo_categoria_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE categoria_codigo_categoria_seq_1 OWNED BY categoria.codigo_categoria;


--
-- TOC entry 1937 (class 1259 OID 54220)
-- Dependencies: 6
-- Name: categoria_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE categoria_competencia (
    codigo_competencia integer NOT NULL,
    codigo_categoria integer NOT NULL,
    duracion_hora time without time zone NOT NULL,
    duracion_inning integer NOT NULL
);


ALTER TABLE public.categoria_competencia OWNER TO postgres;

--
-- TOC entry 1938 (class 1259 OID 54223)
-- Dependencies: 6
-- Name: comision_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE comision_actividad (
    codigo_comision integer NOT NULL,
    codigo_actividad integer NOT NULL
);


ALTER TABLE public.comision_actividad OWNER TO postgres;

--
-- TOC entry 1939 (class 1259 OID 54226)
-- Dependencies: 6
-- Name: comision_equipo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE comision_equipo (
    codigo_comision_equipo integer NOT NULL,
    codigo_comision integer NOT NULL,
    codigo_equipo integer NOT NULL,
    maximo_comision integer NOT NULL,
    cantidad_comision integer NOT NULL,
    estatus_1 character(1) NOT NULL
);


ALTER TABLE public.comision_equipo OWNER TO postgres;

--
-- TOC entry 1940 (class 1259 OID 54229)
-- Dependencies: 1939 6
-- Name: comision_equipo_codigo_comision_equipo_seq_1_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE comision_equipo_codigo_comision_equipo_seq_1_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comision_equipo_codigo_comision_equipo_seq_1_1 OWNER TO postgres;

--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 1940
-- Name: comision_equipo_codigo_comision_equipo_seq_1_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE comision_equipo_codigo_comision_equipo_seq_1_1 OWNED BY comision_equipo.codigo_comision_equipo;


--
-- TOC entry 1941 (class 1259 OID 54231)
-- Dependencies: 6
-- Name: competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE competencia (
    codigo_competencia integer NOT NULL,
    codigo_tipo_competencia integer NOT NULL,
    codigo_lapso_deportivo integer NOT NULL,
    codigo_estado integer NOT NULL,
    codigo_organizacion integer NOT NULL,
    codigo_estado_competencia integer NOT NULL,
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
-- TOC entry 1942 (class 1259 OID 54237)
-- Dependencies: 6 1941
-- Name: competencia_codigo_competencia_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE competencia_codigo_competencia_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.competencia_codigo_competencia_seq_1 OWNER TO postgres;

--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 1942
-- Name: competencia_codigo_competencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE competencia_codigo_competencia_seq_1 OWNED BY competencia.codigo_competencia;


--
-- TOC entry 1943 (class 1259 OID 54239)
-- Dependencies: 6
-- Name: concepto_nomina; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE concepto_nomina (
    codigo_concepto_nomina integer NOT NULL,
    valor double precision,
    aplicable_sueldo boolean NOT NULL,
    fecha_creacion date NOT NULL,
    estatus character(1) NOT NULL,
    descripcion character varying NOT NULL,
    codigo_tipo_concepto integer NOT NULL
);


ALTER TABLE public.concepto_nomina OWNER TO postgres;

--
-- TOC entry 1944 (class 1259 OID 54245)
-- Dependencies: 1943 6
-- Name: concepto_nomina_codigo_concepto_nomina_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE concepto_nomina_codigo_concepto_nomina_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.concepto_nomina_codigo_concepto_nomina_seq OWNER TO postgres;

--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 1944
-- Name: concepto_nomina_codigo_concepto_nomina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE concepto_nomina_codigo_concepto_nomina_seq OWNED BY concepto_nomina.codigo_concepto_nomina;


--
-- TOC entry 1945 (class 1259 OID 54247)
-- Dependencies: 6
-- Name: condicion_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE condicion_competencia (
    codigo_condicion integer NOT NULL,
    codigo_tipo_competencia integer NOT NULL
);


ALTER TABLE public.condicion_competencia OWNER TO postgres;

--
-- TOC entry 1946 (class 1259 OID 54250)
-- Dependencies: 6
-- Name: constante; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE constante (
    codigo_constante integer NOT NULL,
    abreviatura character varying NOT NULL,
    nombre character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.constante OWNER TO postgres;

--
-- TOC entry 1947 (class 1259 OID 54256)
-- Dependencies: 6
-- Name: constante_categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE constante_categoria (
    codigo_constante_categoria integer NOT NULL,
    codigo_constante integer NOT NULL,
    codigo_categoria_1 integer NOT NULL,
    valor integer NOT NULL
);


ALTER TABLE public.constante_categoria OWNER TO postgres;

--
-- TOC entry 1948 (class 1259 OID 54259)
-- Dependencies: 1947 6
-- Name: constante_categoria_codigo_constante_categoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE constante_categoria_codigo_constante_categoria_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.constante_categoria_codigo_constante_categoria_seq OWNER TO postgres;

--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 1948
-- Name: constante_categoria_codigo_constante_categoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE constante_categoria_codigo_constante_categoria_seq OWNED BY constante_categoria.codigo_constante_categoria;


--
-- TOC entry 1949 (class 1259 OID 54261)
-- Dependencies: 1946 6
-- Name: constante_codigo_constante_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE constante_codigo_constante_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.constante_codigo_constante_seq_1 OWNER TO postgres;

--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 1949
-- Name: constante_codigo_constante_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE constante_codigo_constante_seq_1 OWNED BY constante.codigo_constante;


--
-- TOC entry 1950 (class 1259 OID 54263)
-- Dependencies: 6
-- Name: cuenta_pagar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cuenta_pagar (
    origen character varying NOT NULL,
    codigo_tipo_documento integer NOT NULL,
    cedula_rif character varying NOT NULL,
    numero_documento date NOT NULL,
    monto_total double precision NOT NULL,
    codigo_tipo_egreso integer NOT NULL,
    fecha_vencimiento date NOT NULL,
    concepto character varying NOT NULL,
    estado character(1) NOT NULL,
    estatus character(1) NOT NULL,
    subtotal double precision
);


ALTER TABLE public.cuenta_pagar OWNER TO postgres;

--
-- TOC entry 1951 (class 1259 OID 54269)
-- Dependencies: 6
-- Name: cuenta_pagar_material; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cuenta_pagar_material (
    codigo_material integer NOT NULL,
    origen character varying NOT NULL,
    cantidad integer NOT NULL,
    precio_unitario double precision NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.cuenta_pagar_material OWNER TO postgres;

--
-- TOC entry 1952 (class 1259 OID 54275)
-- Dependencies: 6
-- Name: dato_academico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_academico (
    codigo_academico integer NOT NULL,
    codigo_anno_escolar integer NOT NULL,
    codigo_curso integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_institucion integer NOT NULL,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_academico OWNER TO postgres;

--
-- TOC entry 1953 (class 1259 OID 54281)
-- Dependencies: 1952 6
-- Name: dato_academico_codigo_academico_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_academico_codigo_academico_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_academico_codigo_academico_seq_1 OWNER TO postgres;

--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 1953
-- Name: dato_academico_codigo_academico_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_academico_codigo_academico_seq_1 OWNED BY dato_academico.codigo_academico;


--
-- TOC entry 1954 (class 1259 OID 54283)
-- Dependencies: 6
-- Name: dato_academico_personal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_academico_personal (
    codigo_dato_academico integer NOT NULL,
    cedula_rif character varying NOT NULL,
    titulo character varying NOT NULL,
    instituto character varying NOT NULL,
    fecha_egreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_academico_personal OWNER TO postgres;

--
-- TOC entry 1955 (class 1259 OID 54289)
-- Dependencies: 6 1954
-- Name: dato_academico_personal_codigo_dato_academico_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_academico_personal_codigo_dato_academico_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_academico_personal_codigo_dato_academico_seq OWNER TO postgres;

--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 1955
-- Name: dato_academico_personal_codigo_dato_academico_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_academico_personal_codigo_dato_academico_seq OWNED BY dato_academico_personal.codigo_dato_academico;


--
-- TOC entry 1956 (class 1259 OID 54291)
-- Dependencies: 6
-- Name: dato_basico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_basico (
    codigo_dato_basico integer NOT NULL,
    codigo_tipo_dato integer NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying,
    estatus character(1) NOT NULL,
    parent_codigo_dato_basico integer
);


ALTER TABLE public.dato_basico OWNER TO postgres;

--
-- TOC entry 1957 (class 1259 OID 54297)
-- Dependencies: 6 1956
-- Name: dato_basico_codigo_dato_basico_seq_2_5; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_basico_codigo_dato_basico_seq_2_5
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_basico_codigo_dato_basico_seq_2_5 OWNER TO postgres;

--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 1957
-- Name: dato_basico_codigo_dato_basico_seq_2_5; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_basico_codigo_dato_basico_seq_2_5 OWNED BY dato_basico.codigo_dato_basico;


--
-- TOC entry 1958 (class 1259 OID 54299)
-- Dependencies: 6
-- Name: sesion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sesion (
    codigo_sesion integer NOT NULL,
    dia_semana integer NOT NULL,
    codigo_plan_entrenamiento integer NOT NULL,
    codigo_equipo integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.sesion OWNER TO postgres;

--
-- TOC entry 1959 (class 1259 OID 54302)
-- Dependencies: 6 1958
-- Name: dato_basico_dia_semana_seq_2_11; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_basico_dia_semana_seq_2_11
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_basico_dia_semana_seq_2_11 OWNER TO postgres;

--
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 1959
-- Name: dato_basico_dia_semana_seq_2_11; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_basico_dia_semana_seq_2_11 OWNED BY sesion.dia_semana;


--
-- TOC entry 1960 (class 1259 OID 54304)
-- Dependencies: 6
-- Name: dato_conducta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_conducta (
    codigo_dato_conducta integer NOT NULL,
    codigo_tipo_suspension integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date,
    observacion character varying,
    cantidad character varying NOT NULL,
    fecha_ocurrencia date NOT NULL,
    cedula_rif character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_conducta OWNER TO postgres;

--
-- TOC entry 1961 (class 1259 OID 54310)
-- Dependencies: 6 1960
-- Name: dato_conducta_codigo_dato_conducta_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_conducta_codigo_dato_conducta_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_conducta_codigo_dato_conducta_seq_1 OWNER TO postgres;

--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 1961
-- Name: dato_conducta_codigo_dato_conducta_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_conducta_codigo_dato_conducta_seq_1 OWNED BY dato_conducta.codigo_dato_conducta;


--
-- TOC entry 1962 (class 1259 OID 54312)
-- Dependencies: 6
-- Name: dato_deportivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_deportivo (
    codigo_competencia integer NOT NULL,
    cedula_rif character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_deportivo OWNER TO postgres;

--
-- TOC entry 1963 (class 1259 OID 54318)
-- Dependencies: 6
-- Name: dato_medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_medico (
    codigo_dato_medico integer NOT NULL,
    numero_colegio character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    fecha_informe date,
    fecha_reincorporacion date,
    observacion character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_medico OWNER TO postgres;

--
-- TOC entry 1964 (class 1259 OID 54324)
-- Dependencies: 1963 6
-- Name: dato_medico_codigo_dato_medico_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_medico_codigo_dato_medico_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_medico_codigo_dato_medico_seq_1 OWNER TO postgres;

--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 1964
-- Name: dato_medico_codigo_dato_medico_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_medico_codigo_dato_medico_seq_1 OWNED BY dato_medico.codigo_dato_medico;


--
-- TOC entry 1965 (class 1259 OID 54326)
-- Dependencies: 6
-- Name: dato_social; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_social (
    codigo_dato_social integer NOT NULL,
    codigo_actividad_social integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_institucion integer NOT NULL,
    horas_dedicadas integer,
    fecha_inicio date,
    estatus character(1) NOT NULL
);


ALTER TABLE public.dato_social OWNER TO postgres;

--
-- TOC entry 1966 (class 1259 OID 54332)
-- Dependencies: 6 1965
-- Name: dato_social_codigo_dato_social_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_social_codigo_dato_social_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_social_codigo_dato_social_seq_1 OWNER TO postgres;

--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 1966
-- Name: dato_social_codigo_dato_social_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_social_codigo_dato_social_seq_1 OWNED BY dato_social.codigo_dato_social;


--
-- TOC entry 1967 (class 1259 OID 54334)
-- Dependencies: 6
-- Name: desempenno_colectivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE desempenno_colectivo (
    codigo_equipo_juego integer NOT NULL,
    codigo_indicador_competencia integer NOT NULL,
    valor real NOT NULL,
    inning integer NOT NULL
);


ALTER TABLE public.desempenno_colectivo OWNER TO postgres;

--
-- TOC entry 1968 (class 1259 OID 54337)
-- Dependencies: 6
-- Name: desempenno_individual; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE desempenno_individual (
    codigo_indicador_competencia integer NOT NULL,
    codigo_line_up integer NOT NULL,
    valor real NOT NULL
);


ALTER TABLE public.desempenno_individual OWNER TO postgres;

--
-- TOC entry 1969 (class 1259 OID 54340)
-- Dependencies: 6
-- Name: desempeo_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE desempeo_jugador (
    codigo_asistencia integer NOT NULL,
    codigo_actividad_ejecutada integer NOT NULL,
    cedula_rif character varying NOT NULL,
    puntuacion character varying NOT NULL,
    estatus character(1) NOT NULL,
    fecha_creacion date NOT NULL,
    hora_creacion time without time zone NOT NULL,
    fecha_modificacion date NOT NULL,
    hora_modificacion character varying NOT NULL
);


ALTER TABLE public.desempeo_jugador OWNER TO postgres;

--
-- TOC entry 1970 (class 1259 OID 54346)
-- Dependencies: 6
-- Name: detalle_requisicion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_requisicion (
    codigo_material integer NOT NULL,
    codigo_requisicion integer NOT NULL,
    cantidad_solicitada integer NOT NULL,
    cantidad_entregada integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.detalle_requisicion OWNER TO postgres;

--
-- TOC entry 1971 (class 1259 OID 54349)
-- Dependencies: 6
-- Name: divisa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE divisa (
    codigo_divisa integer NOT NULL,
    codigo_parroquia integer NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying NOT NULL,
    telefono character varying NOT NULL,
    correo_electronico character varying NOT NULL,
    persona_contacto character varying NOT NULL,
    logo bytea,
    estatus character(1) NOT NULL
);


ALTER TABLE public.divisa OWNER TO postgres;

--
-- TOC entry 1972 (class 1259 OID 54355)
-- Dependencies: 6 1971
-- Name: divisa_codigo_divisa_seq_2; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE divisa_codigo_divisa_seq_2
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.divisa_codigo_divisa_seq_2 OWNER TO postgres;

--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 1972
-- Name: divisa_codigo_divisa_seq_2; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE divisa_codigo_divisa_seq_2 OWNED BY divisa.codigo_divisa;


--
-- TOC entry 1973 (class 1259 OID 54357)
-- Dependencies: 6
-- Name: documento_academico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_academico (
    codigo_documento_entregado integer NOT NULL,
    codigo_academico integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_academico OWNER TO postgres;

--
-- TOC entry 1974 (class 1259 OID 54360)
-- Dependencies: 6
-- Name: documento_acreedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_acreedor (
    codigo_documento_acreedor integer NOT NULL,
    cedula_rif character varying NOT NULL,
    cedula_atleta character varying NOT NULL,
    fecha_emision date NOT NULL,
    fecha_vencimiento date NOT NULL,
    monto double precision NOT NULL,
    concepto character varying NOT NULL,
    estado character(1) NOT NULL,
    estatus character(1) NOT NULL,
    codigo_tipo_ingreso integer NOT NULL
);


ALTER TABLE public.documento_acreedor OWNER TO postgres;

--
-- TOC entry 1975 (class 1259 OID 54366)
-- Dependencies: 1974 6
-- Name: documento_acreedor_codigo_documento_acreedor_seq_3_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE documento_acreedor_codigo_documento_acreedor_seq_3_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.documento_acreedor_codigo_documento_acreedor_seq_3_1 OWNER TO postgres;

--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 1975
-- Name: documento_acreedor_codigo_documento_acreedor_seq_3_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE documento_acreedor_codigo_documento_acreedor_seq_3_1 OWNED BY documento_acreedor.codigo_documento_acreedor;


--
-- TOC entry 1976 (class 1259 OID 54368)
-- Dependencies: 6
-- Name: documento_acreedor_material; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_acreedor_material (
    codigo_material integer NOT NULL,
    codigo_documento_acreedor integer NOT NULL,
    cantidad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_acreedor_material OWNER TO postgres;

--
-- TOC entry 1977 (class 1259 OID 54371)
-- Dependencies: 6
-- Name: documento_ascenso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_ascenso (
    codigo_documento_entregado integer NOT NULL,
    codigo_ascenso integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_ascenso OWNER TO postgres;

--
-- TOC entry 1978 (class 1259 OID 54374)
-- Dependencies: 6
-- Name: documento_conducta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_conducta (
    codigo_documento_entregado integer NOT NULL,
    codigo_dato_conducta integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_conducta OWNER TO postgres;

--
-- TOC entry 1979 (class 1259 OID 54377)
-- Dependencies: 6
-- Name: documento_entregado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_entregado (
    codigo_documento_entregado integer NOT NULL,
    codigo_recaudo_por_proceso integer NOT NULL,
    documento bytea,
    cantidad integer,
    fecha date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_entregado OWNER TO postgres;

--
-- TOC entry 1980 (class 1259 OID 54383)
-- Dependencies: 6
-- Name: documento_indumentaria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_indumentaria (
    codigo_documento_acreedor integer NOT NULL,
    codigo_talla_indumentaria integer NOT NULL,
    monto double precision NOT NULL,
    cantidad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_indumentaria OWNER TO postgres;

--
-- TOC entry 1981 (class 1259 OID 54386)
-- Dependencies: 6
-- Name: documento_medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_medico (
    codigo_documento_entregado integer NOT NULL,
    codigo_dato_medico integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_medico OWNER TO postgres;

--
-- TOC entry 1982 (class 1259 OID 54389)
-- Dependencies: 6
-- Name: documento_personal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_personal (
    codigo_documento_entregado integer NOT NULL,
    cedula_rif character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_personal OWNER TO postgres;

--
-- TOC entry 1983 (class 1259 OID 54395)
-- Dependencies: 1979 6
-- Name: documentos_entregados_codigo_documento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE documentos_entregados_codigo_documento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.documentos_entregados_codigo_documento_seq OWNER TO postgres;

--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 1983
-- Name: documentos_entregados_codigo_documento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE documentos_entregados_codigo_documento_seq OWNED BY documento_entregado.codigo_documento_entregado;


--
-- TOC entry 1984 (class 1259 OID 54397)
-- Dependencies: 6
-- Name: donacion_material; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE donacion_material (
    codigo_material integer NOT NULL,
    codigo_documento_acreedor integer NOT NULL,
    monto_estimado double precision NOT NULL,
    estatus character(1) NOT NULL,
    cantidad integer NOT NULL
);


ALTER TABLE public.donacion_material OWNER TO postgres;

--
-- TOC entry 1985 (class 1259 OID 54400)
-- Dependencies: 6
-- Name: egreso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE egreso (
    numero_documento character varying NOT NULL,
    fecha_pago date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.egreso OWNER TO postgres;

--
-- TOC entry 1986 (class 1259 OID 54406)
-- Dependencies: 6
-- Name: egreso_cuenta_pagar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE egreso_cuenta_pagar (
    origen character varying NOT NULL,
    numero_documento character varying NOT NULL,
    monto_abonado double precision NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.egreso_cuenta_pagar OWNER TO postgres;

--
-- TOC entry 1987 (class 1259 OID 54412)
-- Dependencies: 6
-- Name: egreso_forma_pago; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE egreso_forma_pago (
    numero_documento character varying NOT NULL,
    codigo_banco integer NOT NULL,
    codigo_tarjeta integer NOT NULL,
    monto double precision NOT NULL,
    estatus character(1) NOT NULL,
    numero_docuemnto_pago character varying
);


ALTER TABLE public.egreso_forma_pago OWNER TO postgres;

--
-- TOC entry 1988 (class 1259 OID 54418)
-- Dependencies: 6
-- Name: equipo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE equipo (
    codigo_equipo integer NOT NULL,
    codigo_clasificacion integer NOT NULL,
    codigo_categoria integer NOT NULL,
    codigo_divisa integer NOT NULL,
    nombre character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.equipo OWNER TO postgres;

--
-- TOC entry 1989 (class 1259 OID 54424)
-- Dependencies: 1988 6
-- Name: equipo_codigo_equipo_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE equipo_codigo_equipo_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipo_codigo_equipo_seq_1 OWNER TO postgres;

--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 1989
-- Name: equipo_codigo_equipo_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipo_codigo_equipo_seq_1 OWNED BY equipo.codigo_equipo;


--
-- TOC entry 1990 (class 1259 OID 54426)
-- Dependencies: 6
-- Name: equipo_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE equipo_competencia (
    codigo_equipo_competencia integer NOT NULL,
    delegado character varying NOT NULL,
    codigo_equipo integer NOT NULL,
    codigo_competencia integer NOT NULL
);


ALTER TABLE public.equipo_competencia OWNER TO postgres;

--
-- TOC entry 1991 (class 1259 OID 54432)
-- Dependencies: 1990 6
-- Name: equipo_competencia_codigo_equipo_competencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE equipo_competencia_codigo_equipo_competencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipo_competencia_codigo_equipo_competencia_seq OWNER TO postgres;

--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 1991
-- Name: equipo_competencia_codigo_equipo_competencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipo_competencia_codigo_equipo_competencia_seq OWNED BY equipo_competencia.codigo_equipo_competencia;


--
-- TOC entry 1992 (class 1259 OID 54434)
-- Dependencies: 6
-- Name: equipo_juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE equipo_juego (
    codigo_equipo_juego integer NOT NULL,
    codigo_equipo_competencia integer NOT NULL,
    home_club boolean NOT NULL,
    codigo_juego integer NOT NULL
);


ALTER TABLE public.equipo_juego OWNER TO postgres;

--
-- TOC entry 1993 (class 1259 OID 54437)
-- Dependencies: 6 1992
-- Name: equipo_juego_codigo_equipo_juego_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE equipo_juego_codigo_equipo_juego_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipo_juego_codigo_equipo_juego_seq OWNER TO postgres;

--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 1993
-- Name: equipo_juego_codigo_equipo_juego_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipo_juego_codigo_equipo_juego_seq OWNED BY equipo_juego.codigo_equipo_juego;


--
-- TOC entry 1994 (class 1259 OID 54439)
-- Dependencies: 6
-- Name: escala_medicion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE escala_medicion (
    codigo_escala integer NOT NULL,
    tipo_escala integer NOT NULL,
    nombre character varying NOT NULL,
    estatus character(1) NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE public.escala_medicion OWNER TO postgres;

--
-- TOC entry 1995 (class 1259 OID 54445)
-- Dependencies: 6 1994
-- Name: escala_medicion_codigo_escala_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE escala_medicion_codigo_escala_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.escala_medicion_codigo_escala_seq_1 OWNER TO postgres;

--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 1995
-- Name: escala_medicion_codigo_escala_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE escala_medicion_codigo_escala_seq_1 OWNED BY escala_medicion.codigo_escala;


--
-- TOC entry 1996 (class 1259 OID 54447)
-- Dependencies: 6
-- Name: estadio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estadio (
    codigo_estadio integer NOT NULL,
    codigo_parroquia integer NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.estadio OWNER TO postgres;

--
-- TOC entry 1997 (class 1259 OID 54453)
-- Dependencies: 6 1996
-- Name: estadio_codigo_estadio_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE estadio_codigo_estadio_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estadio_codigo_estadio_seq_1 OWNER TO postgres;

--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 1997
-- Name: estadio_codigo_estadio_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE estadio_codigo_estadio_seq_1 OWNED BY estadio.codigo_estadio;


--
-- TOC entry 1998 (class 1259 OID 54455)
-- Dependencies: 6
-- Name: estado_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estado_actividad (
    codigo_estado integer NOT NULL,
    codigo_actividad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.estado_actividad OWNER TO postgres;

--
-- TOC entry 1999 (class 1259 OID 54458)
-- Dependencies: 6
-- Name: familiar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE familiar (
    cedula_familiar character varying NOT NULL,
    codigo_profesion integer NOT NULL
);


ALTER TABLE public.familiar OWNER TO postgres;

--
-- TOC entry 2000 (class 1259 OID 54464)
-- Dependencies: 6
-- Name: familiar_comision_equipo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE familiar_comision_equipo (
    codigo_comision_equipo integer NOT NULL,
    codigo_familiar_jugador integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.familiar_comision_equipo OWNER TO postgres;

--
-- TOC entry 2001 (class 1259 OID 54467)
-- Dependencies: 6
-- Name: familiar_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE familiar_jugador (
    codigo_familiar_jugador integer NOT NULL,
    cedula_rif character varying NOT NULL,
    cedula_familiar character varying NOT NULL,
    codigo_parentesco integer NOT NULL,
    representante_actual boolean NOT NULL,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.familiar_jugador OWNER TO postgres;

--
-- TOC entry 2002 (class 1259 OID 54473)
-- Dependencies: 6 2001
-- Name: familiar_jugador_codigo_familiar_jugador_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE familiar_jugador_codigo_familiar_jugador_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.familiar_jugador_codigo_familiar_jugador_seq_1 OWNER TO postgres;

--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 2002
-- Name: familiar_jugador_codigo_familiar_jugador_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE familiar_jugador_codigo_familiar_jugador_seq_1 OWNED BY familiar_jugador.codigo_familiar_jugador;


--
-- TOC entry 2003 (class 1259 OID 54475)
-- Dependencies: 6
-- Name: fase_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE fase_competencia (
    codigo_competencia integer NOT NULL,
    numero_fase integer NOT NULL,
    equipo_ingresan integer NOT NULL,
    equipo_clasifican integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.fase_competencia OWNER TO postgres;

--
-- TOC entry 2004 (class 1259 OID 54478)
-- Dependencies: 6
-- Name: horario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE horario (
    codigo_horario integer NOT NULL,
    codigo_plan_temporada integer NOT NULL,
    codigo_dato_basico integer NOT NULL,
    hor_inicio time without time zone NOT NULL,
    hora_fin time without time zone NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.horario OWNER TO postgres;

--
-- TOC entry 2005 (class 1259 OID 54481)
-- Dependencies: 2004 6
-- Name: horario_codigo_horario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE horario_codigo_horario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.horario_codigo_horario_seq OWNER TO postgres;

--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 2005
-- Name: horario_codigo_horario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE horario_codigo_horario_seq OWNED BY horario.codigo_horario;


--
-- TOC entry 2006 (class 1259 OID 54483)
-- Dependencies: 6
-- Name: hospedaje; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE hospedaje (
    codigo_hospedaje integer NOT NULL,
    codigo_familiar_jugador integer NOT NULL,
    codigo_competencia integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.hospedaje OWNER TO postgres;

--
-- TOC entry 2007 (class 1259 OID 54486)
-- Dependencies: 6 2006
-- Name: hospedaje_codigo_hospedaje_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hospedaje_codigo_hospedaje_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hospedaje_codigo_hospedaje_seq_1 OWNER TO postgres;

--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 2007
-- Name: hospedaje_codigo_hospedaje_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hospedaje_codigo_hospedaje_seq_1 OWNED BY hospedaje.codigo_hospedaje;


--
-- TOC entry 2008 (class 1259 OID 54488)
-- Dependencies: 6
-- Name: indicador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE indicador (
    codigo_indicador integer NOT NULL,
    codigo_modalidad integer NOT NULL,
    codigo_tipo integer NOT NULL,
    nombre character varying NOT NULL,
    abreviatura character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.indicador OWNER TO postgres;

--
-- TOC entry 2009 (class 1259 OID 54494)
-- Dependencies: 6
-- Name: indicador_actividad_escala; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE indicador_actividad_escala (
    codigo_indicador_actividad_escala integer NOT NULL,
    indicador integer NOT NULL,
    codigo_escala integer NOT NULL,
    cod_actividad_entrenamiento integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.indicador_actividad_escala OWNER TO postgres;

--
-- TOC entry 2010 (class 1259 OID 54497)
-- Dependencies: 6 2009
-- Name: indicador_actividad_escala_codigo_indicador_actividad_escala21; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE indicador_actividad_escala_codigo_indicador_actividad_escala21
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.indicador_actividad_escala_codigo_indicador_actividad_escala21 OWNER TO postgres;

--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 2010
-- Name: indicador_actividad_escala_codigo_indicador_actividad_escala21; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_actividad_escala_codigo_indicador_actividad_escala21 OWNED BY indicador_actividad_escala.codigo_indicador_actividad_escala;


--
-- TOC entry 2011 (class 1259 OID 54499)
-- Dependencies: 6
-- Name: indicador_categoria_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE indicador_categoria_competencia (
    codigo_indicador_competencia integer NOT NULL,
    codigo_categoria integer NOT NULL,
    codigo_competencia integer NOT NULL,
    codigo_indicador integer NOT NULL
);


ALTER TABLE public.indicador_categoria_competencia OWNER TO postgres;

--
-- TOC entry 2012 (class 1259 OID 54502)
-- Dependencies: 6 2011
-- Name: indicador_categoria_competencia_codigo_indicador_competencia77; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE indicador_categoria_competencia_codigo_indicador_competencia77
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.indicador_categoria_competencia_codigo_indicador_competencia77 OWNER TO postgres;

--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 2012
-- Name: indicador_categoria_competencia_codigo_indicador_competencia77; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_categoria_competencia_codigo_indicador_competencia77 OWNED BY indicador_categoria_competencia.codigo_indicador_competencia;


--
-- TOC entry 2013 (class 1259 OID 54504)
-- Dependencies: 2008 6
-- Name: indicador_codigo_indicador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE indicador_codigo_indicador_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.indicador_codigo_indicador_seq OWNER TO postgres;

--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 2013
-- Name: indicador_codigo_indicador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_codigo_indicador_seq OWNED BY indicador.codigo_indicador;


--
-- TOC entry 2014 (class 1259 OID 54506)
-- Dependencies: 6
-- Name: indicador_test; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE indicador_test (
    codigo_indicador_test integer NOT NULL,
    codigo_escala integer NOT NULL,
    indicador integer NOT NULL,
    codigo_test integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.indicador_test OWNER TO postgres;

--
-- TOC entry 2015 (class 1259 OID 54509)
-- Dependencies: 6 2014
-- Name: indicador_test_codigo_indicador_test_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE indicador_test_codigo_indicador_test_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.indicador_test_codigo_indicador_test_seq OWNER TO postgres;

--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 2015
-- Name: indicador_test_codigo_indicador_test_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_test_codigo_indicador_test_seq OWNED BY indicador_test.codigo_indicador_test;


--
-- TOC entry 2016 (class 1259 OID 54511)
-- Dependencies: 6
-- Name: ingreso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ingreso (
    numero_documento character varying NOT NULL,
    fecha_pago date NOT NULL,
    estatus character(1) NOT NULL,
    codigo_tipo_documento integer NOT NULL
);


ALTER TABLE public.ingreso OWNER TO postgres;

--
-- TOC entry 2017 (class 1259 OID 54517)
-- Dependencies: 6
-- Name: ingreso_documento_acreedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ingreso_documento_acreedor (
    numero_documento character varying NOT NULL,
    codigo_documento_acreedor integer NOT NULL,
    monto_abonado double precision NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.ingreso_documento_acreedor OWNER TO postgres;

--
-- TOC entry 2018 (class 1259 OID 54523)
-- Dependencies: 6
-- Name: ingreso_forma_pago; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ingreso_forma_pago (
    numero_documento character varying NOT NULL,
    codigo_forma_pago integer NOT NULL,
    codigo_tarjeta integer NOT NULL,
    codigo_banco integer NOT NULL,
    monto double precision NOT NULL,
    estatus character(1) NOT NULL,
    numero_documento_pago character varying
);


ALTER TABLE public.ingreso_forma_pago OWNER TO postgres;

--
-- TOC entry 2019 (class 1259 OID 54529)
-- Dependencies: 6
-- Name: instalacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE instalacion (
    codigo_instalacion integer NOT NULL,
    codigo_tipo_instalacion integer NOT NULL,
    descripcion character varying NOT NULL,
    capacidad integer,
    estatus character(1) NOT NULL,
    tamano numeric NOT NULL,
    area character varying
);


ALTER TABLE public.instalacion OWNER TO postgres;

--
-- TOC entry 2020 (class 1259 OID 54535)
-- Dependencies: 6 2019
-- Name: instalacion_codigo_instalacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE instalacion_codigo_instalacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.instalacion_codigo_instalacion_seq OWNER TO postgres;

--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 2020
-- Name: instalacion_codigo_instalacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE instalacion_codigo_instalacion_seq OWNED BY instalacion.codigo_instalacion;


--
-- TOC entry 2021 (class 1259 OID 54537)
-- Dependencies: 6
-- Name: institucion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE institucion (
    codigo_institucion integer NOT NULL,
    codigo_parroquia integer,
    codigo_tipo_institucion integer NOT NULL,
    nombre character varying NOT NULL,
    direccion character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.institucion OWNER TO postgres;

--
-- TOC entry 2022 (class 1259 OID 54543)
-- Dependencies: 6 2021
-- Name: institucion_codigo_institucion_seq_1_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE institucion_codigo_institucion_seq_1_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.institucion_codigo_institucion_seq_1_1 OWNER TO postgres;

--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 2022
-- Name: institucion_codigo_institucion_seq_1_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE institucion_codigo_institucion_seq_1_1 OWNED BY institucion.codigo_institucion;


--
-- TOC entry 2023 (class 1259 OID 54545)
-- Dependencies: 6
-- Name: juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE juego (
    codigo_juego integer NOT NULL,
    codigo_estadio integer NOT NULL,
    codigo_competencia integer NOT NULL,
    codigo_estado integer NOT NULL,
    hora_inicio time without time zone NOT NULL,
    fecha date NOT NULL,
    observaciones character varying NOT NULL,
    cantidad_inning integer NOT NULL,
    duracion time without time zone NOT NULL
);


ALTER TABLE public.juego OWNER TO postgres;

--
-- TOC entry 2024 (class 1259 OID 54551)
-- Dependencies: 2023 6
-- Name: juego_codigo_juego_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE juego_codigo_juego_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.juego_codigo_juego_seq_1 OWNER TO postgres;

--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 2024
-- Name: juego_codigo_juego_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE juego_codigo_juego_seq_1 OWNED BY juego.codigo_juego;


--
-- TOC entry 2025 (class 1259 OID 54553)
-- Dependencies: 6
-- Name: jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE jugador (
    cedula_rif character varying NOT NULL,
    codigo_pais integer,
    codigo_parroquia_nacimiento integer,
    numero integer,
    tipo_de_sangre character varying,
    peso double precision,
    altura double precision,
    brazo_lanzar character varying,
    posicion_bateo character varying
);


ALTER TABLE public.jugador OWNER TO postgres;

--
-- TOC entry 2026 (class 1259 OID 54559)
-- Dependencies: 6
-- Name: jugador_foraneo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE jugador_foraneo (
    cedula integer NOT NULL,
    codigo_tipo_mencion integer NOT NULL,
    codigo_juego integer NOT NULL,
    codigo_equipo_competencia integer NOT NULL,
    nombre character varying NOT NULL
);


ALTER TABLE public.jugador_foraneo OWNER TO postgres;

--
-- TOC entry 2027 (class 1259 OID 54565)
-- Dependencies: 2026 6
-- Name: jugador_foraneo_cedula_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE jugador_foraneo_cedula_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jugador_foraneo_cedula_seq OWNER TO postgres;

--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 2027
-- Name: jugador_foraneo_cedula_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE jugador_foraneo_cedula_seq OWNED BY jugador_foraneo.cedula;


--
-- TOC entry 2028 (class 1259 OID 54567)
-- Dependencies: 6
-- Name: lapso_deportivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE lapso_deportivo (
    codigo_lapso_deportivo integer NOT NULL,
    tipo_lapso integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    nombre character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.lapso_deportivo OWNER TO postgres;

--
-- TOC entry 2029 (class 1259 OID 54573)
-- Dependencies: 6 2028
-- Name: lapso_deportivo_codigo_lapso_deportivo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE lapso_deportivo_codigo_lapso_deportivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lapso_deportivo_codigo_lapso_deportivo_seq OWNER TO postgres;

--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 2029
-- Name: lapso_deportivo_codigo_lapso_deportivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE lapso_deportivo_codigo_lapso_deportivo_seq OWNED BY lapso_deportivo.codigo_lapso_deportivo;


--
-- TOC entry 2030 (class 1259 OID 54575)
-- Dependencies: 6
-- Name: liga; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE liga (
    codigo_liga integer NOT NULL,
    codigo_parroquia integer NOT NULL,
    nombre character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.liga OWNER TO postgres;

--
-- TOC entry 2031 (class 1259 OID 54581)
-- Dependencies: 6
-- Name: liga_categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE liga_categoria (
    codigo_liga integer NOT NULL,
    codigo_categoria integer NOT NULL
);


ALTER TABLE public.liga_categoria OWNER TO postgres;

--
-- TOC entry 2032 (class 1259 OID 54584)
-- Dependencies: 2030 6
-- Name: liga_codigo_liga_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE liga_codigo_liga_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.liga_codigo_liga_seq OWNER TO postgres;

--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 2032
-- Name: liga_codigo_liga_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE liga_codigo_liga_seq OWNED BY liga.codigo_liga;


--
-- TOC entry 2033 (class 1259 OID 54586)
-- Dependencies: 6
-- Name: liga_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE liga_competencia (
    codigo_liga integer NOT NULL,
    codigo_competencia integer NOT NULL
);


ALTER TABLE public.liga_competencia OWNER TO postgres;

--
-- TOC entry 2034 (class 1259 OID 54589)
-- Dependencies: 6
-- Name: line_up; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE line_up (
    codigo_line_up integer NOT NULL,
    codigo_roster_competencia integer NOT NULL,
    codigo_tipo_mencion integer NOT NULL,
    codigo_posicion integer NOT NULL,
    codigo_juego integer NOT NULL
);


ALTER TABLE public.line_up OWNER TO postgres;

--
-- TOC entry 2035 (class 1259 OID 54592)
-- Dependencies: 2034 6
-- Name: line_up_codigo_line_up_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE line_up_codigo_line_up_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.line_up_codigo_line_up_seq OWNER TO postgres;

--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 2035
-- Name: line_up_codigo_line_up_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE line_up_codigo_line_up_seq OWNED BY line_up.codigo_line_up;


--
-- TOC entry 2036 (class 1259 OID 54594)
-- Dependencies: 6
-- Name: logro_por_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE logro_por_jugador (
    codigo_competencia integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_logro integer NOT NULL,
    observacion character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.logro_por_jugador OWNER TO postgres;

--
-- TOC entry 2037 (class 1259 OID 54600)
-- Dependencies: 6
-- Name: material; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE material (
    codigo_material integer NOT NULL,
    codigo_almacen integer NOT NULL,
    codigo_unidad_medida integer NOT NULL,
    codigo_tipo_material integer NOT NULL,
    descripcion character varying NOT NULL,
    cantidad_existencia integer NOT NULL,
    cantidad_presentacion integer,
    cantidad_disponible integer NOT NULL,
    reutilizable boolean NOT NULL,
    stock_minimo integer,
    stock_maximo integer,
    estatus character(1) NOT NULL
);


ALTER TABLE public.material OWNER TO postgres;

--
-- TOC entry 2038 (class 1259 OID 54606)
-- Dependencies: 6
-- Name: material_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE material_actividad (
    codigo_material_actividad integer NOT NULL,
    codigo_actividad integer NOT NULL,
    codigo_material integer NOT NULL,
    estatus character(1) NOT NULL,
    cantidad_entregada integer NOT NULL,
    cantidad_devuelta integer NOT NULL,
    fecha_devolucion date NOT NULL,
    observacion character varying NOT NULL
);


ALTER TABLE public.material_actividad OWNER TO postgres;

--
-- TOC entry 2039 (class 1259 OID 54612)
-- Dependencies: 2038 6
-- Name: material_actividad_codigo_material_actividad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE material_actividad_codigo_material_actividad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.material_actividad_codigo_material_actividad_seq OWNER TO postgres;

--
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 2039
-- Name: material_actividad_codigo_material_actividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE material_actividad_codigo_material_actividad_seq OWNED BY material_actividad.codigo_material_actividad;


--
-- TOC entry 2040 (class 1259 OID 54614)
-- Dependencies: 6
-- Name: material_actividad_planificada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE material_actividad_planificada (
    codigo_planificacion_actividad integer NOT NULL,
    codigo_material integer NOT NULL,
    estatus character(1) NOT NULL,
    cantidad_requerida integer NOT NULL
);


ALTER TABLE public.material_actividad_planificada OWNER TO postgres;

--
-- TOC entry 2041 (class 1259 OID 54617)
-- Dependencies: 2037 6
-- Name: material_codigo_material_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE material_codigo_material_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.material_codigo_material_seq OWNER TO postgres;

--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 2041
-- Name: material_codigo_material_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE material_codigo_material_seq OWNED BY material.codigo_material;


--
-- TOC entry 2042 (class 1259 OID 54619)
-- Dependencies: 6
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE medico (
    numero_colegio character varying NOT NULL,
    codigo_especialidad integer,
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
-- TOC entry 2043 (class 1259 OID 54625)
-- Dependencies: 6
-- Name: modalidad_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE modalidad_competencia (
    codigo_modalidad_competencia integer NOT NULL,
    codigo_tipo_competencia integer NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying NOT NULL
);


ALTER TABLE public.modalidad_competencia OWNER TO postgres;

--
-- TOC entry 2044 (class 1259 OID 54631)
-- Dependencies: 6 2043
-- Name: modalidad_competencia_codigo_modalidad_competencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE modalidad_competencia_codigo_modalidad_competencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.modalidad_competencia_codigo_modalidad_competencia_seq OWNER TO postgres;

--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 2044
-- Name: modalidad_competencia_codigo_modalidad_competencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE modalidad_competencia_codigo_modalidad_competencia_seq OWNED BY modalidad_competencia.codigo_modalidad_competencia;


--
-- TOC entry 2045 (class 1259 OID 54633)
-- Dependencies: 6
-- Name: motivo_sancion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE motivo_sancion (
    codigo_motivo integer NOT NULL,
    codigo_dato_conducta integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.motivo_sancion OWNER TO postgres;

--
-- TOC entry 2046 (class 1259 OID 54636)
-- Dependencies: 6
-- Name: movimiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE movimiento (
    codigo_movimiento integer NOT NULL,
    codigo_nomina character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_concepto_nomina integer NOT NULL,
    monto double precision NOT NULL,
    fecha date NOT NULL,
    justificacion_inasistencia bytea,
    estatus character(1) NOT NULL
);


ALTER TABLE public.movimiento OWNER TO postgres;

--
-- TOC entry 2047 (class 1259 OID 54642)
-- Dependencies: 2046 6
-- Name: movimiento_codigo_movimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE movimiento_codigo_movimiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movimiento_codigo_movimiento_seq OWNER TO postgres;

--
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 2047
-- Name: movimiento_codigo_movimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE movimiento_codigo_movimiento_seq OWNED BY movimiento.codigo_movimiento;


--
-- TOC entry 2048 (class 1259 OID 54644)
-- Dependencies: 6
-- Name: nomina; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE nomina (
    codigo_nomina character varying NOT NULL,
    codigo_tipo_nomina integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.nomina OWNER TO postgres;

--
-- TOC entry 2049 (class 1259 OID 54650)
-- Dependencies: 6 2048
-- Name: nomina_codigo_nomina_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE nomina_codigo_nomina_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nomina_codigo_nomina_seq_1 OWNER TO postgres;

--
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 2049
-- Name: nomina_codigo_nomina_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE nomina_codigo_nomina_seq_1 OWNED BY nomina.codigo_nomina;


--
-- TOC entry 2050 (class 1259 OID 54652)
-- Dependencies: 6
-- Name: nota_entrega; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE nota_entrega (
    codigo_nota_entrega integer NOT NULL,
    origen character varying NOT NULL,
    codigo_documento_acreedor integer NOT NULL,
    fecha_recepcion date NOT NULL
);


ALTER TABLE public.nota_entrega OWNER TO postgres;

--
-- TOC entry 2051 (class 1259 OID 54658)
-- Dependencies: 2050 6
-- Name: nota_entrega_codigo_nota_entrega_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE nota_entrega_codigo_nota_entrega_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nota_entrega_codigo_nota_entrega_seq_1 OWNER TO postgres;

--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 2051
-- Name: nota_entrega_codigo_nota_entrega_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE nota_entrega_codigo_nota_entrega_seq_1 OWNED BY nota_entrega.codigo_nota_entrega;


--
-- TOC entry 2052 (class 1259 OID 54660)
-- Dependencies: 6
-- Name: periodicidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE periodicidad (
    codigo_periodicidad integer NOT NULL,
    codigo_planificacion_actividad integer NOT NULL,
    frecuencia_periodicidad character varying NOT NULL,
    lapso_repeticion integer NOT NULL,
    periodicidad_semanal character varying NOT NULL,
    dia_repeticion integer NOT NULL,
    mes_repeticion integer NOT NULL,
    numero_repeticiones_periodicidad integer NOT NULL,
    fecha_finalizacion_periodicidad date NOT NULL,
    estatus character varying NOT NULL,
    hora_inicio time without time zone NOT NULL,
    hora_culminacion time without time zone NOT NULL,
    estatus_1 character(1) NOT NULL
);


ALTER TABLE public.periodicidad OWNER TO postgres;

--
-- TOC entry 2053 (class 1259 OID 54666)
-- Dependencies: 6 2052
-- Name: periodicidad_codigo_periodicidad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE periodicidad_codigo_periodicidad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.periodicidad_codigo_periodicidad_seq OWNER TO postgres;

--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 2053
-- Name: periodicidad_codigo_periodicidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE periodicidad_codigo_periodicidad_seq OWNED BY periodicidad.codigo_periodicidad;


--
-- TOC entry 2054 (class 1259 OID 54668)
-- Dependencies: 6
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
    cedula_rif character varying NOT NULL,
    codigo_tipo_persona integer NOT NULL,
    codigo_parroquia integer,
    telefono_habitacion character varying,
    fecha_ingreso date NOT NULL,
    correo_electronico character varying,
    twitter character varying,
    direccion character varying,
    fecha_egreso date,
    estatus character(1) NOT NULL
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 2055 (class 1259 OID 54674)
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
-- TOC entry 2056 (class 1259 OID 54680)
-- Dependencies: 6
-- Name: persona_natural; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona_natural (
    cedula_rif character varying NOT NULL,
    codigo_genero integer,
    celular character varying,
    primer_nombre character varying NOT NULL,
    segundo_nombre character varying,
    primer_apellido character varying NOT NULL,
    segundo_apellido character varying,
    foto bytea,
    fecha_nacimiento date,
    estatus character(1) NOT NULL
);


ALTER TABLE public.persona_natural OWNER TO postgres;

--
-- TOC entry 2057 (class 1259 OID 54686)
-- Dependencies: 6
-- Name: personal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal (
    cedula_rif character varying NOT NULL,
    cantidad_hijos integer NOT NULL,
    estatus character(1) NOT NULL,
    estado_civil character varying NOT NULL,
    tipo_sangre character varying
);


ALTER TABLE public.personal OWNER TO postgres;

--
-- TOC entry 2058 (class 1259 OID 54692)
-- Dependencies: 6
-- Name: personal_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_actividad (
    cedula_rif character varying NOT NULL,
    codigo_actividad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.personal_actividad OWNER TO postgres;

--
-- TOC entry 2059 (class 1259 OID 54698)
-- Dependencies: 6
-- Name: personal_actividad_planificada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_actividad_planificada (
    cedula_rif character varying NOT NULL,
    codigo_planificacion_actividad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.personal_actividad_planificada OWNER TO postgres;

--
-- TOC entry 2060 (class 1259 OID 54704)
-- Dependencies: 6
-- Name: personal_cargo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_cargo (
    codigo_personal_cargo integer NOT NULL,
    codigo_cargo integer NOT NULL,
    cedula_rif character varying NOT NULL,
    fecha_fin date,
    fecha_inicio date NOT NULL,
    estatus character(1) NOT NULL,
    estado character(1) NOT NULL
);


ALTER TABLE public.personal_cargo OWNER TO postgres;

--
-- TOC entry 2061 (class 1259 OID 54710)
-- Dependencies: 2060 6
-- Name: personal_cargo_codigo_personal_cargo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_cargo_codigo_personal_cargo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_cargo_codigo_personal_cargo_seq OWNER TO postgres;

--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 2061
-- Name: personal_cargo_codigo_personal_cargo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_cargo_codigo_personal_cargo_seq OWNED BY personal_cargo.codigo_personal_cargo;


--
-- TOC entry 2062 (class 1259 OID 54712)
-- Dependencies: 6
-- Name: personal_concepto_nomina; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_concepto_nomina (
    codigo_personal_concepto_nomina integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_concepto_nomina integer NOT NULL,
    monto real NOT NULL,
    fecha_fin date,
    estatus character(1) NOT NULL,
    fecha_activacion date NOT NULL
);


ALTER TABLE public.personal_concepto_nomina OWNER TO postgres;

--
-- TOC entry 2063 (class 1259 OID 54718)
-- Dependencies: 2062 6
-- Name: personal_concepto_nomina_codigo_personal_concepto_nomina_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_concepto_nomina_codigo_personal_concepto_nomina_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_concepto_nomina_codigo_personal_concepto_nomina_seq OWNER TO postgres;

--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 2063
-- Name: personal_concepto_nomina_codigo_personal_concepto_nomina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_concepto_nomina_codigo_personal_concepto_nomina_seq OWNED BY personal_concepto_nomina.codigo_personal_concepto_nomina;


--
-- TOC entry 2064 (class 1259 OID 54720)
-- Dependencies: 6
-- Name: personal_contrato; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_contrato (
    codigo_personal_contrato integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_modalidad integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date,
    codigo_horario integer NOT NULL
);


ALTER TABLE public.personal_contrato OWNER TO postgres;

--
-- TOC entry 2065 (class 1259 OID 54726)
-- Dependencies: 2064 6
-- Name: personal_contrato_codigo_personal_contrato_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_contrato_codigo_personal_contrato_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_contrato_codigo_personal_contrato_seq OWNER TO postgres;

--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 2065
-- Name: personal_contrato_codigo_personal_contrato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_contrato_codigo_personal_contrato_seq OWNED BY personal_contrato.codigo_personal_contrato;


--
-- TOC entry 2066 (class 1259 OID 54728)
-- Dependencies: 6
-- Name: personal_equipo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_equipo (
    codigo_personal_equipo integer NOT NULL,
    codigo_equipo integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_juego integer NOT NULL,
    codigo_plan_temporada integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_finalizacion date NOT NULL,
    eventualidad character varying NOT NULL
);


ALTER TABLE public.personal_equipo OWNER TO postgres;

--
-- TOC entry 2067 (class 1259 OID 54734)
-- Dependencies: 2066 6
-- Name: personal_equipo_codigo_personal_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_equipo_codigo_personal_equipo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_equipo_codigo_personal_equipo_seq OWNER TO postgres;

--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 2067
-- Name: personal_equipo_codigo_personal_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_equipo_codigo_personal_equipo_seq OWNED BY personal_equipo.codigo_personal_equipo;


--
-- TOC entry 2068 (class 1259 OID 54736)
-- Dependencies: 6
-- Name: personal_equipo_juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_equipo_juego (
    codigo_equipo_juego integer NOT NULL,
    codigo_personal_equipo integer NOT NULL
);


ALTER TABLE public.personal_equipo_juego OWNER TO postgres;

--
-- TOC entry 2069 (class 1259 OID 54739)
-- Dependencies: 6
-- Name: personal_foraneo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_foraneo (
    codigo_personal_foraneo integer NOT NULL,
    codigo_tipo_personal_juego integer NOT NULL,
    nombre character varying NOT NULL
);


ALTER TABLE public.personal_foraneo OWNER TO postgres;

--
-- TOC entry 2070 (class 1259 OID 54745)
-- Dependencies: 2069 6
-- Name: personal_foraneo_codigo_personal_foraneo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_foraneo_codigo_personal_foraneo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_foraneo_codigo_personal_foraneo_seq OWNER TO postgres;

--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 2070
-- Name: personal_foraneo_codigo_personal_foraneo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_foraneo_codigo_personal_foraneo_seq OWNED BY personal_foraneo.codigo_personal_foraneo;


--
-- TOC entry 2071 (class 1259 OID 54747)
-- Dependencies: 6
-- Name: personal_foraneo_juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_foraneo_juego (
    codigo_juego integer NOT NULL,
    codigo_personal_foraneo integer NOT NULL,
    codigo_posicion integer NOT NULL
);


ALTER TABLE public.personal_foraneo_juego OWNER TO postgres;

--
-- TOC entry 2072 (class 1259 OID 54750)
-- Dependencies: 6
-- Name: personal_juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_juego (
    codigo_juego integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_cargo_personal integer NOT NULL
);


ALTER TABLE public.personal_juego OWNER TO postgres;

--
-- TOC entry 2073 (class 1259 OID 54756)
-- Dependencies: 6
-- Name: personal_tipo_nomina; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_tipo_nomina (
    codigo_personal_tipo_nomina integer NOT NULL,
    codigo_tipo_nomina integer NOT NULL,
    cedula_rif character varying NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date,
    estado character(1) NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.personal_tipo_nomina OWNER TO postgres;

--
-- TOC entry 2074 (class 1259 OID 54762)
-- Dependencies: 6 2073
-- Name: personal_tipo_nomina_codigo_personal_tipo_nomina_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_tipo_nomina_codigo_personal_tipo_nomina_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_tipo_nomina_codigo_personal_tipo_nomina_seq OWNER TO postgres;

--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 2074
-- Name: personal_tipo_nomina_codigo_personal_tipo_nomina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_tipo_nomina_codigo_personal_tipo_nomina_seq OWNED BY personal_tipo_nomina.codigo_personal_tipo_nomina;


--
-- TOC entry 2075 (class 1259 OID 54764)
-- Dependencies: 6
-- Name: plan_entrenamiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE plan_entrenamiento (
    codigo_plan_entrenamiento integer NOT NULL,
    codigo_plan_temporada integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.plan_entrenamiento OWNER TO postgres;

--
-- TOC entry 2076 (class 1259 OID 54767)
-- Dependencies: 6 2075
-- Name: plan_entrenamiento_codigo_plan_entrenamiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE plan_entrenamiento_codigo_plan_entrenamiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.plan_entrenamiento_codigo_plan_entrenamiento_seq OWNER TO postgres;

--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 2076
-- Name: plan_entrenamiento_codigo_plan_entrenamiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE plan_entrenamiento_codigo_plan_entrenamiento_seq OWNED BY plan_entrenamiento.codigo_plan_entrenamiento;


--
-- TOC entry 2077 (class 1259 OID 54769)
-- Dependencies: 6
-- Name: plan_rotacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE plan_rotacion (
    codigo_plan_rotacion integer NOT NULL,
    codigo_instalacion integer NOT NULL,
    eventualidad integer NOT NULL,
    codigo_sesion integer NOT NULL,
    fecha_uso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.plan_rotacion OWNER TO postgres;

--
-- TOC entry 2078 (class 1259 OID 54772)
-- Dependencies: 2077 6
-- Name: plan_rotacion_codigo_plan_rotacion_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE plan_rotacion_codigo_plan_rotacion_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.plan_rotacion_codigo_plan_rotacion_seq_1 OWNER TO postgres;

--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 2078
-- Name: plan_rotacion_codigo_plan_rotacion_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE plan_rotacion_codigo_plan_rotacion_seq_1 OWNED BY plan_rotacion.codigo_plan_rotacion;


--
-- TOC entry 2079 (class 1259 OID 54774)
-- Dependencies: 6
-- Name: plan_temporada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE plan_temporada (
    codigo_plan_temporada integer NOT NULL,
    codigo_lapso_deportivo integer NOT NULL,
    codigo_categoria integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.plan_temporada OWNER TO postgres;

--
-- TOC entry 2080 (class 1259 OID 54777)
-- Dependencies: 6 2079
-- Name: plan_temporada_codigo_plan_temporada_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE plan_temporada_codigo_plan_temporada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.plan_temporada_codigo_plan_temporada_seq OWNER TO postgres;

--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 2080
-- Name: plan_temporada_codigo_plan_temporada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE plan_temporada_codigo_plan_temporada_seq OWNED BY plan_temporada.codigo_plan_temporada;


--
-- TOC entry 2081 (class 1259 OID 54779)
-- Dependencies: 6
-- Name: planificacion_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE planificacion_actividad (
    codigo_planificacion_actividad integer NOT NULL,
    codigo_tipo_actividad integer NOT NULL,
    estatus character(1) NOT NULL,
    codigo_instalacion integer NOT NULL,
    actividad_periodico boolean NOT NULL,
    actividad_plantilla boolean NOT NULL
);


ALTER TABLE public.planificacion_actividad OWNER TO postgres;

--
-- TOC entry 2082 (class 1259 OID 54782)
-- Dependencies: 2081 6
-- Name: planificacion_actividad_codigo_planificacion_actividad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE planificacion_actividad_codigo_planificacion_actividad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.planificacion_actividad_codigo_planificacion_actividad_seq OWNER TO postgres;

--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 2082
-- Name: planificacion_actividad_codigo_planificacion_actividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE planificacion_actividad_codigo_planificacion_actividad_seq OWNED BY planificacion_actividad.codigo_planificacion_actividad;


--
-- TOC entry 2083 (class 1259 OID 54784)
-- Dependencies: 6
-- Name: proveedor_banco; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE proveedor_banco (
    codigo_cuenta_banco character varying NOT NULL,
    cedula_rif character varying NOT NULL,
    titular character varying,
    codigo_banco integer NOT NULL
);


ALTER TABLE public.proveedor_banco OWNER TO postgres;

--
-- TOC entry 2084 (class 1259 OID 54790)
-- Dependencies: 6
-- Name: recaudo_por_proceso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recaudo_por_proceso (
    codigo_recaudo_por_proceso integer NOT NULL,
    codigo_importancia integer NOT NULL,
    codigo_proceso integer NOT NULL,
    codigo_documento integer NOT NULL,
    cantidad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.recaudo_por_proceso OWNER TO postgres;

--
-- TOC entry 2085 (class 1259 OID 54793)
-- Dependencies: 6 2084
-- Name: recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1 OWNER TO postgres;

--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 2085
-- Name: recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1 OWNED BY recaudo_por_proceso.codigo_recaudo_por_proceso;


--
-- TOC entry 2086 (class 1259 OID 54795)
-- Dependencies: 6
-- Name: recepcion_material; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recepcion_material (
    codigo_nota_entrega integer NOT NULL,
    codigo_material integer NOT NULL,
    cantidad_recibida integer NOT NULL,
    observaciones character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.recepcion_material OWNER TO postgres;

--
-- TOC entry 2087 (class 1259 OID 54801)
-- Dependencies: 6
-- Name: representante; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE representante (
    codigo_familiar_jugador integer NOT NULL,
    cedula_familiar character varying NOT NULL,
    fecha_asignacion date NOT NULL,
    fecha_retiro date NOT NULL
);


ALTER TABLE public.representante OWNER TO postgres;

--
-- TOC entry 2088 (class 1259 OID 54807)
-- Dependencies: 6
-- Name: requisicion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE requisicion (
    codigo_requisicion integer NOT NULL,
    cedula_rif character varying NOT NULL,
    fecha_emision date NOT NULL,
    fecha_entrega date NOT NULL,
    estado_requisicion character varying NOT NULL,
    motivo_requisicion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.requisicion OWNER TO postgres;

--
-- TOC entry 2089 (class 1259 OID 54813)
-- Dependencies: 6 2088
-- Name: requisicion_codigo_requisicion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE requisicion_codigo_requisicion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.requisicion_codigo_requisicion_seq OWNER TO postgres;

--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 2089
-- Name: requisicion_codigo_requisicion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE requisicion_codigo_requisicion_seq OWNED BY requisicion.codigo_requisicion;


--
-- TOC entry 2090 (class 1259 OID 54815)
-- Dependencies: 6
-- Name: resultado_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE resultado_actividad (
    codigo_resultado integer NOT NULL,
    codigo_actividad integer NOT NULL,
    observaciones character varying,
    estatus character(1) NOT NULL
);


ALTER TABLE public.resultado_actividad OWNER TO postgres;

--
-- TOC entry 2091 (class 1259 OID 54821)
-- Dependencies: 6
-- Name: retiro_traslado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE retiro_traslado (
    cedula_rif character varying NOT NULL,
    codigo_motivo_retiro integer NOT NULL,
    fecha_retiro date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.retiro_traslado OWNER TO postgres;

--
-- TOC entry 2092 (class 1259 OID 54827)
-- Dependencies: 6
-- Name: roster; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE roster (
    codigo_roster integer NOT NULL,
    codigo_equipo integer NOT NULL,
    cedula_rif character varying NOT NULL,
    fecha_ingreso date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.roster OWNER TO postgres;

--
-- TOC entry 2093 (class 1259 OID 54833)
-- Dependencies: 6 2092
-- Name: roster_codigo_roster_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE roster_codigo_roster_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roster_codigo_roster_seq_1 OWNER TO postgres;

--
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 2093
-- Name: roster_codigo_roster_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roster_codigo_roster_seq_1 OWNED BY roster.codigo_roster;


--
-- TOC entry 2094 (class 1259 OID 54835)
-- Dependencies: 6
-- Name: roster_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE roster_competencia (
    codigo_roster_competencia integer NOT NULL,
    codigo_roster integer NOT NULL,
    codigo_tipo_jugador integer NOT NULL,
    codigo_jugador_clave integer NOT NULL,
    codigo_competencia integer NOT NULL
);


ALTER TABLE public.roster_competencia OWNER TO postgres;

--
-- TOC entry 2095 (class 1259 OID 54838)
-- Dependencies: 6 2094
-- Name: roster_competencia_codigo_roster_competencia_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE roster_competencia_codigo_roster_competencia_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roster_competencia_codigo_roster_competencia_seq_1 OWNER TO postgres;

--
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 2095
-- Name: roster_competencia_codigo_roster_competencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roster_competencia_codigo_roster_competencia_seq_1 OWNED BY roster_competencia.codigo_roster_competencia;


--
-- TOC entry 2096 (class 1259 OID 54840)
-- Dependencies: 6
-- Name: seguridad_funcional; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE seguridad_funcional (
    codigo_seguridad integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_dato_basico integer NOT NULL,
    codigo_tipo_dato integer NOT NULL,
    fecha_registro date NOT NULL,
    hora_registro date NOT NULL,
    codigo_registro integer NOT NULL
);


ALTER TABLE public.seguridad_funcional OWNER TO postgres;

--
-- TOC entry 2097 (class 1259 OID 54846)
-- Dependencies: 2096 6
-- Name: seguridad_funcional_codigo_seguridad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seguridad_funcional_codigo_seguridad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seguridad_funcional_codigo_seguridad_seq OWNER TO postgres;

--
-- TOC entry 3073 (class 0 OID 0)
-- Dependencies: 2097
-- Name: seguridad_funcional_codigo_seguridad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE seguridad_funcional_codigo_seguridad_seq OWNED BY seguridad_funcional.codigo_seguridad;


--
-- TOC entry 2098 (class 1259 OID 54848)
-- Dependencies: 6 1958
-- Name: sesion_codigo_sesion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sesion_codigo_sesion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sesion_codigo_sesion_seq OWNER TO postgres;

--
-- TOC entry 3074 (class 0 OID 0)
-- Dependencies: 2098
-- Name: sesion_codigo_sesion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sesion_codigo_sesion_seq OWNED BY sesion.codigo_sesion;


--
-- TOC entry 2099 (class 1259 OID 54850)
-- Dependencies: 6
-- Name: sesion_ejecutada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sesion_ejecutada (
    codigo_sesion_ejecutada integer NOT NULL,
    codigo_plan_rotacion integer NOT NULL,
    eventualidad integer NOT NULL,
    codigo_plan_entrenamiento integer NOT NULL,
    codigo_instalacion integer NOT NULL,
    codigo_equipo integer NOT NULL,
    fecha date NOT NULL,
    hora_inicio time without time zone NOT NULL,
    hora_fin time without time zone NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.sesion_ejecutada OWNER TO postgres;

--
-- TOC entry 2100 (class 1259 OID 54853)
-- Dependencies: 6 2099
-- Name: sesion_ejecutada_codigo_sesion_ejecutada_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sesion_ejecutada_codigo_sesion_ejecutada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sesion_ejecutada_codigo_sesion_ejecutada_seq OWNER TO postgres;

--
-- TOC entry 3075 (class 0 OID 0)
-- Dependencies: 2100
-- Name: sesion_ejecutada_codigo_sesion_ejecutada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sesion_ejecutada_codigo_sesion_ejecutada_seq OWNED BY sesion_ejecutada.codigo_sesion_ejecutada;


--
-- TOC entry 2101 (class 1259 OID 54855)
-- Dependencies: 6
-- Name: solicitud_mantenimiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE solicitud_mantenimiento (
    codigo_solicitud integer NOT NULL,
    codigo_actividad integer NOT NULL,
    codigo_prioridad integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.solicitud_mantenimiento OWNER TO postgres;

--
-- TOC entry 2102 (class 1259 OID 54858)
-- Dependencies: 2101 6
-- Name: solicitud_mantenimiento_codigo_solicitud_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE solicitud_mantenimiento_codigo_solicitud_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.solicitud_mantenimiento_codigo_solicitud_seq_1 OWNER TO postgres;

--
-- TOC entry 3076 (class 0 OID 0)
-- Dependencies: 2102
-- Name: solicitud_mantenimiento_codigo_solicitud_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE solicitud_mantenimiento_codigo_solicitud_seq_1 OWNED BY solicitud_mantenimiento.codigo_solicitud;


--
-- TOC entry 2103 (class 1259 OID 54860)
-- Dependencies: 6
-- Name: talla_por_indumentaria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE talla_por_indumentaria (
    codigo_talla_indumentaria integer NOT NULL,
    codigo_talla integer NOT NULL,
    precio real NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.talla_por_indumentaria OWNER TO postgres;

--
-- TOC entry 2104 (class 1259 OID 54863)
-- Dependencies: 6 2103
-- Name: talla_por_indumentaria_codigo_talla_indumentaria_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE talla_por_indumentaria_codigo_talla_indumentaria_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.talla_por_indumentaria_codigo_talla_indumentaria_seq_1 OWNER TO postgres;

--
-- TOC entry 3077 (class 0 OID 0)
-- Dependencies: 2104
-- Name: talla_por_indumentaria_codigo_talla_indumentaria_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE talla_por_indumentaria_codigo_talla_indumentaria_seq_1 OWNED BY talla_por_indumentaria.codigo_talla_indumentaria;


--
-- TOC entry 2105 (class 1259 OID 54865)
-- Dependencies: 6
-- Name: talla_por_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE talla_por_jugador (
    cedula_rif character varying NOT NULL,
    codigo_talla_indumentaria integer NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.talla_por_jugador OWNER TO postgres;

--
-- TOC entry 2106 (class 1259 OID 54872)
-- Dependencies: 6
-- Name: tarea_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tarea_actividad (
    codigo_tarea_actividad integer NOT NULL,
    codigo_actividad integer NOT NULL,
    codigo_tarea integer NOT NULL,
    cedula_rif character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.tarea_actividad OWNER TO postgres;

--
-- TOC entry 2107 (class 1259 OID 54878)
-- Dependencies: 2106 6
-- Name: tarea_actividad_codigo_tarea_actividad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tarea_actividad_codigo_tarea_actividad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarea_actividad_codigo_tarea_actividad_seq OWNER TO postgres;

--
-- TOC entry 3078 (class 0 OID 0)
-- Dependencies: 2107
-- Name: tarea_actividad_codigo_tarea_actividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarea_actividad_codigo_tarea_actividad_seq OWNED BY tarea_actividad.codigo_tarea_actividad;


--
-- TOC entry 2108 (class 1259 OID 54880)
-- Dependencies: 6
-- Name: tarea_actividad_planificada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tarea_actividad_planificada (
    codigo_personal_actividad_planificada integer NOT NULL,
    codigo_planificacion_actividad integer NOT NULL,
    codigo_tarea integer NOT NULL,
    cedula_rif character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.tarea_actividad_planificada OWNER TO postgres;

--
-- TOC entry 2109 (class 1259 OID 54886)
-- Dependencies: 2108 6
-- Name: tarea_actividad_planificada_codigo_personal_actividad_planif18; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tarea_actividad_planificada_codigo_personal_actividad_planif18
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tarea_actividad_planificada_codigo_personal_actividad_planif18 OWNER TO postgres;

--
-- TOC entry 3079 (class 0 OID 0)
-- Dependencies: 2109
-- Name: tarea_actividad_planificada_codigo_personal_actividad_planif18; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarea_actividad_planificada_codigo_personal_actividad_planif18 OWNED BY tarea_actividad_planificada.codigo_personal_actividad_planificada;


--
-- TOC entry 2110 (class 1259 OID 54888)
-- Dependencies: 6
-- Name: test_evaluativo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE test_evaluativo (
    codigo_test integer NOT NULL,
    codigo_equipo integer NOT NULL,
    fecha date NOT NULL
);


ALTER TABLE public.test_evaluativo OWNER TO postgres;

--
-- TOC entry 2111 (class 1259 OID 54891)
-- Dependencies: 2110 6
-- Name: test_evaluativo_codigo_test_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE test_evaluativo_codigo_test_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.test_evaluativo_codigo_test_seq OWNER TO postgres;

--
-- TOC entry 3080 (class 0 OID 0)
-- Dependencies: 2111
-- Name: test_evaluativo_codigo_test_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE test_evaluativo_codigo_test_seq OWNED BY test_evaluativo.codigo_test;


--
-- TOC entry 2112 (class 1259 OID 54893)
-- Dependencies: 6
-- Name: test_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE test_jugador (
    codigo_indicador_test integer NOT NULL,
    codigo_roster integer NOT NULL,
    puntuacion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.test_jugador OWNER TO postgres;

--
-- TOC entry 2113 (class 1259 OID 54899)
-- Dependencies: 6
-- Name: tipo_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_competencia (
    codigo_tipo_competencia integer NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying NOT NULL,
    estatus integer NOT NULL
);


ALTER TABLE public.tipo_competencia OWNER TO postgres;

--
-- TOC entry 2114 (class 1259 OID 54905)
-- Dependencies: 6 2113
-- Name: tipo_competencia_codigo_tipo_competencia_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_competencia_codigo_tipo_competencia_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_competencia_codigo_tipo_competencia_seq_1 OWNER TO postgres;

--
-- TOC entry 3081 (class 0 OID 0)
-- Dependencies: 2114
-- Name: tipo_competencia_codigo_tipo_competencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_competencia_codigo_tipo_competencia_seq_1 OWNED BY tipo_competencia.codigo_tipo_competencia;


--
-- TOC entry 2115 (class 1259 OID 54907)
-- Dependencies: 6
-- Name: tipo_dato; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_dato (
    codigo_tipo_dato integer NOT NULL,
    nombre character varying NOT NULL,
    descripcion character varying,
    estatus character(1) NOT NULL,
    tipo boolean NOT NULL,
    parent_codigo_tipo_dato integer
);


ALTER TABLE public.tipo_dato OWNER TO postgres;

--
-- TOC entry 2116 (class 1259 OID 54913)
-- Dependencies: 2115 6
-- Name: tipo_dato_codigo_tipo_dato_seq_1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_dato_codigo_tipo_dato_seq_1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_dato_codigo_tipo_dato_seq_1 OWNER TO postgres;

--
-- TOC entry 3082 (class 0 OID 0)
-- Dependencies: 2116
-- Name: tipo_dato_codigo_tipo_dato_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_dato_codigo_tipo_dato_seq_1 OWNED BY tipo_dato.codigo_tipo_dato;


--
-- TOC entry 2117 (class 1259 OID 54915)
-- Dependencies: 6
-- Name: tipo_pago_representante; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_pago_representante (
    codigo_tipo_pago_representante integer NOT NULL,
    codigo_tipo_ingreso integer NOT NULL,
    descripcion character varying NOT NULL,
    monto double precision,
    estatus character(1) NOT NULL
);


ALTER TABLE public.tipo_pago_representante OWNER TO postgres;

--
-- TOC entry 2118 (class 1259 OID 54921)
-- Dependencies: 2117 6
-- Name: tipo_pago_representante_codigo_tipo_pago_representante_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_pago_representante_codigo_tipo_pago_representante_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_pago_representante_codigo_tipo_pago_representante_seq OWNER TO postgres;

--
-- TOC entry 3083 (class 0 OID 0)
-- Dependencies: 2118
-- Name: tipo_pago_representante_codigo_tipo_pago_representante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_pago_representante_codigo_tipo_pago_representante_seq OWNED BY tipo_pago_representante.codigo_tipo_pago_representante;


--
-- TOC entry 2119 (class 1259 OID 54923)
-- Dependencies: 6
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    cedula_rif character varying NOT NULL,
    nick character varying NOT NULL,
    password character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 2120 (class 1259 OID 54929)
-- Dependencies: 6
-- Name: valor_escala; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE valor_escala (
    codigo_valor_escala integer NOT NULL,
    codigo_escala integer NOT NULL,
    valor character varying NOT NULL,
    descripcion character varying NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.valor_escala OWNER TO postgres;

--
-- TOC entry 2121 (class 1259 OID 54935)
-- Dependencies: 2120 6
-- Name: valor_escala_codigo_valor_escala_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE valor_escala_codigo_valor_escala_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.valor_escala_codigo_valor_escala_seq OWNER TO postgres;

--
-- TOC entry 3084 (class 0 OID 0)
-- Dependencies: 2121
-- Name: valor_escala_codigo_valor_escala_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE valor_escala_codigo_valor_escala_seq OWNED BY valor_escala.codigo_valor_escala;


--
-- TOC entry 2399 (class 2604 OID 54937)
-- Dependencies: 1920 1917
-- Name: codigo_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividad ALTER COLUMN codigo_actividad SET DEFAULT nextval('actividad_codigo_actividad_seq_6_1_1'::regclass);


--
-- TOC entry 2400 (class 2604 OID 54938)
-- Dependencies: 1919 1918
-- Name: codigo_actividad_calendario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividad_calendario ALTER COLUMN codigo_actividad_calendario SET DEFAULT nextval('actividad_calendario_codigo_actividad_calendario_seq'::regclass);


--
-- TOC entry 2401 (class 2604 OID 54939)
-- Dependencies: 1922 1921
-- Name: cod_actividad_entrenamiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividad_entrenamiento ALTER COLUMN cod_actividad_entrenamiento SET DEFAULT nextval('actividad_entrenamiento_cod_actividad_entrenamiento_seq'::regclass);


--
-- TOC entry 2402 (class 2604 OID 54940)
-- Dependencies: 1925 1924
-- Name: codigo_actividad_ejecutada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividades_ejecutadas ALTER COLUMN codigo_actividad_ejecutada SET DEFAULT nextval('actividades_ejecutadas_codigo_actividad_ejecutada_seq'::regclass);


--
-- TOC entry 2403 (class 2604 OID 54941)
-- Dependencies: 1929 1928
-- Name: codigo_almacen; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE almacen ALTER COLUMN codigo_almacen SET DEFAULT nextval('almacen_codigo_almacen_seq_1'::regclass);


--
-- TOC entry 2404 (class 2604 OID 54942)
-- Dependencies: 1931 1930
-- Name: codigo_ascenso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ascenso ALTER COLUMN codigo_ascenso SET DEFAULT nextval('ascenso_codigo_ascenso_seq_1'::regclass);


--
-- TOC entry 2405 (class 2604 OID 54943)
-- Dependencies: 1933 1932
-- Name: codigo_asistencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE asistencia_jugador ALTER COLUMN codigo_asistencia SET DEFAULT nextval('asistencia_jugador_codigo_asistencia_seq_1'::regclass);


--
-- TOC entry 2406 (class 2604 OID 54944)
-- Dependencies: 1936 1935
-- Name: codigo_categoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE categoria ALTER COLUMN codigo_categoria SET DEFAULT nextval('categoria_codigo_categoria_seq_1'::regclass);


--
-- TOC entry 2407 (class 2604 OID 54945)
-- Dependencies: 1940 1939
-- Name: codigo_comision_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE comision_equipo ALTER COLUMN codigo_comision_equipo SET DEFAULT nextval('comision_equipo_codigo_comision_equipo_seq_1_1'::regclass);


--
-- TOC entry 2408 (class 2604 OID 54946)
-- Dependencies: 1942 1941
-- Name: codigo_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE competencia ALTER COLUMN codigo_competencia SET DEFAULT nextval('competencia_codigo_competencia_seq_1'::regclass);


--
-- TOC entry 2409 (class 2604 OID 54947)
-- Dependencies: 1944 1943
-- Name: codigo_concepto_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE concepto_nomina ALTER COLUMN codigo_concepto_nomina SET DEFAULT nextval('concepto_nomina_codigo_concepto_nomina_seq'::regclass);


--
-- TOC entry 2410 (class 2604 OID 54948)
-- Dependencies: 1949 1946
-- Name: codigo_constante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE constante ALTER COLUMN codigo_constante SET DEFAULT nextval('constante_codigo_constante_seq_1'::regclass);


--
-- TOC entry 2411 (class 2604 OID 54949)
-- Dependencies: 1948 1947
-- Name: codigo_constante_categoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE constante_categoria ALTER COLUMN codigo_constante_categoria SET DEFAULT nextval('constante_categoria_codigo_constante_categoria_seq'::regclass);


--
-- TOC entry 2412 (class 2604 OID 54950)
-- Dependencies: 1953 1952
-- Name: codigo_academico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_academico ALTER COLUMN codigo_academico SET DEFAULT nextval('dato_academico_codigo_academico_seq_1'::regclass);


--
-- TOC entry 2413 (class 2604 OID 54951)
-- Dependencies: 1955 1954
-- Name: codigo_dato_academico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_academico_personal ALTER COLUMN codigo_dato_academico SET DEFAULT nextval('dato_academico_personal_codigo_dato_academico_seq'::regclass);


--
-- TOC entry 2414 (class 2604 OID 54952)
-- Dependencies: 1957 1956
-- Name: codigo_dato_basico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_basico ALTER COLUMN codigo_dato_basico SET DEFAULT nextval('dato_basico_codigo_dato_basico_seq_2_5'::regclass);


--
-- TOC entry 2417 (class 2604 OID 54953)
-- Dependencies: 1961 1960
-- Name: codigo_dato_conducta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_conducta ALTER COLUMN codigo_dato_conducta SET DEFAULT nextval('dato_conducta_codigo_dato_conducta_seq_1'::regclass);


--
-- TOC entry 2418 (class 2604 OID 54954)
-- Dependencies: 1964 1963
-- Name: codigo_dato_medico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_medico ALTER COLUMN codigo_dato_medico SET DEFAULT nextval('dato_medico_codigo_dato_medico_seq_1'::regclass);


--
-- TOC entry 2419 (class 2604 OID 54955)
-- Dependencies: 1966 1965
-- Name: codigo_dato_social; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_social ALTER COLUMN codigo_dato_social SET DEFAULT nextval('dato_social_codigo_dato_social_seq_1'::regclass);


--
-- TOC entry 2420 (class 2604 OID 54956)
-- Dependencies: 1972 1971
-- Name: codigo_divisa; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE divisa ALTER COLUMN codigo_divisa SET DEFAULT nextval('divisa_codigo_divisa_seq_2'::regclass);


--
-- TOC entry 2421 (class 2604 OID 54957)
-- Dependencies: 1975 1974
-- Name: codigo_documento_acreedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE documento_acreedor ALTER COLUMN codigo_documento_acreedor SET DEFAULT nextval('documento_acreedor_codigo_documento_acreedor_seq_3_1'::regclass);


--
-- TOC entry 2422 (class 2604 OID 54958)
-- Dependencies: 1983 1979
-- Name: codigo_documento_entregado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE documento_entregado ALTER COLUMN codigo_documento_entregado SET DEFAULT nextval('documentos_entregados_codigo_documento_seq'::regclass);


--
-- TOC entry 2423 (class 2604 OID 54959)
-- Dependencies: 1989 1988
-- Name: codigo_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE equipo ALTER COLUMN codigo_equipo SET DEFAULT nextval('equipo_codigo_equipo_seq_1'::regclass);


--
-- TOC entry 2424 (class 2604 OID 54960)
-- Dependencies: 1991 1990
-- Name: codigo_equipo_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE equipo_competencia ALTER COLUMN codigo_equipo_competencia SET DEFAULT nextval('equipo_competencia_codigo_equipo_competencia_seq'::regclass);


--
-- TOC entry 2425 (class 2604 OID 54961)
-- Dependencies: 1993 1992
-- Name: codigo_equipo_juego; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE equipo_juego ALTER COLUMN codigo_equipo_juego SET DEFAULT nextval('equipo_juego_codigo_equipo_juego_seq'::regclass);


--
-- TOC entry 2426 (class 2604 OID 54962)
-- Dependencies: 1995 1994
-- Name: codigo_escala; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE escala_medicion ALTER COLUMN codigo_escala SET DEFAULT nextval('escala_medicion_codigo_escala_seq_1'::regclass);


--
-- TOC entry 2427 (class 2604 OID 54963)
-- Dependencies: 1997 1996
-- Name: codigo_estadio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE estadio ALTER COLUMN codigo_estadio SET DEFAULT nextval('estadio_codigo_estadio_seq_1'::regclass);


--
-- TOC entry 2428 (class 2604 OID 54964)
-- Dependencies: 2002 2001
-- Name: codigo_familiar_jugador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE familiar_jugador ALTER COLUMN codigo_familiar_jugador SET DEFAULT nextval('familiar_jugador_codigo_familiar_jugador_seq_1'::regclass);


--
-- TOC entry 2429 (class 2604 OID 54965)
-- Dependencies: 2005 2004
-- Name: codigo_horario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE horario ALTER COLUMN codigo_horario SET DEFAULT nextval('horario_codigo_horario_seq'::regclass);


--
-- TOC entry 2430 (class 2604 OID 54966)
-- Dependencies: 2007 2006
-- Name: codigo_hospedaje; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE hospedaje ALTER COLUMN codigo_hospedaje SET DEFAULT nextval('hospedaje_codigo_hospedaje_seq_1'::regclass);


--
-- TOC entry 2431 (class 2604 OID 54967)
-- Dependencies: 2013 2008
-- Name: codigo_indicador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador ALTER COLUMN codigo_indicador SET DEFAULT nextval('indicador_codigo_indicador_seq'::regclass);


--
-- TOC entry 2432 (class 2604 OID 54968)
-- Dependencies: 2010 2009
-- Name: codigo_indicador_actividad_escala; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador_actividad_escala ALTER COLUMN codigo_indicador_actividad_escala SET DEFAULT nextval('indicador_actividad_escala_codigo_indicador_actividad_escala21'::regclass);


--
-- TOC entry 2433 (class 2604 OID 54969)
-- Dependencies: 2012 2011
-- Name: codigo_indicador_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador_categoria_competencia ALTER COLUMN codigo_indicador_competencia SET DEFAULT nextval('indicador_categoria_competencia_codigo_indicador_competencia77'::regclass);


--
-- TOC entry 2434 (class 2604 OID 54970)
-- Dependencies: 2015 2014
-- Name: codigo_indicador_test; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador_test ALTER COLUMN codigo_indicador_test SET DEFAULT nextval('indicador_test_codigo_indicador_test_seq'::regclass);


--
-- TOC entry 2435 (class 2604 OID 54971)
-- Dependencies: 2020 2019
-- Name: codigo_instalacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE instalacion ALTER COLUMN codigo_instalacion SET DEFAULT nextval('instalacion_codigo_instalacion_seq'::regclass);


--
-- TOC entry 2436 (class 2604 OID 54972)
-- Dependencies: 2022 2021
-- Name: codigo_institucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE institucion ALTER COLUMN codigo_institucion SET DEFAULT nextval('institucion_codigo_institucion_seq_1_1'::regclass);


--
-- TOC entry 2437 (class 2604 OID 54973)
-- Dependencies: 2024 2023
-- Name: codigo_juego; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE juego ALTER COLUMN codigo_juego SET DEFAULT nextval('juego_codigo_juego_seq_1'::regclass);


--
-- TOC entry 2438 (class 2604 OID 54974)
-- Dependencies: 2027 2026
-- Name: cedula; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE jugador_foraneo ALTER COLUMN cedula SET DEFAULT nextval('jugador_foraneo_cedula_seq'::regclass);


--
-- TOC entry 2439 (class 2604 OID 54975)
-- Dependencies: 2029 2028
-- Name: codigo_lapso_deportivo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE lapso_deportivo ALTER COLUMN codigo_lapso_deportivo SET DEFAULT nextval('lapso_deportivo_codigo_lapso_deportivo_seq'::regclass);


--
-- TOC entry 2440 (class 2604 OID 54976)
-- Dependencies: 2032 2030
-- Name: codigo_liga; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE liga ALTER COLUMN codigo_liga SET DEFAULT nextval('liga_codigo_liga_seq'::regclass);


--
-- TOC entry 2441 (class 2604 OID 54977)
-- Dependencies: 2035 2034
-- Name: codigo_line_up; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE line_up ALTER COLUMN codigo_line_up SET DEFAULT nextval('line_up_codigo_line_up_seq'::regclass);


--
-- TOC entry 2442 (class 2604 OID 54978)
-- Dependencies: 2041 2037
-- Name: codigo_material; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE material ALTER COLUMN codigo_material SET DEFAULT nextval('material_codigo_material_seq'::regclass);


--
-- TOC entry 2443 (class 2604 OID 54979)
-- Dependencies: 2039 2038
-- Name: codigo_material_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE material_actividad ALTER COLUMN codigo_material_actividad SET DEFAULT nextval('material_actividad_codigo_material_actividad_seq'::regclass);


--
-- TOC entry 2444 (class 2604 OID 54980)
-- Dependencies: 2044 2043
-- Name: codigo_modalidad_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE modalidad_competencia ALTER COLUMN codigo_modalidad_competencia SET DEFAULT nextval('modalidad_competencia_codigo_modalidad_competencia_seq'::regclass);


--
-- TOC entry 2445 (class 2604 OID 54981)
-- Dependencies: 2047 2046
-- Name: codigo_movimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE movimiento ALTER COLUMN codigo_movimiento SET DEFAULT nextval('movimiento_codigo_movimiento_seq'::regclass);


--
-- TOC entry 2446 (class 2604 OID 54982)
-- Dependencies: 2049 2048
-- Name: codigo_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE nomina ALTER COLUMN codigo_nomina SET DEFAULT nextval('nomina_codigo_nomina_seq_1'::regclass);


--
-- TOC entry 2447 (class 2604 OID 54983)
-- Dependencies: 2051 2050
-- Name: codigo_nota_entrega; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE nota_entrega ALTER COLUMN codigo_nota_entrega SET DEFAULT nextval('nota_entrega_codigo_nota_entrega_seq_1'::regclass);


--
-- TOC entry 2448 (class 2604 OID 54984)
-- Dependencies: 2053 2052
-- Name: codigo_periodicidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE periodicidad ALTER COLUMN codigo_periodicidad SET DEFAULT nextval('periodicidad_codigo_periodicidad_seq'::regclass);


--
-- TOC entry 2449 (class 2604 OID 54985)
-- Dependencies: 2061 2060
-- Name: codigo_personal_cargo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_cargo ALTER COLUMN codigo_personal_cargo SET DEFAULT nextval('personal_cargo_codigo_personal_cargo_seq'::regclass);


--
-- TOC entry 2450 (class 2604 OID 54986)
-- Dependencies: 2063 2062
-- Name: codigo_personal_concepto_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_concepto_nomina ALTER COLUMN codigo_personal_concepto_nomina SET DEFAULT nextval('personal_concepto_nomina_codigo_personal_concepto_nomina_seq'::regclass);


--
-- TOC entry 2451 (class 2604 OID 54987)
-- Dependencies: 2065 2064
-- Name: codigo_personal_contrato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_contrato ALTER COLUMN codigo_personal_contrato SET DEFAULT nextval('personal_contrato_codigo_personal_contrato_seq'::regclass);


--
-- TOC entry 2452 (class 2604 OID 54988)
-- Dependencies: 2067 2066
-- Name: codigo_personal_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_equipo ALTER COLUMN codigo_personal_equipo SET DEFAULT nextval('personal_equipo_codigo_personal_equipo_seq'::regclass);


--
-- TOC entry 2453 (class 2604 OID 54989)
-- Dependencies: 2070 2069
-- Name: codigo_personal_foraneo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_foraneo ALTER COLUMN codigo_personal_foraneo SET DEFAULT nextval('personal_foraneo_codigo_personal_foraneo_seq'::regclass);


--
-- TOC entry 2454 (class 2604 OID 54990)
-- Dependencies: 2074 2073
-- Name: codigo_personal_tipo_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_tipo_nomina ALTER COLUMN codigo_personal_tipo_nomina SET DEFAULT nextval('personal_tipo_nomina_codigo_personal_tipo_nomina_seq'::regclass);


--
-- TOC entry 2455 (class 2604 OID 54991)
-- Dependencies: 2076 2075
-- Name: codigo_plan_entrenamiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE plan_entrenamiento ALTER COLUMN codigo_plan_entrenamiento SET DEFAULT nextval('plan_entrenamiento_codigo_plan_entrenamiento_seq'::regclass);


--
-- TOC entry 2456 (class 2604 OID 54992)
-- Dependencies: 2078 2077
-- Name: codigo_plan_rotacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE plan_rotacion ALTER COLUMN codigo_plan_rotacion SET DEFAULT nextval('plan_rotacion_codigo_plan_rotacion_seq_1'::regclass);


--
-- TOC entry 2457 (class 2604 OID 54993)
-- Dependencies: 2080 2079
-- Name: codigo_plan_temporada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE plan_temporada ALTER COLUMN codigo_plan_temporada SET DEFAULT nextval('plan_temporada_codigo_plan_temporada_seq'::regclass);


--
-- TOC entry 2458 (class 2604 OID 54994)
-- Dependencies: 2082 2081
-- Name: codigo_planificacion_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE planificacion_actividad ALTER COLUMN codigo_planificacion_actividad SET DEFAULT nextval('planificacion_actividad_codigo_planificacion_actividad_seq'::regclass);


--
-- TOC entry 2459 (class 2604 OID 54995)
-- Dependencies: 2085 2084
-- Name: codigo_recaudo_por_proceso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE recaudo_por_proceso ALTER COLUMN codigo_recaudo_por_proceso SET DEFAULT nextval('recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1'::regclass);


--
-- TOC entry 2460 (class 2604 OID 54996)
-- Dependencies: 2089 2088
-- Name: codigo_requisicion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE requisicion ALTER COLUMN codigo_requisicion SET DEFAULT nextval('requisicion_codigo_requisicion_seq'::regclass);


--
-- TOC entry 2461 (class 2604 OID 54997)
-- Dependencies: 2093 2092
-- Name: codigo_roster; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE roster ALTER COLUMN codigo_roster SET DEFAULT nextval('roster_codigo_roster_seq_1'::regclass);


--
-- TOC entry 2462 (class 2604 OID 54998)
-- Dependencies: 2095 2094
-- Name: codigo_roster_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE roster_competencia ALTER COLUMN codigo_roster_competencia SET DEFAULT nextval('roster_competencia_codigo_roster_competencia_seq_1'::regclass);


--
-- TOC entry 2463 (class 2604 OID 54999)
-- Dependencies: 2097 2096
-- Name: codigo_seguridad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE seguridad_funcional ALTER COLUMN codigo_seguridad SET DEFAULT nextval('seguridad_funcional_codigo_seguridad_seq'::regclass);


--
-- TOC entry 2415 (class 2604 OID 55000)
-- Dependencies: 2098 1958
-- Name: codigo_sesion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE sesion ALTER COLUMN codigo_sesion SET DEFAULT nextval('sesion_codigo_sesion_seq'::regclass);


--
-- TOC entry 2416 (class 2604 OID 55001)
-- Dependencies: 1959 1958
-- Name: dia_semana; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE sesion ALTER COLUMN dia_semana SET DEFAULT nextval('dato_basico_dia_semana_seq_2_11'::regclass);


--
-- TOC entry 2464 (class 2604 OID 55002)
-- Dependencies: 2100 2099
-- Name: codigo_sesion_ejecutada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE sesion_ejecutada ALTER COLUMN codigo_sesion_ejecutada SET DEFAULT nextval('sesion_ejecutada_codigo_sesion_ejecutada_seq'::regclass);


--
-- TOC entry 2465 (class 2604 OID 55003)
-- Dependencies: 2102 2101
-- Name: codigo_solicitud; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE solicitud_mantenimiento ALTER COLUMN codigo_solicitud SET DEFAULT nextval('solicitud_mantenimiento_codigo_solicitud_seq_1'::regclass);


--
-- TOC entry 2466 (class 2604 OID 55004)
-- Dependencies: 2104 2103
-- Name: codigo_talla_indumentaria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE talla_por_indumentaria ALTER COLUMN codigo_talla_indumentaria SET DEFAULT nextval('talla_por_indumentaria_codigo_talla_indumentaria_seq_1'::regclass);


--
-- TOC entry 2467 (class 2604 OID 55005)
-- Dependencies: 2107 2106
-- Name: codigo_tarea_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tarea_actividad ALTER COLUMN codigo_tarea_actividad SET DEFAULT nextval('tarea_actividad_codigo_tarea_actividad_seq'::regclass);


--
-- TOC entry 2468 (class 2604 OID 55006)
-- Dependencies: 2109 2108
-- Name: codigo_personal_actividad_planificada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tarea_actividad_planificada ALTER COLUMN codigo_personal_actividad_planificada SET DEFAULT nextval('tarea_actividad_planificada_codigo_personal_actividad_planif18'::regclass);


--
-- TOC entry 2469 (class 2604 OID 55007)
-- Dependencies: 2111 2110
-- Name: codigo_test; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE test_evaluativo ALTER COLUMN codigo_test SET DEFAULT nextval('test_evaluativo_codigo_test_seq'::regclass);


--
-- TOC entry 2470 (class 2604 OID 55008)
-- Dependencies: 2114 2113
-- Name: codigo_tipo_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_competencia ALTER COLUMN codigo_tipo_competencia SET DEFAULT nextval('tipo_competencia_codigo_tipo_competencia_seq_1'::regclass);


--
-- TOC entry 2471 (class 2604 OID 55009)
-- Dependencies: 2116 2115
-- Name: codigo_tipo_dato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_dato ALTER COLUMN codigo_tipo_dato SET DEFAULT nextval('tipo_dato_codigo_tipo_dato_seq_1'::regclass);


--
-- TOC entry 2472 (class 2604 OID 55010)
-- Dependencies: 2118 2117
-- Name: codigo_tipo_pago_representante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_pago_representante ALTER COLUMN codigo_tipo_pago_representante SET DEFAULT nextval('tipo_pago_representante_codigo_tipo_pago_representante_seq'::regclass);


--
-- TOC entry 2473 (class 2604 OID 55011)
-- Dependencies: 2121 2120
-- Name: codigo_valor_escala; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE valor_escala ALTER COLUMN codigo_valor_escala SET DEFAULT nextval('valor_escala_codigo_valor_escala_seq'::regclass);


--
-- TOC entry 2477 (class 2606 OID 55013)
-- Dependencies: 1918 1918
-- Name: actividad_calendario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT actividad_calendario_pk PRIMARY KEY (codigo_actividad_calendario);


--
-- TOC entry 2479 (class 2606 OID 55015)
-- Dependencies: 1921 1921
-- Name: actividad_entrenamiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad_entrenamiento
    ADD CONSTRAINT actividad_entrenamiento_pk PRIMARY KEY (cod_actividad_entrenamiento);


--
-- TOC entry 2475 (class 2606 OID 55017)
-- Dependencies: 1917 1917
-- Name: actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT actividad_pk PRIMARY KEY (codigo_actividad);


--
-- TOC entry 2481 (class 2606 OID 55019)
-- Dependencies: 1923 1923 1923
-- Name: actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT actividad_planificada_pk PRIMARY KEY (codigo_indicador_actividad_escala, codigo_sesion);


--
-- TOC entry 2483 (class 2606 OID 55021)
-- Dependencies: 1924 1924
-- Name: actividades_ejecutadas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividades_ejecutadas
    ADD CONSTRAINT actividades_ejecutadas_pk PRIMARY KEY (codigo_actividad_ejecutada);


--
-- TOC entry 2485 (class 2606 OID 55023)
-- Dependencies: 1926 1926 1926
-- Name: afeccion_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT afeccion_jugador_pk PRIMARY KEY (codigo_afeccion, codigo_dato_medico);


--
-- TOC entry 2487 (class 2606 OID 55025)
-- Dependencies: 1927 1927 1927
-- Name: afeccion_personal_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY afeccion_personal
    ADD CONSTRAINT afeccion_personal_pk PRIMARY KEY (cedula_rif, codigo_tipo_afeccion);


--
-- TOC entry 2489 (class 2606 OID 55027)
-- Dependencies: 1928 1928
-- Name: almacen_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY almacen
    ADD CONSTRAINT almacen_pk PRIMARY KEY (codigo_almacen);


--
-- TOC entry 2491 (class 2606 OID 55029)
-- Dependencies: 1930 1930
-- Name: ascenso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ascenso
    ADD CONSTRAINT ascenso_pk PRIMARY KEY (codigo_ascenso);


--
-- TOC entry 2493 (class 2606 OID 55031)
-- Dependencies: 1932 1932
-- Name: asistencia_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY asistencia_jugador
    ADD CONSTRAINT asistencia_jugador_pk PRIMARY KEY (codigo_asistencia);


--
-- TOC entry 2495 (class 2606 OID 55033)
-- Dependencies: 1934 1934 1934
-- Name: asistencia_personal_entrenamiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT asistencia_personal_entrenamiento_pk PRIMARY KEY (codigo_sesion_ejecutada, codigo_personal_equipo);


--
-- TOC entry 2499 (class 2606 OID 55035)
-- Dependencies: 1937 1937 1937
-- Name: categoria_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT categoria_competencia_pk PRIMARY KEY (codigo_competencia, codigo_categoria);


--
-- TOC entry 2497 (class 2606 OID 55037)
-- Dependencies: 1935 1935
-- Name: categoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY (codigo_categoria);


--
-- TOC entry 2623 (class 2606 OID 55039)
-- Dependencies: 2031 2031 2031
-- Name: codigo_liga_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY liga_categoria
    ADD CONSTRAINT codigo_liga_pk PRIMARY KEY (codigo_liga, codigo_categoria);


--
-- TOC entry 2501 (class 2606 OID 55041)
-- Dependencies: 1938 1938 1938
-- Name: comision_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comision_actividad
    ADD CONSTRAINT comision_actividad_pk PRIMARY KEY (codigo_comision, codigo_actividad);


--
-- TOC entry 2503 (class 2606 OID 55043)
-- Dependencies: 1939 1939
-- Name: comision_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT comision_equipo_pk PRIMARY KEY (codigo_comision_equipo);


--
-- TOC entry 2505 (class 2606 OID 55045)
-- Dependencies: 1941 1941
-- Name: competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT competencia_pk PRIMARY KEY (codigo_competencia);


--
-- TOC entry 2507 (class 2606 OID 55047)
-- Dependencies: 1943 1943
-- Name: concepto_nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY concepto_nomina
    ADD CONSTRAINT concepto_nomina_pk PRIMARY KEY (codigo_concepto_nomina);


--
-- TOC entry 2509 (class 2606 OID 55049)
-- Dependencies: 1945 1945 1945
-- Name: condicion_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY condicion_competencia
    ADD CONSTRAINT condicion_competencia_pk PRIMARY KEY (codigo_condicion, codigo_tipo_competencia);


--
-- TOC entry 2513 (class 2606 OID 55051)
-- Dependencies: 1947 1947 1947
-- Name: constante_categoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY constante_categoria
    ADD CONSTRAINT constante_categoria_pk PRIMARY KEY (codigo_constante_categoria, codigo_constante);


--
-- TOC entry 2511 (class 2606 OID 55053)
-- Dependencies: 1946 1946
-- Name: constante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY constante
    ADD CONSTRAINT constante_pk PRIMARY KEY (codigo_constante);


--
-- TOC entry 2517 (class 2606 OID 55055)
-- Dependencies: 1951 1951 1951
-- Name: cuenta_pagar_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT cuenta_pagar_material_pk PRIMARY KEY (codigo_material, origen);


--
-- TOC entry 2515 (class 2606 OID 55057)
-- Dependencies: 1950 1950
-- Name: cuenta_pagar_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT cuenta_pagar_pk PRIMARY KEY (origen);


--
-- TOC entry 2521 (class 2606 OID 55059)
-- Dependencies: 1954 1954
-- Name: dato_academico_personal_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_academico_personal
    ADD CONSTRAINT dato_academico_personal_pk PRIMARY KEY (codigo_dato_academico);


--
-- TOC entry 2519 (class 2606 OID 55061)
-- Dependencies: 1952 1952
-- Name: dato_academico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_academico_pk PRIMARY KEY (codigo_academico);


--
-- TOC entry 2523 (class 2606 OID 55063)
-- Dependencies: 1956 1956
-- Name: dato_basico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT dato_basico_pk PRIMARY KEY (codigo_dato_basico);


--
-- TOC entry 2527 (class 2606 OID 55065)
-- Dependencies: 1960 1960
-- Name: dato_conducta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT dato_conducta_pk PRIMARY KEY (codigo_dato_conducta);


--
-- TOC entry 2529 (class 2606 OID 55067)
-- Dependencies: 1962 1962 1962
-- Name: dato_deportivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT dato_deportivo_pk PRIMARY KEY (codigo_competencia, cedula_rif);


--
-- TOC entry 2531 (class 2606 OID 55069)
-- Dependencies: 1963 1963
-- Name: dato_medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT dato_medico_pk PRIMARY KEY (codigo_dato_medico);


--
-- TOC entry 2533 (class 2606 OID 55071)
-- Dependencies: 1965 1965
-- Name: dato_social_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT dato_social_pk PRIMARY KEY (codigo_dato_social);


--
-- TOC entry 2535 (class 2606 OID 55073)
-- Dependencies: 1967 1967 1967
-- Name: desempenno_colectivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT desempenno_colectivo_pk PRIMARY KEY (codigo_equipo_juego, codigo_indicador_competencia);


--
-- TOC entry 2537 (class 2606 OID 55075)
-- Dependencies: 1968 1968 1968
-- Name: desempenno_individual_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desempenno_individual
    ADD CONSTRAINT desempenno_individual_pk PRIMARY KEY (codigo_indicador_competencia, codigo_line_up);


--
-- TOC entry 2539 (class 2606 OID 55077)
-- Dependencies: 1969 1969 1969
-- Name: desempeo_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT desempeo_jugador_pk PRIMARY KEY (codigo_asistencia, codigo_actividad_ejecutada);


--
-- TOC entry 2541 (class 2606 OID 55079)
-- Dependencies: 1970 1970 1970
-- Name: detalle_requisicion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_requisicion
    ADD CONSTRAINT detalle_requisicion_pk PRIMARY KEY (codigo_material, codigo_requisicion);


--
-- TOC entry 2543 (class 2606 OID 55081)
-- Dependencies: 1971 1971
-- Name: divisa_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY divisa
    ADD CONSTRAINT divisa_pk PRIMARY KEY (codigo_divisa);


--
-- TOC entry 2545 (class 2606 OID 55083)
-- Dependencies: 1973 1973 1973
-- Name: documento_academico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT documento_academico_pk PRIMARY KEY (codigo_documento_entregado, codigo_academico);


--
-- TOC entry 2549 (class 2606 OID 55085)
-- Dependencies: 1976 1976 1976
-- Name: documento_acreedor_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_acreedor_material
    ADD CONSTRAINT documento_acreedor_material_pk PRIMARY KEY (codigo_material, codigo_documento_acreedor);


--
-- TOC entry 2547 (class 2606 OID 55087)
-- Dependencies: 1974 1974
-- Name: documento_acreedor_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT documento_acreedor_pk PRIMARY KEY (codigo_documento_acreedor);


--
-- TOC entry 2551 (class 2606 OID 55089)
-- Dependencies: 1977 1977 1977
-- Name: documento_ascenso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT documento_ascenso_pk PRIMARY KEY (codigo_documento_entregado, codigo_ascenso);


--
-- TOC entry 2553 (class 2606 OID 55091)
-- Dependencies: 1978 1978 1978
-- Name: documento_conducta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT documento_conducta_pk PRIMARY KEY (codigo_documento_entregado, codigo_dato_conducta);


--
-- TOC entry 2555 (class 2606 OID 55093)
-- Dependencies: 1979 1979
-- Name: documento_entregado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_entregado
    ADD CONSTRAINT documento_entregado_pk PRIMARY KEY (codigo_documento_entregado);


--
-- TOC entry 2557 (class 2606 OID 55095)
-- Dependencies: 1980 1980 1980
-- Name: documento_indumentaria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_indumentaria
    ADD CONSTRAINT documento_indumentaria_pk PRIMARY KEY (codigo_documento_acreedor, codigo_talla_indumentaria);


--
-- TOC entry 2559 (class 2606 OID 55097)
-- Dependencies: 1981 1981 1981
-- Name: documento_medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT documento_medico_pk PRIMARY KEY (codigo_documento_entregado, codigo_dato_medico);


--
-- TOC entry 2561 (class 2606 OID 55099)
-- Dependencies: 1982 1982 1982
-- Name: documento_personal_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_personal
    ADD CONSTRAINT documento_personal_pk PRIMARY KEY (codigo_documento_entregado, cedula_rif);


--
-- TOC entry 2563 (class 2606 OID 55101)
-- Dependencies: 1984 1984 1984
-- Name: donacion_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY donacion_material
    ADD CONSTRAINT donacion_material_pk PRIMARY KEY (codigo_material, codigo_documento_acreedor);


--
-- TOC entry 2567 (class 2606 OID 55103)
-- Dependencies: 1986 1986 1986
-- Name: egreso_cuenta_pagar_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY egreso_cuenta_pagar
    ADD CONSTRAINT egreso_cuenta_pagar_pk PRIMARY KEY (origen, numero_documento);


--
-- TOC entry 2569 (class 2606 OID 55105)
-- Dependencies: 1987 1987
-- Name: egreso_forma_pago_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT egreso_forma_pago_pk PRIMARY KEY (numero_documento);


--
-- TOC entry 2565 (class 2606 OID 55107)
-- Dependencies: 1985 1985
-- Name: egreso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY egreso
    ADD CONSTRAINT egreso_pk PRIMARY KEY (numero_documento);


--
-- TOC entry 2573 (class 2606 OID 55109)
-- Dependencies: 1990 1990
-- Name: equipo_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT equipo_competencia_pk PRIMARY KEY (codigo_equipo_competencia);


--
-- TOC entry 2575 (class 2606 OID 55111)
-- Dependencies: 1992 1992
-- Name: equipo_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT equipo_juego_pk PRIMARY KEY (codigo_equipo_juego);


--
-- TOC entry 2571 (class 2606 OID 55113)
-- Dependencies: 1988 1988
-- Name: equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT equipo_pk PRIMARY KEY (codigo_equipo);


--
-- TOC entry 2577 (class 2606 OID 55115)
-- Dependencies: 1994 1994
-- Name: escala_medicion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY escala_medicion
    ADD CONSTRAINT escala_medicion_pk PRIMARY KEY (codigo_escala);


--
-- TOC entry 2579 (class 2606 OID 55117)
-- Dependencies: 1996 1996
-- Name: estadio_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estadio
    ADD CONSTRAINT estadio_pk PRIMARY KEY (codigo_estadio);


--
-- TOC entry 2581 (class 2606 OID 55119)
-- Dependencies: 1998 1998 1998
-- Name: estado_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estado_actividad
    ADD CONSTRAINT estado_actividad_pk PRIMARY KEY (codigo_estado, codigo_actividad);


--
-- TOC entry 2585 (class 2606 OID 55121)
-- Dependencies: 2000 2000 2000
-- Name: familiar_comision_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT familiar_comision_equipo_pk PRIMARY KEY (codigo_comision_equipo, codigo_familiar_jugador);


--
-- TOC entry 2587 (class 2606 OID 55123)
-- Dependencies: 2001 2001
-- Name: familiar_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT familiar_jugador_pk PRIMARY KEY (codigo_familiar_jugador);


--
-- TOC entry 2583 (class 2606 OID 55125)
-- Dependencies: 1999 1999
-- Name: familiar_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT familiar_pk PRIMARY KEY (cedula_familiar);


--
-- TOC entry 2589 (class 2606 OID 55127)
-- Dependencies: 2003 2003 2003
-- Name: fase_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fase_competencia
    ADD CONSTRAINT fase_competencia_pk PRIMARY KEY (codigo_competencia, numero_fase);


--
-- TOC entry 2591 (class 2606 OID 55129)
-- Dependencies: 2004 2004
-- Name: horario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_pk PRIMARY KEY (codigo_horario);


--
-- TOC entry 2593 (class 2606 OID 55131)
-- Dependencies: 2006 2006
-- Name: hospedaje_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT hospedaje_pk PRIMARY KEY (codigo_hospedaje);


--
-- TOC entry 2697 (class 2606 OID 55133)
-- Dependencies: 2088 2088
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY requisicion
    ADD CONSTRAINT id PRIMARY KEY (codigo_requisicion);


--
-- TOC entry 2597 (class 2606 OID 55135)
-- Dependencies: 2009 2009
-- Name: indicador_actividad_escala_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT indicador_actividad_escala_pk PRIMARY KEY (codigo_indicador_actividad_escala);


--
-- TOC entry 2599 (class 2606 OID 55137)
-- Dependencies: 2011 2011
-- Name: indicador_categoria_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT indicador_categoria_competencia_pk PRIMARY KEY (codigo_indicador_competencia);


--
-- TOC entry 2595 (class 2606 OID 55139)
-- Dependencies: 2008 2008
-- Name: indicador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador
    ADD CONSTRAINT indicador_pk PRIMARY KEY (codigo_indicador);


--
-- TOC entry 2601 (class 2606 OID 55141)
-- Dependencies: 2014 2014
-- Name: indicador_test_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT indicador_test_pk PRIMARY KEY (codigo_indicador_test);


--
-- TOC entry 2605 (class 2606 OID 55143)
-- Dependencies: 2017 2017 2017
-- Name: ingreso_documento_acreedor_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso_documento_acreedor
    ADD CONSTRAINT ingreso_documento_acreedor_pk PRIMARY KEY (numero_documento, codigo_documento_acreedor);


--
-- TOC entry 2607 (class 2606 OID 55145)
-- Dependencies: 2018 2018 2018
-- Name: ingreso_forma_pago_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT ingreso_forma_pago_pk PRIMARY KEY (numero_documento, codigo_forma_pago);


--
-- TOC entry 2603 (class 2606 OID 55147)
-- Dependencies: 2016 2016
-- Name: ingreso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso
    ADD CONSTRAINT ingreso_pk PRIMARY KEY (numero_documento);


--
-- TOC entry 2609 (class 2606 OID 55149)
-- Dependencies: 2019 2019
-- Name: instalacion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY instalacion
    ADD CONSTRAINT instalacion_pk PRIMARY KEY (codigo_instalacion);


--
-- TOC entry 2611 (class 2606 OID 55151)
-- Dependencies: 2021 2021
-- Name: institucion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT institucion_pk PRIMARY KEY (codigo_institucion);


--
-- TOC entry 2613 (class 2606 OID 55153)
-- Dependencies: 2023 2023
-- Name: juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT juego_pk PRIMARY KEY (codigo_juego);


--
-- TOC entry 2617 (class 2606 OID 55155)
-- Dependencies: 2026 2026
-- Name: jugador_foraneo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT jugador_foraneo_pk PRIMARY KEY (cedula);


--
-- TOC entry 2615 (class 2606 OID 55157)
-- Dependencies: 2025 2025
-- Name: jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT jugador_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2619 (class 2606 OID 55159)
-- Dependencies: 2028 2028
-- Name: lapso_deportivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY lapso_deportivo
    ADD CONSTRAINT lapso_deportivo_pk PRIMARY KEY (codigo_lapso_deportivo);


--
-- TOC entry 2625 (class 2606 OID 55161)
-- Dependencies: 2033 2033 2033
-- Name: liga_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY liga_competencia
    ADD CONSTRAINT liga_competencia_pk PRIMARY KEY (codigo_liga, codigo_competencia);


--
-- TOC entry 2621 (class 2606 OID 55163)
-- Dependencies: 2030 2030
-- Name: liga_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY liga
    ADD CONSTRAINT liga_pk PRIMARY KEY (codigo_liga);


--
-- TOC entry 2627 (class 2606 OID 55165)
-- Dependencies: 2034 2034
-- Name: line_up_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT line_up_pk PRIMARY KEY (codigo_line_up);


--
-- TOC entry 2629 (class 2606 OID 55167)
-- Dependencies: 2036 2036 2036 2036
-- Name: logro_por_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT logro_por_jugador_pk PRIMARY KEY (codigo_competencia, cedula_rif, codigo_logro);


--
-- TOC entry 2633 (class 2606 OID 55169)
-- Dependencies: 2038 2038
-- Name: material_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY material_actividad
    ADD CONSTRAINT material_actividad_pk PRIMARY KEY (codigo_material_actividad);


--
-- TOC entry 2635 (class 2606 OID 55171)
-- Dependencies: 2040 2040 2040
-- Name: material_actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY material_actividad_planificada
    ADD CONSTRAINT material_actividad_planificada_pk PRIMARY KEY (codigo_planificacion_actividad, codigo_material);


--
-- TOC entry 2631 (class 2606 OID 55173)
-- Dependencies: 2037 2037
-- Name: material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY material
    ADD CONSTRAINT material_pk PRIMARY KEY (codigo_material);


--
-- TOC entry 2637 (class 2606 OID 55175)
-- Dependencies: 2042 2042
-- Name: medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT medico_pk PRIMARY KEY (numero_colegio);


--
-- TOC entry 2639 (class 2606 OID 55177)
-- Dependencies: 2043 2043
-- Name: modalidad_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY modalidad_competencia
    ADD CONSTRAINT modalidad_competencia_pk PRIMARY KEY (codigo_modalidad_competencia);


--
-- TOC entry 2641 (class 2606 OID 55179)
-- Dependencies: 2045 2045 2045
-- Name: motivo_sancion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT motivo_sancion_pk PRIMARY KEY (codigo_motivo, codigo_dato_conducta);


--
-- TOC entry 2643 (class 2606 OID 55181)
-- Dependencies: 2046 2046
-- Name: movimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT movimiento_pk PRIMARY KEY (codigo_movimiento);


--
-- TOC entry 2645 (class 2606 OID 55183)
-- Dependencies: 2048 2048
-- Name: nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY nomina
    ADD CONSTRAINT nomina_pk PRIMARY KEY (codigo_nomina);


--
-- TOC entry 2647 (class 2606 OID 55185)
-- Dependencies: 2050 2050
-- Name: nota_entrega_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY nota_entrega
    ADD CONSTRAINT nota_entrega_pk PRIMARY KEY (codigo_nota_entrega);


--
-- TOC entry 2649 (class 2606 OID 55187)
-- Dependencies: 2052 2052
-- Name: periodicidad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY periodicidad
    ADD CONSTRAINT periodicidad_pk PRIMARY KEY (codigo_periodicidad);


--
-- TOC entry 2653 (class 2606 OID 55189)
-- Dependencies: 2055 2055
-- Name: persona_juridica_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona_juridica
    ADD CONSTRAINT persona_juridica_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2655 (class 2606 OID 55191)
-- Dependencies: 2056 2056
-- Name: persona_natural_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT persona_natural_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2651 (class 2606 OID 55193)
-- Dependencies: 2054 2054
-- Name: persona_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2659 (class 2606 OID 55195)
-- Dependencies: 2058 2058 2058
-- Name: personal_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_actividad
    ADD CONSTRAINT personal_actividad_pk PRIMARY KEY (cedula_rif, codigo_actividad);


--
-- TOC entry 2661 (class 2606 OID 55197)
-- Dependencies: 2059 2059 2059
-- Name: personal_actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_actividad_planificada
    ADD CONSTRAINT personal_actividad_planificada_pk PRIMARY KEY (cedula_rif, codigo_planificacion_actividad);


--
-- TOC entry 2663 (class 2606 OID 55199)
-- Dependencies: 2060 2060
-- Name: personal_cargo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_cargo
    ADD CONSTRAINT personal_cargo_pk PRIMARY KEY (codigo_personal_cargo);


--
-- TOC entry 2665 (class 2606 OID 55201)
-- Dependencies: 2062 2062
-- Name: personal_concepto_nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_concepto_nomina
    ADD CONSTRAINT personal_concepto_nomina_pk PRIMARY KEY (codigo_personal_concepto_nomina);


--
-- TOC entry 2667 (class 2606 OID 55203)
-- Dependencies: 2064 2064
-- Name: personal_contrato_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT personal_contrato_pk PRIMARY KEY (codigo_personal_contrato);


--
-- TOC entry 2671 (class 2606 OID 55205)
-- Dependencies: 2068 2068 2068
-- Name: personal_equipo_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_equipo_juego
    ADD CONSTRAINT personal_equipo_juego_pk PRIMARY KEY (codigo_equipo_juego, codigo_personal_equipo);


--
-- TOC entry 2669 (class 2606 OID 55207)
-- Dependencies: 2066 2066
-- Name: personal_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT personal_equipo_pk PRIMARY KEY (codigo_personal_equipo);


--
-- TOC entry 2675 (class 2606 OID 55209)
-- Dependencies: 2071 2071 2071
-- Name: personal_foraneo_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT personal_foraneo_juego_pk PRIMARY KEY (codigo_juego, codigo_personal_foraneo);


--
-- TOC entry 2673 (class 2606 OID 55211)
-- Dependencies: 2069 2069
-- Name: personal_foraneo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_foraneo
    ADD CONSTRAINT personal_foraneo_pk PRIMARY KEY (codigo_personal_foraneo);


--
-- TOC entry 2677 (class 2606 OID 55213)
-- Dependencies: 2072 2072 2072
-- Name: personal_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT personal_juego_pk PRIMARY KEY (codigo_juego, cedula_rif);


--
-- TOC entry 2657 (class 2606 OID 55215)
-- Dependencies: 2057 2057
-- Name: personal_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT personal_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2679 (class 2606 OID 55217)
-- Dependencies: 2073 2073
-- Name: personal_tipo_nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_tipo_nomina
    ADD CONSTRAINT personal_tipo_nomina_pk PRIMARY KEY (codigo_personal_tipo_nomina);


--
-- TOC entry 2681 (class 2606 OID 55219)
-- Dependencies: 2075 2075
-- Name: plan_entrenamiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_entrenamiento
    ADD CONSTRAINT plan_entrenamiento_pk PRIMARY KEY (codigo_plan_entrenamiento);


--
-- TOC entry 2683 (class 2606 OID 55221)
-- Dependencies: 2077 2077
-- Name: plan_rotacion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT plan_rotacion_pk PRIMARY KEY (codigo_plan_rotacion);


--
-- TOC entry 2685 (class 2606 OID 55223)
-- Dependencies: 2079 2079
-- Name: plan_temporada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_temporada
    ADD CONSTRAINT plan_temporada_pk PRIMARY KEY (codigo_plan_temporada);


--
-- TOC entry 2687 (class 2606 OID 55225)
-- Dependencies: 2081 2081
-- Name: planificacion_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY planificacion_actividad
    ADD CONSTRAINT planificacion_actividad_pk PRIMARY KEY (codigo_planificacion_actividad);


--
-- TOC entry 2689 (class 2606 OID 55227)
-- Dependencies: 2083 2083
-- Name: proveedor_banco_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedor_banco
    ADD CONSTRAINT proveedor_banco_pk PRIMARY KEY (codigo_cuenta_banco);


--
-- TOC entry 2691 (class 2606 OID 55229)
-- Dependencies: 2084 2084
-- Name: recaudo_por_proceso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT recaudo_por_proceso_pk PRIMARY KEY (codigo_recaudo_por_proceso);


--
-- TOC entry 2693 (class 2606 OID 55231)
-- Dependencies: 2086 2086 2086
-- Name: recepcion_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recepcion_material
    ADD CONSTRAINT recepcion_material_pk PRIMARY KEY (codigo_nota_entrega, codigo_material);


--
-- TOC entry 2695 (class 2606 OID 55233)
-- Dependencies: 2087 2087
-- Name: representante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY representante
    ADD CONSTRAINT representante_pk PRIMARY KEY (codigo_familiar_jugador);


--
-- TOC entry 2699 (class 2606 OID 55235)
-- Dependencies: 2090 2090 2090
-- Name: resultado_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY resultado_actividad
    ADD CONSTRAINT resultado_actividad_pk PRIMARY KEY (codigo_resultado, codigo_actividad);


--
-- TOC entry 2701 (class 2606 OID 55237)
-- Dependencies: 2091 2091
-- Name: retiro_traslado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY retiro_traslado
    ADD CONSTRAINT retiro_traslado_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2705 (class 2606 OID 55239)
-- Dependencies: 2094 2094
-- Name: roster_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT roster_competencia_pk PRIMARY KEY (codigo_roster_competencia);


--
-- TOC entry 2703 (class 2606 OID 55241)
-- Dependencies: 2092 2092
-- Name: roster_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT roster_pk PRIMARY KEY (codigo_roster);


--
-- TOC entry 2707 (class 2606 OID 55243)
-- Dependencies: 2096 2096
-- Name: seguridad_funcional_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT seguridad_funcional_pk PRIMARY KEY (codigo_seguridad);


--
-- TOC entry 2709 (class 2606 OID 55245)
-- Dependencies: 2099 2099
-- Name: sesion_ejecutada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT sesion_ejecutada_pk PRIMARY KEY (codigo_sesion_ejecutada);


--
-- TOC entry 2525 (class 2606 OID 55247)
-- Dependencies: 1958 1958
-- Name: sesion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT sesion_pk PRIMARY KEY (codigo_sesion);


--
-- TOC entry 2711 (class 2606 OID 55249)
-- Dependencies: 2101 2101 2101
-- Name: solicitud_mantenimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY solicitud_mantenimiento
    ADD CONSTRAINT solicitud_mantenimiento_pk PRIMARY KEY (codigo_solicitud, codigo_actividad);


--
-- TOC entry 2713 (class 2606 OID 55251)
-- Dependencies: 2103 2103
-- Name: talla_por_indumentaria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT talla_por_indumentaria_pk PRIMARY KEY (codigo_talla_indumentaria);


--
-- TOC entry 2715 (class 2606 OID 55253)
-- Dependencies: 2105 2105 2105
-- Name: talla_por_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT talla_por_jugador_pk PRIMARY KEY (cedula_rif, codigo_talla_indumentaria);


--
-- TOC entry 2717 (class 2606 OID 55255)
-- Dependencies: 2106 2106
-- Name: tarea_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT tarea_actividad_pk PRIMARY KEY (codigo_tarea_actividad);


--
-- TOC entry 2719 (class 2606 OID 55257)
-- Dependencies: 2108 2108
-- Name: tarea_actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT tarea_actividad_planificada_pk PRIMARY KEY (codigo_personal_actividad_planificada);


--
-- TOC entry 2721 (class 2606 OID 55259)
-- Dependencies: 2110 2110
-- Name: test_evaluativo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY test_evaluativo
    ADD CONSTRAINT test_evaluativo_pk PRIMARY KEY (codigo_test);


--
-- TOC entry 2723 (class 2606 OID 55261)
-- Dependencies: 2112 2112 2112
-- Name: test_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY test_jugador
    ADD CONSTRAINT test_jugador_pk PRIMARY KEY (codigo_indicador_test, codigo_roster);


--
-- TOC entry 2725 (class 2606 OID 55263)
-- Dependencies: 2113 2113
-- Name: tipo_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_competencia
    ADD CONSTRAINT tipo_competencia_pk PRIMARY KEY (codigo_tipo_competencia);


--
-- TOC entry 2727 (class 2606 OID 55265)
-- Dependencies: 2115 2115
-- Name: tipo_dato_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_dato
    ADD CONSTRAINT tipo_dato_pk PRIMARY KEY (codigo_tipo_dato);


--
-- TOC entry 2729 (class 2606 OID 55267)
-- Dependencies: 2117 2117
-- Name: tipo_pago_representante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_pago_representante
    ADD CONSTRAINT tipo_pago_representante_pk PRIMARY KEY (codigo_tipo_pago_representante);


--
-- TOC entry 2731 (class 2606 OID 55269)
-- Dependencies: 2119 2119
-- Name: usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2733 (class 2606 OID 55271)
-- Dependencies: 2120 2120
-- Name: valor_escala_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY valor_escala
    ADD CONSTRAINT valor_escala_pk PRIMARY KEY (codigo_valor_escala);


--
-- TOC entry 2735 (class 2606 OID 55272)
-- Dependencies: 1918 1917 2474
-- Name: actividad_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT actividad_actividad_calendario_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2760 (class 2606 OID 55277)
-- Dependencies: 1938 1917 2474
-- Name: actividad_comision_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_actividad
    ADD CONSTRAINT actividad_comision_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2860 (class 2606 OID 55282)
-- Dependencies: 2009 1921 2478
-- Name: actividad_entrenamiento_indicador_actividad_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT actividad_entrenamiento_indicador_actividad_escala_fk FOREIGN KEY (cod_actividad_entrenamiento) REFERENCES actividad_entrenamiento(cod_actividad_entrenamiento);


--
-- TOC entry 2844 (class 2606 OID 55287)
-- Dependencies: 1998 1917 2474
-- Name: actividad_estado_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado_actividad
    ADD CONSTRAINT actividad_estado_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2903 (class 2606 OID 55292)
-- Dependencies: 2038 1917 2474
-- Name: actividad_material_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad
    ADD CONSTRAINT actividad_material_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2925 (class 2606 OID 55297)
-- Dependencies: 2058 1917 2474
-- Name: actividad_personal_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad
    ADD CONSTRAINT actividad_personal_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2968 (class 2606 OID 55302)
-- Dependencies: 2090 1917 2474
-- Name: actividad_resultado_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY resultado_actividad
    ADD CONSTRAINT actividad_resultado_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2986 (class 2606 OID 55307)
-- Dependencies: 2101 1917 2474
-- Name: actividad_solicitud_mantenimiento_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitud_mantenimiento
    ADD CONSTRAINT actividad_solicitud_mantenimiento_fk1 FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2991 (class 2606 OID 55312)
-- Dependencies: 2106 1917 2474
-- Name: actividad_tarea_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT actividad_tarea_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2803 (class 2606 OID 55317)
-- Dependencies: 1969 1924 2482
-- Name: actividades_ejecutadas_desempeo_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT actividades_ejecutadas_desempeo_jugador_fk FOREIGN KEY (codigo_actividad_ejecutada) REFERENCES actividades_ejecutadas(codigo_actividad_ejecutada);


--
-- TOC entry 2900 (class 2606 OID 55322)
-- Dependencies: 2037 1928 2488
-- Name: almacen_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material
    ADD CONSTRAINT almacen_material_fk FOREIGN KEY (codigo_almacen) REFERENCES almacen(codigo_almacen);


--
-- TOC entry 2816 (class 2606 OID 55327)
-- Dependencies: 1977 1930 2490
-- Name: ascenso_documento_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT ascenso_documento_ascenso_fk FOREIGN KEY (codigo_ascenso) REFERENCES ascenso(codigo_ascenso);


--
-- TOC entry 2804 (class 2606 OID 55332)
-- Dependencies: 2492 1969 1932
-- Name: asistencia_jugador_desempeo_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT asistencia_jugador_desempeo_jugador_fk FOREIGN KEY (codigo_asistencia) REFERENCES asistencia_jugador(codigo_asistencia);


--
-- TOC entry 2739 (class 2606 OID 55337)
-- Dependencies: 2496 1921 1935
-- Name: categoria_actividad_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_entrenamiento
    ADD CONSTRAINT categoria_actividad_entrenamiento_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2758 (class 2606 OID 55342)
-- Dependencies: 2496 1935 1937
-- Name: categoria_categoria_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT categoria_categoria_competencia_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2772 (class 2606 OID 55347)
-- Dependencies: 1935 1947 2496
-- Name: categoria_constante_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY constante_categoria
    ADD CONSTRAINT categoria_constante_categoria_fk FOREIGN KEY (codigo_categoria_1) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2834 (class 2606 OID 55352)
-- Dependencies: 2496 1988 1935
-- Name: categoria_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT categoria_equipo_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2863 (class 2606 OID 55357)
-- Dependencies: 1935 2011 2496
-- Name: categoria_indicador_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT categoria_indicador_competencia_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2890 (class 2606 OID 55362)
-- Dependencies: 2496 2031 1935
-- Name: categoria_liga_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_categoria
    ADD CONSTRAINT categoria_liga_categoria_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2955 (class 2606 OID 55367)
-- Dependencies: 1935 2079 2496
-- Name: categoria_temporada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_temporada
    ADD CONSTRAINT categoria_temporada_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2848 (class 2606 OID 55372)
-- Dependencies: 2502 2000 1939
-- Name: comision_equipo_familiar_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT comision_equipo_familiar_comision_equipo_fk FOREIGN KEY (codigo_comision_equipo) REFERENCES comision_equipo(codigo_comision_equipo);


--
-- TOC entry 2736 (class 2606 OID 55377)
-- Dependencies: 2504 1918 1941
-- Name: competencia_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT competencia_actividad_calendario_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2759 (class 2606 OID 55382)
-- Dependencies: 1937 2504 1941
-- Name: competencia_categoria_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT competencia_categoria_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2792 (class 2606 OID 55387)
-- Dependencies: 1962 2504 1941
-- Name: competencia_dato_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT competencia_dato_deportivo_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2837 (class 2606 OID 55392)
-- Dependencies: 2504 1990 1941
-- Name: competencia_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT competencia_equipo_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2853 (class 2606 OID 55397)
-- Dependencies: 2003 2504 1941
-- Name: competencia_fase_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fase_competencia
    ADD CONSTRAINT competencia_fase_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2856 (class 2606 OID 55402)
-- Dependencies: 2006 1941 2504
-- Name: competencia_hospedaje_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT competencia_hospedaje_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2864 (class 2606 OID 55407)
-- Dependencies: 2011 1941 2504
-- Name: competencia_indicador_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT competencia_indicador_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2879 (class 2606 OID 55412)
-- Dependencies: 1941 2023 2504
-- Name: competencia_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT competencia_juego_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2892 (class 2606 OID 55417)
-- Dependencies: 1941 2504 2033
-- Name: competencia_liga_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_competencia
    ADD CONSTRAINT competencia_liga_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2974 (class 2606 OID 55422)
-- Dependencies: 1941 2504 2094
-- Name: competencia_roster_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT competencia_roster_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2911 (class 2606 OID 55427)
-- Dependencies: 2506 1943 2046
-- Name: concepto_nomina_movimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT concepto_nomina_movimiento_fk FOREIGN KEY (codigo_concepto_nomina) REFERENCES concepto_nomina(codigo_concepto_nomina);


--
-- TOC entry 2931 (class 2606 OID 55432)
-- Dependencies: 2506 2062 1943
-- Name: concepto_nomina_personal_concepto_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_concepto_nomina
    ADD CONSTRAINT concepto_nomina_personal_concepto_nomina_fk FOREIGN KEY (codigo_concepto_nomina) REFERENCES concepto_nomina(codigo_concepto_nomina);


--
-- TOC entry 2773 (class 2606 OID 55437)
-- Dependencies: 1947 2510 1946
-- Name: constante_constante_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY constante_categoria
    ADD CONSTRAINT constante_constante_categoria_fk FOREIGN KEY (codigo_constante) REFERENCES constante(codigo_constante);


--
-- TOC entry 2777 (class 2606 OID 55442)
-- Dependencies: 1951 1950 2514
-- Name: cuenta_pagar_cuenta_pagar_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT cuenta_pagar_cuenta_pagar_material_fk FOREIGN KEY (origen) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2829 (class 2606 OID 55447)
-- Dependencies: 2514 1986 1950
-- Name: cuenta_pagar_egreso_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_cuenta_pagar
    ADD CONSTRAINT cuenta_pagar_egreso_cuenta_pagar_fk FOREIGN KEY (origen) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2914 (class 2606 OID 55452)
-- Dependencies: 1950 2514 2048
-- Name: cuenta_pagar_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nomina
    ADD CONSTRAINT cuenta_pagar_nomina_fk FOREIGN KEY (codigo_nomina) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2916 (class 2606 OID 55457)
-- Dependencies: 2514 1950 2050
-- Name: cuenta_pagar_nota_entrega_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nota_entrega
    ADD CONSTRAINT cuenta_pagar_nota_entrega_fk FOREIGN KEY (origen) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2809 (class 2606 OID 55462)
-- Dependencies: 1952 2518 1973
-- Name: dato_academico_documento_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT dato_academico_documento_academico_fk FOREIGN KEY (codigo_academico) REFERENCES dato_academico(codigo_academico);


--
-- TOC entry 2737 (class 2606 OID 55467)
-- Dependencies: 1918 2522 1956
-- Name: dato_basico_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT dato_basico_actividad_calendario_fk FOREIGN KEY (codigo_tipo_actividad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2740 (class 2606 OID 55472)
-- Dependencies: 1921 2522 1956
-- Name: dato_basico_actividad_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_entrenamiento
    ADD CONSTRAINT dato_basico_actividad_entrenamiento_fk FOREIGN KEY (fase) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2746 (class 2606 OID 55477)
-- Dependencies: 1956 1926 2522
-- Name: dato_basico_afeccion_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT dato_basico_afeccion_jugador_fk FOREIGN KEY (codigo_afeccion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2748 (class 2606 OID 55482)
-- Dependencies: 1956 2522 1927
-- Name: dato_basico_afeccion_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_personal
    ADD CONSTRAINT dato_basico_afeccion_personal_fk FOREIGN KEY (codigo_tipo_afeccion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2752 (class 2606 OID 55487)
-- Dependencies: 1956 2522 1932
-- Name: dato_basico_asistencia_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_jugador
    ADD CONSTRAINT dato_basico_asistencia_jugador_fk FOREIGN KEY (eventualidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2761 (class 2606 OID 55492)
-- Dependencies: 2522 1938 1956
-- Name: dato_basico_comision_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_actividad
    ADD CONSTRAINT dato_basico_comision_actividad_fk FOREIGN KEY (codigo_comision) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2762 (class 2606 OID 55497)
-- Dependencies: 1939 2522 1956
-- Name: dato_basico_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT dato_basico_comision_equipo_fk FOREIGN KEY (codigo_comision) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2764 (class 2606 OID 55502)
-- Dependencies: 1941 2522 1956
-- Name: dato_basico_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk FOREIGN KEY (codigo_estado_competencia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2765 (class 2606 OID 55507)
-- Dependencies: 1956 2522 1941
-- Name: dato_basico_competencia_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk1 FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2766 (class 2606 OID 55512)
-- Dependencies: 1941 2522 1956
-- Name: dato_basico_competencia_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk2 FOREIGN KEY (codigo_organizacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2769 (class 2606 OID 55517)
-- Dependencies: 2522 1956 1943
-- Name: dato_basico_concepto_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY concepto_nomina
    ADD CONSTRAINT dato_basico_concepto_nomina_fk FOREIGN KEY (codigo_tipo_concepto) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2770 (class 2606 OID 55522)
-- Dependencies: 2522 1956 1945
-- Name: dato_basico_condicion_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY condicion_competencia
    ADD CONSTRAINT dato_basico_condicion_competencia_fk FOREIGN KEY (codigo_condicion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2774 (class 2606 OID 55527)
-- Dependencies: 1956 2522 1950
-- Name: dato_basico_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT dato_basico_cuenta_pagar_fk FOREIGN KEY (codigo_tipo_egreso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2775 (class 2606 OID 55532)
-- Dependencies: 1950 1956 2522
-- Name: dato_basico_cuenta_pagar_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT dato_basico_cuenta_pagar_fk2 FOREIGN KEY (codigo_tipo_documento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2780 (class 2606 OID 55537)
-- Dependencies: 1956 1952 2522
-- Name: dato_basico_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_basico_dato_academico_fk FOREIGN KEY (codigo_anno_escolar) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2781 (class 2606 OID 55542)
-- Dependencies: 1956 1952 2522
-- Name: dato_basico_dato_academico_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_basico_dato_academico_fk1 FOREIGN KEY (codigo_curso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2785 (class 2606 OID 55547)
-- Dependencies: 1956 1956 2522
-- Name: dato_basico_dato_basico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT dato_basico_dato_basico_fk FOREIGN KEY (parent_codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2790 (class 2606 OID 55552)
-- Dependencies: 2522 1960 1956
-- Name: dato_basico_dato_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT dato_basico_dato_conducta_fk FOREIGN KEY (codigo_tipo_suspension) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2796 (class 2606 OID 55557)
-- Dependencies: 2522 1965 1956
-- Name: dato_basico_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT dato_basico_dato_social_fk FOREIGN KEY (codigo_actividad_social) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2808 (class 2606 OID 55562)
-- Dependencies: 2522 1971 1956
-- Name: dato_basico_divisa_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY divisa
    ADD CONSTRAINT dato_basico_divisa_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2811 (class 2606 OID 55567)
-- Dependencies: 1956 1974 2522
-- Name: dato_basico_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT dato_basico_documento_acreedor_fk FOREIGN KEY (codigo_tipo_ingreso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2961 (class 2606 OID 55572)
-- Dependencies: 2522 2084 1956
-- Name: dato_basico_documento_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_documento_fk1 FOREIGN KEY (codigo_documento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2962 (class 2606 OID 55577)
-- Dependencies: 2522 2084 1956
-- Name: dato_basico_documento_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_documento_fk2 FOREIGN KEY (codigo_proceso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2831 (class 2606 OID 55582)
-- Dependencies: 1987 1956 2522
-- Name: dato_basico_egreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT dato_basico_egreso_forma_pago_fk FOREIGN KEY (codigo_tarjeta) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2832 (class 2606 OID 55587)
-- Dependencies: 2522 1987 1956
-- Name: dato_basico_egreso_forma_pago_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT dato_basico_egreso_forma_pago_fk1 FOREIGN KEY (codigo_banco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2835 (class 2606 OID 55592)
-- Dependencies: 1956 1988 2522
-- Name: dato_basico_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT dato_basico_equipo_fk FOREIGN KEY (codigo_clasificacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2842 (class 2606 OID 55597)
-- Dependencies: 1956 1994 2522
-- Name: dato_basico_escala_medicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY escala_medicion
    ADD CONSTRAINT dato_basico_escala_medicion_fk FOREIGN KEY (tipo_escala) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2843 (class 2606 OID 55602)
-- Dependencies: 1956 1996 2522
-- Name: dato_basico_estadio_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estadio
    ADD CONSTRAINT dato_basico_estadio_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2845 (class 2606 OID 55607)
-- Dependencies: 1956 1998 2522
-- Name: dato_basico_estado_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado_actividad
    ADD CONSTRAINT dato_basico_estado_mantenimiento_fk FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2846 (class 2606 OID 55612)
-- Dependencies: 1956 1999 2522
-- Name: dato_basico_familiar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT dato_basico_familiar_fk FOREIGN KEY (codigo_profesion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2850 (class 2606 OID 55617)
-- Dependencies: 2522 2001 1956
-- Name: dato_basico_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT dato_basico_familiar_jugador_fk FOREIGN KEY (codigo_parentesco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2854 (class 2606 OID 55622)
-- Dependencies: 2004 1956 2522
-- Name: dato_basico_horario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT dato_basico_horario_fk FOREIGN KEY (codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2861 (class 2606 OID 55627)
-- Dependencies: 2522 2009 1956
-- Name: dato_basico_indicador_actividad_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT dato_basico_indicador_actividad_escala_fk FOREIGN KEY (indicador) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2858 (class 2606 OID 55632)
-- Dependencies: 1956 2008 2522
-- Name: dato_basico_indicador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador
    ADD CONSTRAINT dato_basico_indicador_fk FOREIGN KEY (codigo_tipo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2859 (class 2606 OID 55637)
-- Dependencies: 1956 2008 2522
-- Name: dato_basico_indicador_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador
    ADD CONSTRAINT dato_basico_indicador_fk1 FOREIGN KEY (codigo_modalidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2866 (class 2606 OID 55642)
-- Dependencies: 1956 2014 2522
-- Name: dato_basico_indicador_test_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT dato_basico_indicador_test_fk FOREIGN KEY (indicador) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2869 (class 2606 OID 55647)
-- Dependencies: 1956 2016 2522
-- Name: dato_basico_ingreso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso
    ADD CONSTRAINT dato_basico_ingreso_fk FOREIGN KEY (codigo_tipo_documento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2872 (class 2606 OID 55652)
-- Dependencies: 1956 2018 2522
-- Name: dato_basico_ingreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk FOREIGN KEY (codigo_forma_pago) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2873 (class 2606 OID 55657)
-- Dependencies: 1956 2018 2522
-- Name: dato_basico_ingreso_forma_pago_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk1 FOREIGN KEY (codigo_tarjeta) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2874 (class 2606 OID 55662)
-- Dependencies: 2018 2522 1956
-- Name: dato_basico_ingreso_forma_pago_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk2 FOREIGN KEY (codigo_banco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2876 (class 2606 OID 55667)
-- Dependencies: 2019 1956 2522
-- Name: dato_basico_instalacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instalacion
    ADD CONSTRAINT dato_basico_instalacion_fk FOREIGN KEY (codigo_tipo_instalacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2877 (class 2606 OID 55672)
-- Dependencies: 2522 2021 1956
-- Name: dato_basico_institucion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT dato_basico_institucion_fk FOREIGN KEY (codigo_tipo_institucion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2878 (class 2606 OID 55677)
-- Dependencies: 1956 2021 2522
-- Name: dato_basico_institucion_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT dato_basico_institucion_fk1 FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2880 (class 2606 OID 55682)
-- Dependencies: 1956 2023 2522
-- Name: dato_basico_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT dato_basico_juego_fk FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2882 (class 2606 OID 55687)
-- Dependencies: 1956 2025 2522
-- Name: dato_basico_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT dato_basico_jugador_fk FOREIGN KEY (codigo_parroquia_nacimiento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2883 (class 2606 OID 55692)
-- Dependencies: 1956 2025 2522
-- Name: dato_basico_jugador_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT dato_basico_jugador_fk1 FOREIGN KEY (codigo_pais) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2885 (class 2606 OID 55697)
-- Dependencies: 2026 1956 2522
-- Name: dato_basico_jugador_foraneo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT dato_basico_jugador_foraneo_fk FOREIGN KEY (codigo_tipo_mencion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2888 (class 2606 OID 55702)
-- Dependencies: 2028 2522 1956
-- Name: dato_basico_lapso_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lapso_deportivo
    ADD CONSTRAINT dato_basico_lapso_deportivo_fk FOREIGN KEY (tipo_lapso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2889 (class 2606 OID 55707)
-- Dependencies: 2522 2030 1956
-- Name: dato_basico_liga_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga
    ADD CONSTRAINT dato_basico_liga_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2894 (class 2606 OID 55712)
-- Dependencies: 1956 2522 2034
-- Name: dato_basico_line_up_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT dato_basico_line_up_fk FOREIGN KEY (codigo_posicion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2895 (class 2606 OID 55717)
-- Dependencies: 2522 2034 1956
-- Name: dato_basico_line_up_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT dato_basico_line_up_fk1 FOREIGN KEY (codigo_tipo_mencion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2898 (class 2606 OID 55722)
-- Dependencies: 2522 1956 2036
-- Name: dato_basico_logro_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT dato_basico_logro_por_jugador_fk FOREIGN KEY (codigo_logro) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2901 (class 2606 OID 55727)
-- Dependencies: 2522 1956 2037
-- Name: dato_basico_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material
    ADD CONSTRAINT dato_basico_material_fk FOREIGN KEY (codigo_tipo_material) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2902 (class 2606 OID 55732)
-- Dependencies: 2522 2037 1956
-- Name: dato_basico_material_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material
    ADD CONSTRAINT dato_basico_material_fk1 FOREIGN KEY (codigo_unidad_medida) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2907 (class 2606 OID 55737)
-- Dependencies: 2522 2042 1956
-- Name: dato_basico_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT dato_basico_medico_fk FOREIGN KEY (codigo_especialidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2909 (class 2606 OID 55742)
-- Dependencies: 2522 2045 1956
-- Name: dato_basico_motivo_sancion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT dato_basico_motivo_sancion_fk FOREIGN KEY (codigo_motivo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2915 (class 2606 OID 55747)
-- Dependencies: 2522 2048 1956
-- Name: dato_basico_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nomina
    ADD CONSTRAINT dato_basico_nomina_fk FOREIGN KEY (codigo_tipo_nomina) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2919 (class 2606 OID 55752)
-- Dependencies: 2522 2054 1956
-- Name: dato_basico_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT dato_basico_persona_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2920 (class 2606 OID 55757)
-- Dependencies: 2054 1956 2522
-- Name: dato_basico_persona_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT dato_basico_persona_fk1 FOREIGN KEY (codigo_tipo_persona) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2922 (class 2606 OID 55762)
-- Dependencies: 1956 2522 2056
-- Name: dato_basico_persona_natural_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT dato_basico_persona_natural_fk FOREIGN KEY (codigo_genero) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2929 (class 2606 OID 55767)
-- Dependencies: 2060 2522 1956
-- Name: dato_basico_personal_cargo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_cargo
    ADD CONSTRAINT dato_basico_personal_cargo_fk FOREIGN KEY (codigo_cargo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2933 (class 2606 OID 55772)
-- Dependencies: 2064 2522 1956
-- Name: dato_basico_personal_contrato_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT dato_basico_personal_contrato_fk FOREIGN KEY (codigo_modalidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2934 (class 2606 OID 55777)
-- Dependencies: 2064 2522 1956
-- Name: dato_basico_personal_contrato_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT dato_basico_personal_contrato_fk1 FOREIGN KEY (codigo_horario) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2946 (class 2606 OID 55782)
-- Dependencies: 2072 2522 1956
-- Name: dato_basico_personal_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT dato_basico_personal_juego_fk FOREIGN KEY (codigo_cargo_personal) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2942 (class 2606 OID 55787)
-- Dependencies: 2069 2522 1956
-- Name: dato_basico_personal_juego_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo
    ADD CONSTRAINT dato_basico_personal_juego_fk1 FOREIGN KEY (codigo_tipo_personal_juego) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2949 (class 2606 OID 55792)
-- Dependencies: 1956 2073 2522
-- Name: dato_basico_personal_tipo_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_tipo_nomina
    ADD CONSTRAINT dato_basico_personal_tipo_nomina_fk FOREIGN KEY (codigo_tipo_nomina) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2952 (class 2606 OID 55797)
-- Dependencies: 2077 2522 1956
-- Name: dato_basico_plan_rotacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT dato_basico_plan_rotacion_fk FOREIGN KEY (eventualidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2957 (class 2606 OID 55802)
-- Dependencies: 2522 1956 2081
-- Name: dato_basico_planificacion_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY planificacion_actividad
    ADD CONSTRAINT dato_basico_planificacion_mantenimiento_fk FOREIGN KEY (codigo_tipo_actividad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2959 (class 2606 OID 55807)
-- Dependencies: 1956 2522 2083
-- Name: dato_basico_proveedor_banco_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY proveedor_banco
    ADD CONSTRAINT dato_basico_proveedor_banco_fk FOREIGN KEY (codigo_banco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2963 (class 2606 OID 55812)
-- Dependencies: 2522 1956 2084
-- Name: dato_basico_recaudo_por_proceso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_recaudo_por_proceso_fk FOREIGN KEY (codigo_importancia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2969 (class 2606 OID 55817)
-- Dependencies: 2090 1956 2522
-- Name: dato_basico_resultado_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY resultado_actividad
    ADD CONSTRAINT dato_basico_resultado_mantenimiento_fk FOREIGN KEY (codigo_resultado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2970 (class 2606 OID 55822)
-- Dependencies: 2522 1956 2091
-- Name: dato_basico_retiro_traslado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY retiro_traslado
    ADD CONSTRAINT dato_basico_retiro_traslado_fk FOREIGN KEY (codigo_motivo_retiro) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2975 (class 2606 OID 55827)
-- Dependencies: 2522 1956 2094
-- Name: dato_basico_roster_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT dato_basico_roster_competencia_fk FOREIGN KEY (codigo_jugador_clave) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2976 (class 2606 OID 55832)
-- Dependencies: 1956 2522 2094
-- Name: dato_basico_roster_competencia_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT dato_basico_roster_competencia_fk1 FOREIGN KEY (codigo_tipo_jugador) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2978 (class 2606 OID 55837)
-- Dependencies: 2522 1956 2096
-- Name: dato_basico_seguridad_funcional_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT dato_basico_seguridad_funcional_fk FOREIGN KEY (codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2981 (class 2606 OID 55842)
-- Dependencies: 1956 2522 2099
-- Name: dato_basico_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT dato_basico_sesion_ejecutada_fk FOREIGN KEY (eventualidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2787 (class 2606 OID 55847)
-- Dependencies: 1958 2522 1956
-- Name: dato_basico_sesion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT dato_basico_sesion_fk FOREIGN KEY (dia_semana) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2987 (class 2606 OID 55852)
-- Dependencies: 2522 1956 2101
-- Name: dato_basico_solicitud_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitud_mantenimiento
    ADD CONSTRAINT dato_basico_solicitud_mantenimiento_fk FOREIGN KEY (codigo_prioridad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2988 (class 2606 OID 55857)
-- Dependencies: 1956 2522 2103
-- Name: dato_basico_talla_por_indumentaria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT dato_basico_talla_por_indumentaria_fk FOREIGN KEY (codigo_talla) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2992 (class 2606 OID 55862)
-- Dependencies: 1956 2106 2522
-- Name: dato_basico_tarea_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT dato_basico_tarea_mantenimiento_fk FOREIGN KEY (codigo_tarea) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2994 (class 2606 OID 55867)
-- Dependencies: 1956 2108 2522
-- Name: dato_basico_tarea_mantenimiento_planificado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT dato_basico_tarea_mantenimiento_planificado_fk FOREIGN KEY (codigo_tarea) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 3001 (class 2606 OID 55872)
-- Dependencies: 1956 2117 2522
-- Name: dato_basico_tipo_pago_representante_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_pago_representante
    ADD CONSTRAINT dato_basico_tipo_pago_representante_fk FOREIGN KEY (codigo_tipo_ingreso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2943 (class 2606 OID 55877)
-- Dependencies: 2071 1956 2522
-- Name: dato_basico_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT dato_basico_umpire_juego_fk FOREIGN KEY (codigo_posicion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2818 (class 2606 OID 55882)
-- Dependencies: 1960 2526 1978
-- Name: dato_conducta_documento_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT dato_conducta_documento_conducta_fk FOREIGN KEY (codigo_dato_conducta) REFERENCES dato_conducta(codigo_dato_conducta);


--
-- TOC entry 2910 (class 2606 OID 55887)
-- Dependencies: 1960 2526 2045
-- Name: dato_conducta_motivo_sancion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT dato_conducta_motivo_sancion_fk FOREIGN KEY (codigo_dato_conducta) REFERENCES dato_conducta(codigo_dato_conducta);


--
-- TOC entry 2899 (class 2606 OID 55892)
-- Dependencies: 1962 2528 1962 2036 2036
-- Name: dato_deportivo_logro_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT dato_deportivo_logro_por_jugador_fk FOREIGN KEY (codigo_competencia, cedula_rif) REFERENCES dato_deportivo(codigo_competencia, cedula_rif);


--
-- TOC entry 2747 (class 2606 OID 55897)
-- Dependencies: 1963 1926 2530
-- Name: dato_medico_afeccion_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT dato_medico_afeccion_jugador_fk FOREIGN KEY (codigo_dato_medico) REFERENCES dato_medico(codigo_dato_medico);


--
-- TOC entry 2823 (class 2606 OID 55902)
-- Dependencies: 1963 1981 2530
-- Name: dato_medico_documento_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT dato_medico_documento_medico_fk FOREIGN KEY (codigo_dato_medico) REFERENCES dato_medico(codigo_dato_medico);


--
-- TOC entry 2836 (class 2606 OID 55907)
-- Dependencies: 1971 1988 2542
-- Name: divisa_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT divisa_equipo_fk FOREIGN KEY (codigo_divisa) REFERENCES divisa(codigo_divisa);


--
-- TOC entry 2814 (class 2606 OID 55912)
-- Dependencies: 1974 1976 2546
-- Name: documento_acreedor_documento_acreedor_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor_material
    ADD CONSTRAINT documento_acreedor_documento_acreedor_material_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2821 (class 2606 OID 55917)
-- Dependencies: 1974 2546 1980
-- Name: documento_acreedor_documento_indumentaria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_indumentaria
    ADD CONSTRAINT documento_acreedor_documento_indumentaria_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2827 (class 2606 OID 55922)
-- Dependencies: 1984 1974 2546
-- Name: documento_acreedor_donacion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY donacion_material
    ADD CONSTRAINT documento_acreedor_donacion_material_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2870 (class 2606 OID 55927)
-- Dependencies: 2546 2017 1974
-- Name: documento_acreedor_ingreso_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_documento_acreedor
    ADD CONSTRAINT documento_acreedor_ingreso_documento_acreedor_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2917 (class 2606 OID 55932)
-- Dependencies: 1974 2050 2546
-- Name: documento_acreedor_nota_entrega_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nota_entrega
    ADD CONSTRAINT documento_acreedor_nota_entrega_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2810 (class 2606 OID 55937)
-- Dependencies: 1979 1973 2554
-- Name: documento_entregado_documento_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT documento_entregado_documento_academico_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2817 (class 2606 OID 55942)
-- Dependencies: 1979 1977 2554
-- Name: documento_entregado_documento_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT documento_entregado_documento_ascenso_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2819 (class 2606 OID 55947)
-- Dependencies: 1979 1978 2554
-- Name: documento_entregado_documento_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT documento_entregado_documento_conducta_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2824 (class 2606 OID 55952)
-- Dependencies: 2554 1981 1979
-- Name: documento_entregado_documento_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT documento_entregado_documento_medico_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2825 (class 2606 OID 55957)
-- Dependencies: 2554 1979 1982
-- Name: documento_entregado_documento_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_personal
    ADD CONSTRAINT documento_entregado_documento_personal_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2830 (class 2606 OID 55962)
-- Dependencies: 1986 1985 2564
-- Name: egreso_egreso_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_cuenta_pagar
    ADD CONSTRAINT egreso_egreso_cuenta_pagar_fk FOREIGN KEY (numero_documento) REFERENCES egreso(numero_documento);


--
-- TOC entry 2833 (class 2606 OID 55967)
-- Dependencies: 2564 1987 1985
-- Name: egreso_egreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT egreso_egreso_forma_pago_fk FOREIGN KEY (numero_documento) REFERENCES egreso(numero_documento);


--
-- TOC entry 2763 (class 2606 OID 55972)
-- Dependencies: 1988 1939 2570
-- Name: equipo_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT equipo_comision_equipo_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2840 (class 2606 OID 55977)
-- Dependencies: 1990 2572 1992
-- Name: equipo_competencia_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT equipo_competencia_equipo_juego_fk FOREIGN KEY (codigo_equipo_competencia) REFERENCES equipo_competencia(codigo_equipo_competencia);


--
-- TOC entry 2886 (class 2606 OID 55982)
-- Dependencies: 2572 2026 1990
-- Name: equipo_competencia_jugador_foraneo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT equipo_competencia_jugador_foraneo_fk FOREIGN KEY (codigo_equipo_competencia) REFERENCES equipo_competencia(codigo_equipo_competencia);


--
-- TOC entry 2838 (class 2606 OID 55987)
-- Dependencies: 2570 1988 1990
-- Name: equipo_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT equipo_equipo_competencia_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2799 (class 2606 OID 55992)
-- Dependencies: 1967 1992 2574
-- Name: equipo_juego_desempenno_colectivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT equipo_juego_desempenno_colectivo_fk FOREIGN KEY (codigo_equipo_juego) REFERENCES equipo_juego(codigo_equipo_juego);


--
-- TOC entry 2940 (class 2606 OID 55997)
-- Dependencies: 1992 2068 2574
-- Name: equipo_juego_personal_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo_juego
    ADD CONSTRAINT equipo_juego_personal_equipo_juego_fk FOREIGN KEY (codigo_equipo_juego) REFERENCES equipo_juego(codigo_equipo_juego);


--
-- TOC entry 2936 (class 2606 OID 56002)
-- Dependencies: 2570 2066 1988
-- Name: equipo_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT equipo_personal_equipo_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2972 (class 2606 OID 56007)
-- Dependencies: 2570 1988 2092
-- Name: equipo_roster_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT equipo_roster_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2982 (class 2606 OID 56012)
-- Dependencies: 2570 1988 2099
-- Name: equipo_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT equipo_sesion_ejecutada_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2788 (class 2606 OID 56017)
-- Dependencies: 2570 1958 1988
-- Name: equipo_sesion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT equipo_sesion_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2997 (class 2606 OID 56022)
-- Dependencies: 2110 2570 1988
-- Name: equipo_test_evaluativo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test_evaluativo
    ADD CONSTRAINT equipo_test_evaluativo_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2862 (class 2606 OID 56027)
-- Dependencies: 1994 2009 2576
-- Name: escala_medicion_indicador_actividad_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT escala_medicion_indicador_actividad_escala_fk FOREIGN KEY (codigo_escala) REFERENCES escala_medicion(codigo_escala);


--
-- TOC entry 2867 (class 2606 OID 56032)
-- Dependencies: 1994 2014 2576
-- Name: escala_medicion_indicador_test_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT escala_medicion_indicador_test_fk FOREIGN KEY (codigo_escala) REFERENCES escala_medicion(codigo_escala);


--
-- TOC entry 3003 (class 2606 OID 56037)
-- Dependencies: 1994 2576 2120
-- Name: escala_medicion_valor_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY valor_escala
    ADD CONSTRAINT escala_medicion_valor_escala_fk FOREIGN KEY (codigo_escala) REFERENCES escala_medicion(codigo_escala);


--
-- TOC entry 2881 (class 2606 OID 56042)
-- Dependencies: 2578 2023 1996
-- Name: estadio_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT estadio_juego_fk FOREIGN KEY (codigo_estadio) REFERENCES estadio(codigo_estadio);


--
-- TOC entry 2851 (class 2606 OID 56047)
-- Dependencies: 2001 2582 1999
-- Name: familiar_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT familiar_familiar_jugador_fk FOREIGN KEY (cedula_familiar) REFERENCES familiar(cedula_familiar);


--
-- TOC entry 2849 (class 2606 OID 56052)
-- Dependencies: 2000 2586 2001
-- Name: familiar_jugador_familiar_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT familiar_jugador_familiar_comision_equipo_fk FOREIGN KEY (codigo_familiar_jugador) REFERENCES familiar_jugador(codigo_familiar_jugador);


--
-- TOC entry 2857 (class 2606 OID 56057)
-- Dependencies: 2586 2001 2006
-- Name: familiar_jugador_hospedaje_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT familiar_jugador_hospedaje_fk FOREIGN KEY (codigo_familiar_jugador) REFERENCES familiar_jugador(codigo_familiar_jugador);


--
-- TOC entry 2966 (class 2606 OID 56062)
-- Dependencies: 2001 2586 2087
-- Name: familiar_jugador_representante_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY representante
    ADD CONSTRAINT familiar_jugador_representante_fk FOREIGN KEY (codigo_familiar_jugador) REFERENCES familiar_jugador(codigo_familiar_jugador);


--
-- TOC entry 2741 (class 2606 OID 56067)
-- Dependencies: 2596 1923 2009
-- Name: indicador_actividad_escala_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT indicador_actividad_escala_actividad_planificada_fk FOREIGN KEY (codigo_indicador_actividad_escala) REFERENCES indicador_actividad_escala(codigo_indicador_actividad_escala);


--
-- TOC entry 2744 (class 2606 OID 56072)
-- Dependencies: 1924 2009 2596
-- Name: indicador_actividad_escala_actividades_ejecutadas_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividades_ejecutadas
    ADD CONSTRAINT indicador_actividad_escala_actividades_ejecutadas_fk FOREIGN KEY (codigo_indicador_actividad_escala) REFERENCES indicador_actividad_escala(codigo_indicador_actividad_escala);


--
-- TOC entry 2800 (class 2606 OID 56077)
-- Dependencies: 1967 2011 2598
-- Name: indicador_competencia_desempenno_colectivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT indicador_competencia_desempenno_colectivo_fk FOREIGN KEY (codigo_indicador_competencia) REFERENCES indicador_categoria_competencia(codigo_indicador_competencia);


--
-- TOC entry 2801 (class 2606 OID 56082)
-- Dependencies: 1968 2011 2598
-- Name: indicador_competencia_desempenno_individual_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_individual
    ADD CONSTRAINT indicador_competencia_desempenno_individual_fk FOREIGN KEY (codigo_indicador_competencia) REFERENCES indicador_categoria_competencia(codigo_indicador_competencia);


--
-- TOC entry 2865 (class 2606 OID 56087)
-- Dependencies: 2011 2008 2594
-- Name: indicador_indicador_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT indicador_indicador_competencia_fk FOREIGN KEY (codigo_indicador) REFERENCES indicador(codigo_indicador);


--
-- TOC entry 2998 (class 2606 OID 56092)
-- Dependencies: 2600 2112 2014
-- Name: indicador_test_test_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test_jugador
    ADD CONSTRAINT indicador_test_test_jugador_fk FOREIGN KEY (codigo_indicador_test) REFERENCES indicador_test(codigo_indicador_test);


--
-- TOC entry 2871 (class 2606 OID 56097)
-- Dependencies: 2017 2602 2016
-- Name: ingreso_ingreso_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_documento_acreedor
    ADD CONSTRAINT ingreso_ingreso_documento_acreedor_fk FOREIGN KEY (numero_documento) REFERENCES ingreso(numero_documento);


--
-- TOC entry 2875 (class 2606 OID 56102)
-- Dependencies: 2016 2602 2018
-- Name: ingreso_ingreso_forma_pago_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT ingreso_ingreso_forma_pago_fk1 FOREIGN KEY (numero_documento) REFERENCES ingreso(numero_documento);


--
-- TOC entry 2750 (class 2606 OID 56107)
-- Dependencies: 1928 2608 2019
-- Name: instalacion_almacen_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY almacen
    ADD CONSTRAINT instalacion_almacen_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2953 (class 2606 OID 56112)
-- Dependencies: 2608 2019 2077
-- Name: instalacion_plan_rotacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT instalacion_plan_rotacion_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2958 (class 2606 OID 56117)
-- Dependencies: 2081 2608 2019
-- Name: instalacion_planificacion_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY planificacion_actividad
    ADD CONSTRAINT instalacion_planificacion_mantenimiento_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2983 (class 2606 OID 56122)
-- Dependencies: 2099 2608 2019
-- Name: instalacion_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT instalacion_sesion_ejecutada_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2782 (class 2606 OID 56127)
-- Dependencies: 2021 1952 2610
-- Name: institucion_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT institucion_dato_academico_fk FOREIGN KEY (codigo_institucion) REFERENCES institucion(codigo_institucion);


--
-- TOC entry 2797 (class 2606 OID 56132)
-- Dependencies: 2021 2610 1965
-- Name: institucion_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT institucion_dato_social_fk FOREIGN KEY (codigo_institucion) REFERENCES institucion(codigo_institucion);


--
-- TOC entry 2738 (class 2606 OID 56137)
-- Dependencies: 2612 1918 2023
-- Name: juego_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT juego_actividad_calendario_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2841 (class 2606 OID 56142)
-- Dependencies: 1992 2023 2612
-- Name: juego_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT juego_equipo_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2887 (class 2606 OID 56147)
-- Dependencies: 2026 2612 2023
-- Name: juego_jugador_foraneo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT juego_jugador_foraneo_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2896 (class 2606 OID 56152)
-- Dependencies: 2023 2034 2612
-- Name: juego_line_up_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT juego_line_up_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2937 (class 2606 OID 56157)
-- Dependencies: 2612 2023 2066
-- Name: juego_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT juego_personal_equipo_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2947 (class 2606 OID 56162)
-- Dependencies: 2023 2612 2072
-- Name: juego_personal_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT juego_personal_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2944 (class 2606 OID 56167)
-- Dependencies: 2612 2071 2023
-- Name: juego_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT juego_umpire_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2783 (class 2606 OID 56172)
-- Dependencies: 1952 2025 2614
-- Name: jugador_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT jugador_dato_academico_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2793 (class 2606 OID 56177)
-- Dependencies: 2614 2025 1962
-- Name: jugador_dato_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT jugador_dato_deportivo_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2794 (class 2606 OID 56182)
-- Dependencies: 2025 1963 2614
-- Name: jugador_dato_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT jugador_dato_medico_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2791 (class 2606 OID 56187)
-- Dependencies: 1960 2614 2025
-- Name: jugador_dato_sancion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT jugador_dato_sancion_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2798 (class 2606 OID 56192)
-- Dependencies: 1965 2025 2614
-- Name: jugador_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT jugador_dato_social_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2826 (class 2606 OID 56197)
-- Dependencies: 2614 1982 2025
-- Name: jugador_documento_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_personal
    ADD CONSTRAINT jugador_documento_personal_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2852 (class 2606 OID 56202)
-- Dependencies: 2025 2001 2614
-- Name: jugador_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT jugador_familiar_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2971 (class 2606 OID 56207)
-- Dependencies: 2025 2091 2614
-- Name: jugador_retiro_traslado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY retiro_traslado
    ADD CONSTRAINT jugador_retiro_traslado_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2973 (class 2606 OID 56212)
-- Dependencies: 2025 2092 2614
-- Name: jugador_roster_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT jugador_roster_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2989 (class 2606 OID 56217)
-- Dependencies: 2025 2105 2614
-- Name: jugador_talla_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT jugador_talla_por_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2891 (class 2606 OID 56222)
-- Dependencies: 2030 2031 2620
-- Name: liga_liga_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_categoria
    ADD CONSTRAINT liga_liga_categoria_fk FOREIGN KEY (codigo_liga) REFERENCES liga(codigo_liga);


--
-- TOC entry 2893 (class 2606 OID 56227)
-- Dependencies: 2030 2033 2620
-- Name: liga_liga_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_competencia
    ADD CONSTRAINT liga_liga_competencia_fk FOREIGN KEY (codigo_liga) REFERENCES liga(codigo_liga);


--
-- TOC entry 2802 (class 2606 OID 56232)
-- Dependencies: 2034 1968 2626
-- Name: line_up_desempenno_individual_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_individual
    ADD CONSTRAINT line_up_desempenno_individual_fk FOREIGN KEY (codigo_line_up) REFERENCES line_up(codigo_line_up);


--
-- TOC entry 2778 (class 2606 OID 56237)
-- Dependencies: 2037 2630 1951
-- Name: material_cuenta_pagar_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT material_cuenta_pagar_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2779 (class 2606 OID 56242)
-- Dependencies: 1951 2037 2630
-- Name: material_cuenta_pagar_material_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT material_cuenta_pagar_material_fk1 FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2806 (class 2606 OID 56247)
-- Dependencies: 1970 2037 2630
-- Name: material_detalle_requisicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_requisicion
    ADD CONSTRAINT material_detalle_requisicion_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2815 (class 2606 OID 56252)
-- Dependencies: 2630 1976 2037
-- Name: material_documento_acreedor_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor_material
    ADD CONSTRAINT material_documento_acreedor_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2828 (class 2606 OID 56257)
-- Dependencies: 2037 1984 2630
-- Name: material_donacion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY donacion_material
    ADD CONSTRAINT material_donacion_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2904 (class 2606 OID 56262)
-- Dependencies: 2037 2038 2630
-- Name: material_material_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad
    ADD CONSTRAINT material_material_mantenimiento_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2905 (class 2606 OID 56267)
-- Dependencies: 2037 2040 2630
-- Name: material_material_mantenimiento_planificado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad_planificada
    ADD CONSTRAINT material_material_mantenimiento_planificado_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2964 (class 2606 OID 56272)
-- Dependencies: 2037 2086 2630
-- Name: material_recepcion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recepcion_material
    ADD CONSTRAINT material_recepcion_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2795 (class 2606 OID 56277)
-- Dependencies: 2042 1963 2636
-- Name: medico_dato_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT medico_dato_medico_fk FOREIGN KEY (numero_colegio) REFERENCES medico(numero_colegio);


--
-- TOC entry 2912 (class 2606 OID 56282)
-- Dependencies: 2046 2048 2644
-- Name: nomina_movimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT nomina_movimiento_fk FOREIGN KEY (codigo_nomina) REFERENCES nomina(codigo_nomina);


--
-- TOC entry 2965 (class 2606 OID 56287)
-- Dependencies: 2086 2050 2646
-- Name: nota_entrega_recepcion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recepcion_material
    ADD CONSTRAINT nota_entrega_recepcion_material_fk FOREIGN KEY (codigo_nota_entrega) REFERENCES nota_entrega(codigo_nota_entrega);


--
-- TOC entry 2776 (class 2606 OID 56292)
-- Dependencies: 2650 1950 2054
-- Name: persona_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT persona_cuenta_pagar_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2812 (class 2606 OID 56297)
-- Dependencies: 2054 1974 2650
-- Name: persona_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT persona_documento_acreedor_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2813 (class 2606 OID 56302)
-- Dependencies: 2054 1974 2650
-- Name: persona_documento_acreedor_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT persona_documento_acreedor_fk1 FOREIGN KEY (cedula_atleta) REFERENCES persona(cedula_rif);


--
-- TOC entry 2839 (class 2606 OID 56307)
-- Dependencies: 2054 1990 2650
-- Name: persona_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT persona_equipo_competencia_fk FOREIGN KEY (delegado) REFERENCES persona(cedula_rif);


--
-- TOC entry 2847 (class 2606 OID 56312)
-- Dependencies: 2054 1999 2650
-- Name: persona_familiar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT persona_familiar_fk FOREIGN KEY (cedula_familiar) REFERENCES persona(cedula_rif);


--
-- TOC entry 2884 (class 2606 OID 56317)
-- Dependencies: 2025 2650 2054
-- Name: persona_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT persona_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2960 (class 2606 OID 56322)
-- Dependencies: 2652 2083 2055
-- Name: persona_juridica_proveedor_banco_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY proveedor_banco
    ADD CONSTRAINT persona_juridica_proveedor_banco_fk FOREIGN KEY (cedula_rif) REFERENCES persona_juridica(cedula_rif);


--
-- TOC entry 2924 (class 2606 OID 56327)
-- Dependencies: 2057 2056 2654
-- Name: persona_natural_personal_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT persona_natural_personal_fk1 FOREIGN KEY (cedula_rif) REFERENCES persona_natural(cedula_rif);


--
-- TOC entry 2921 (class 2606 OID 56332)
-- Dependencies: 2650 2055 2054
-- Name: persona_persona_juridica_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_juridica
    ADD CONSTRAINT persona_persona_juridica_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2923 (class 2606 OID 56337)
-- Dependencies: 2054 2056 2650
-- Name: persona_persona_natural_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT persona_persona_natural_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2995 (class 2606 OID 56342)
-- Dependencies: 2059 2108 2108 2059 2660
-- Name: personal_actividad_planificada_tarea_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT personal_actividad_planificada_tarea_actividad_planificada_fk FOREIGN KEY (cedula_rif, codigo_planificacion_actividad) REFERENCES personal_actividad_planificada(cedula_rif, codigo_planificacion_actividad);


--
-- TOC entry 2993 (class 2606 OID 56347)
-- Dependencies: 2058 2106 2106 2058 2658
-- Name: personal_actividad_tarea_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT personal_actividad_tarea_actividad_fk FOREIGN KEY (cedula_rif, codigo_actividad) REFERENCES personal_actividad(cedula_rif, codigo_actividad);


--
-- TOC entry 2749 (class 2606 OID 56352)
-- Dependencies: 2057 1927 2656
-- Name: personal_afeccion_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_personal
    ADD CONSTRAINT personal_afeccion_personal_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2784 (class 2606 OID 56357)
-- Dependencies: 2057 1954 2656
-- Name: personal_dato_academico_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico_personal
    ADD CONSTRAINT personal_dato_academico_personal_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2927 (class 2606 OID 56362)
-- Dependencies: 2059 2057 2656
-- Name: personal_empleado_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad_planificada
    ADD CONSTRAINT personal_empleado_actividad_planificada_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2755 (class 2606 OID 56367)
-- Dependencies: 2668 1934 2066
-- Name: personal_equipo_asistencia_personal_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT personal_equipo_asistencia_personal_entrenamiento_fk FOREIGN KEY (codigo_personal_equipo) REFERENCES personal_equipo(codigo_personal_equipo);


--
-- TOC entry 2941 (class 2606 OID 56372)
-- Dependencies: 2066 2068 2668
-- Name: personal_equipo_personal_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo_juego
    ADD CONSTRAINT personal_equipo_personal_equipo_juego_fk FOREIGN KEY (codigo_personal_equipo) REFERENCES personal_equipo(codigo_personal_equipo);


--
-- TOC entry 2913 (class 2606 OID 56377)
-- Dependencies: 2057 2046 2656
-- Name: personal_movimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT personal_movimiento_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2926 (class 2606 OID 56382)
-- Dependencies: 2057 2058 2656
-- Name: personal_personal_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad
    ADD CONSTRAINT personal_personal_actividad_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2930 (class 2606 OID 56387)
-- Dependencies: 2057 2060 2656
-- Name: personal_personal_cargo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_cargo
    ADD CONSTRAINT personal_personal_cargo_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2932 (class 2606 OID 56392)
-- Dependencies: 2057 2062 2656
-- Name: personal_personal_concepto_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_concepto_nomina
    ADD CONSTRAINT personal_personal_concepto_nomina_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2935 (class 2606 OID 56397)
-- Dependencies: 2656 2064 2057
-- Name: personal_personal_contrato_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT personal_personal_contrato_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2938 (class 2606 OID 56402)
-- Dependencies: 2066 2656 2057
-- Name: personal_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT personal_personal_equipo_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2948 (class 2606 OID 56407)
-- Dependencies: 2072 2057 2656
-- Name: personal_personal_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT personal_personal_juego_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2950 (class 2606 OID 56412)
-- Dependencies: 2656 2073 2057
-- Name: personal_personal_tipo_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_tipo_nomina
    ADD CONSTRAINT personal_personal_tipo_nomina_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2967 (class 2606 OID 56417)
-- Dependencies: 2057 2088 2656
-- Name: personal_requisicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY requisicion
    ADD CONSTRAINT personal_requisicion_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 3002 (class 2606 OID 56422)
-- Dependencies: 2057 2119 2656
-- Name: personal_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT personal_usuario_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2984 (class 2606 OID 56427)
-- Dependencies: 2075 2099 2680
-- Name: plan_entrenamiento_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT plan_entrenamiento_sesion_ejecutada_fk FOREIGN KEY (codigo_plan_entrenamiento) REFERENCES plan_entrenamiento(codigo_plan_entrenamiento);


--
-- TOC entry 2789 (class 2606 OID 56432)
-- Dependencies: 2075 1958 2680
-- Name: plan_entrenamiento_sesion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT plan_entrenamiento_sesion_fk FOREIGN KEY (codigo_plan_entrenamiento) REFERENCES plan_entrenamiento(codigo_plan_entrenamiento);


--
-- TOC entry 2985 (class 2606 OID 56437)
-- Dependencies: 2077 2099 2682
-- Name: plan_rotacion_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT plan_rotacion_sesion_ejecutada_fk FOREIGN KEY (codigo_plan_rotacion) REFERENCES plan_rotacion(codigo_plan_rotacion);


--
-- TOC entry 2734 (class 2606 OID 56442)
-- Dependencies: 2686 1917 2081
-- Name: planificacion_actividad_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT planificacion_actividad_actividad_fk FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2928 (class 2606 OID 56447)
-- Dependencies: 2059 2081 2686
-- Name: planificacion_mantenimiento_empleado_mantenimiento_planifica195; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad_planificada
    ADD CONSTRAINT planificacion_mantenimiento_empleado_mantenimiento_planifica195 FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2906 (class 2606 OID 56452)
-- Dependencies: 2040 2081 2686
-- Name: planificacion_mantenimiento_material_mantenimiento_planifica583; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad_planificada
    ADD CONSTRAINT planificacion_mantenimiento_material_mantenimiento_planifica583 FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2918 (class 2606 OID 56457)
-- Dependencies: 2052 2081 2686
-- Name: planificacion_mantenimiento_periodicidad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY periodicidad
    ADD CONSTRAINT planificacion_mantenimiento_periodicidad_fk FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2996 (class 2606 OID 56462)
-- Dependencies: 2108 2081 2686
-- Name: planificacion_mantenimiento_tarea_mantenimiento_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT planificacion_mantenimiento_tarea_mantenimiento_planificada_fk FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2820 (class 2606 OID 56467)
-- Dependencies: 1979 2690 2084
-- Name: recaudo_por_proceso_documento_entregado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_entregado
    ADD CONSTRAINT recaudo_por_proceso_documento_entregado_fk FOREIGN KEY (codigo_recaudo_por_proceso) REFERENCES recaudo_por_proceso(codigo_recaudo_por_proceso);


--
-- TOC entry 2807 (class 2606 OID 56472)
-- Dependencies: 2696 2088 1970
-- Name: requisicion_detalle_requisicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_requisicion
    ADD CONSTRAINT requisicion_detalle_requisicion_fk FOREIGN KEY (codigo_requisicion) REFERENCES requisicion(codigo_requisicion);


--
-- TOC entry 2751 (class 2606 OID 56477)
-- Dependencies: 1930 2092 2702
-- Name: roster_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ascenso
    ADD CONSTRAINT roster_ascenso_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2753 (class 2606 OID 56482)
-- Dependencies: 1932 2702 2092
-- Name: roster_asistencia_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_jugador
    ADD CONSTRAINT roster_asistencia_jugador_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2897 (class 2606 OID 56487)
-- Dependencies: 2034 2704 2094
-- Name: roster_competencia_line_up_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT roster_competencia_line_up_fk FOREIGN KEY (codigo_roster_competencia) REFERENCES roster_competencia(codigo_roster_competencia);


--
-- TOC entry 2977 (class 2606 OID 56492)
-- Dependencies: 2702 2092 2094
-- Name: roster_roster_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT roster_roster_competencia_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2999 (class 2606 OID 56497)
-- Dependencies: 2112 2702 2092
-- Name: roster_test_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test_jugador
    ADD CONSTRAINT roster_test_jugador_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2742 (class 2606 OID 56502)
-- Dependencies: 2524 1958 1923
-- Name: sesion_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT sesion_actividad_planificada_fk FOREIGN KEY (codigo_sesion) REFERENCES sesion(codigo_sesion);


--
-- TOC entry 2745 (class 2606 OID 56507)
-- Dependencies: 2708 2099 1924
-- Name: sesion_ejecutada_actividades_ejecutadas_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividades_ejecutadas
    ADD CONSTRAINT sesion_ejecutada_actividades_ejecutadas_fk FOREIGN KEY (codigo_sesion_ejecutada) REFERENCES sesion_ejecutada(codigo_sesion_ejecutada);


--
-- TOC entry 2754 (class 2606 OID 56512)
-- Dependencies: 2708 2099 1932
-- Name: sesion_ejecutada_asistencia_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_jugador
    ADD CONSTRAINT sesion_ejecutada_asistencia_jugador_fk FOREIGN KEY (codigo_sesion_ejecutada) REFERENCES sesion_ejecutada(codigo_sesion_ejecutada);


--
-- TOC entry 2756 (class 2606 OID 56517)
-- Dependencies: 2708 2099 1934
-- Name: sesion_ejecutada_asistencia_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT sesion_ejecutada_asistencia_personal_fk FOREIGN KEY (codigo_sesion_ejecutada) REFERENCES sesion_ejecutada(codigo_sesion_ejecutada);


--
-- TOC entry 2954 (class 2606 OID 56522)
-- Dependencies: 2524 1958 2077
-- Name: sesion_plan_rotacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT sesion_plan_rotacion_fk FOREIGN KEY (codigo_sesion) REFERENCES sesion(codigo_sesion);


--
-- TOC entry 2822 (class 2606 OID 56527)
-- Dependencies: 2103 2712 1980
-- Name: talla_por_indumentaria_documento_indumentaria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_indumentaria
    ADD CONSTRAINT talla_por_indumentaria_documento_indumentaria_fk FOREIGN KEY (codigo_talla_indumentaria) REFERENCES talla_por_indumentaria(codigo_talla_indumentaria);


--
-- TOC entry 2990 (class 2606 OID 56532)
-- Dependencies: 2105 2103 2712
-- Name: talla_por_indumentaria_talla_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT talla_por_indumentaria_talla_por_jugador_fk FOREIGN KEY (codigo_talla_indumentaria) REFERENCES talla_por_indumentaria(codigo_talla_indumentaria);


--
-- TOC entry 2767 (class 2606 OID 56537)
-- Dependencies: 2618 1941 2028
-- Name: temporada_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT temporada_competencia_fk FOREIGN KEY (codigo_lapso_deportivo) REFERENCES lapso_deportivo(codigo_lapso_deportivo);


--
-- TOC entry 2855 (class 2606 OID 56542)
-- Dependencies: 2004 2684 2079
-- Name: temporada_horario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT temporada_horario_fk FOREIGN KEY (codigo_plan_temporada) REFERENCES plan_temporada(codigo_plan_temporada);


--
-- TOC entry 2939 (class 2606 OID 56547)
-- Dependencies: 2066 2079 2684
-- Name: temporada_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT temporada_personal_equipo_fk FOREIGN KEY (codigo_plan_temporada) REFERENCES plan_temporada(codigo_plan_temporada);


--
-- TOC entry 2951 (class 2606 OID 56552)
-- Dependencies: 2075 2079 2684
-- Name: temporada_plan_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_entrenamiento
    ADD CONSTRAINT temporada_plan_entrenamiento_fk FOREIGN KEY (codigo_plan_temporada) REFERENCES plan_temporada(codigo_plan_temporada);


--
-- TOC entry 2956 (class 2606 OID 56557)
-- Dependencies: 2079 2028 2618
-- Name: temporada_plan_temporada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_temporada
    ADD CONSTRAINT temporada_plan_temporada_fk FOREIGN KEY (codigo_lapso_deportivo) REFERENCES lapso_deportivo(codigo_lapso_deportivo);


--
-- TOC entry 2868 (class 2606 OID 56562)
-- Dependencies: 2014 2720 2110
-- Name: test_evaluativo_indicador_test_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT test_evaluativo_indicador_test_fk FOREIGN KEY (codigo_test) REFERENCES test_evaluativo(codigo_test);


--
-- TOC entry 2768 (class 2606 OID 56567)
-- Dependencies: 2724 1941 2113
-- Name: tipo_competencia_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT tipo_competencia_competencia_fk FOREIGN KEY (codigo_tipo_competencia) REFERENCES tipo_competencia(codigo_tipo_competencia);


--
-- TOC entry 2771 (class 2606 OID 56572)
-- Dependencies: 2113 1945 2724
-- Name: tipo_competencia_condicion_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY condicion_competencia
    ADD CONSTRAINT tipo_competencia_condicion_competencia_fk FOREIGN KEY (codigo_tipo_competencia) REFERENCES tipo_competencia(codigo_tipo_competencia);


--
-- TOC entry 2908 (class 2606 OID 56577)
-- Dependencies: 2113 2724 2043
-- Name: tipo_competencia_modalidad_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY modalidad_competencia
    ADD CONSTRAINT tipo_competencia_modalidad_competencia_fk FOREIGN KEY (codigo_tipo_competencia) REFERENCES tipo_competencia(codigo_tipo_competencia);


--
-- TOC entry 2786 (class 2606 OID 56582)
-- Dependencies: 2115 2726 1956
-- Name: tipo_dato_dato_basico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT tipo_dato_dato_basico_fk FOREIGN KEY (codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 2979 (class 2606 OID 56587)
-- Dependencies: 2096 2726 2115
-- Name: tipo_dato_seguridad_funcional_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT tipo_dato_seguridad_funcional_fk FOREIGN KEY (codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 3000 (class 2606 OID 56592)
-- Dependencies: 2115 2726 2115
-- Name: tipo_dato_tipo_dato_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_dato
    ADD CONSTRAINT tipo_dato_tipo_dato_fk FOREIGN KEY (parent_codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 2945 (class 2606 OID 56597)
-- Dependencies: 2071 2672 2069
-- Name: umpire_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT umpire_umpire_juego_fk FOREIGN KEY (codigo_personal_foraneo) REFERENCES personal_foraneo(codigo_personal_foraneo);


--
-- TOC entry 2743 (class 2606 OID 56602)
-- Dependencies: 2119 2730 1923
-- Name: usuario_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT usuario_actividad_planificada_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 2757 (class 2606 OID 56607)
-- Dependencies: 1934 2730 2119
-- Name: usuario_asistencia_personal_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT usuario_asistencia_personal_entrenamiento_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 2805 (class 2606 OID 56612)
-- Dependencies: 2730 1969 2119
-- Name: usuario_desempeo_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT usuario_desempeo_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 2980 (class 2606 OID 56617)
-- Dependencies: 2730 2119 2096
-- Name: usuario_seguridad_funcional_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT usuario_seguridad_funcional_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 3009 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-01-08 12:16:27

--
-- PostgreSQL database dump complete
--

