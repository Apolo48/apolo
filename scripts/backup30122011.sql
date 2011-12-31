--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.5
-- Dumped by pg_dump version 9.0.3
-- Started on 2011-12-31 01:22:46

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 2999 (class 1262 OID 11826)
-- Dependencies: 2998
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 722 (class 2612 OID 11574)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1914 (class 1259 OID 51672)
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
-- TOC entry 1915 (class 1259 OID 51675)
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
-- TOC entry 1916 (class 1259 OID 51681)
-- Dependencies: 6 1915
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
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 1916
-- Name: actividad_calendario_codigo_actividad_calendario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividad_calendario_codigo_actividad_calendario_seq OWNED BY actividad_calendario.codigo_actividad_calendario;


--
-- TOC entry 1917 (class 1259 OID 51683)
-- Dependencies: 1914 6
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
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 1917
-- Name: actividad_codigo_actividad_seq_6_1_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividad_codigo_actividad_seq_6_1_1 OWNED BY actividad.codigo_actividad;


--
-- TOC entry 1918 (class 1259 OID 51685)
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
-- TOC entry 1919 (class 1259 OID 51691)
-- Dependencies: 1918 6
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
-- TOC entry 3004 (class 0 OID 0)
-- Dependencies: 1919
-- Name: actividad_entrenamiento_cod_actividad_entrenamiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividad_entrenamiento_cod_actividad_entrenamiento_seq OWNED BY actividad_entrenamiento.cod_actividad_entrenamiento;


--
-- TOC entry 1920 (class 1259 OID 51693)
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
-- TOC entry 1921 (class 1259 OID 51699)
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
-- TOC entry 1922 (class 1259 OID 51702)
-- Dependencies: 6 1921
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
-- TOC entry 3005 (class 0 OID 0)
-- Dependencies: 1922
-- Name: actividades_ejecutadas_codigo_actividad_ejecutada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividades_ejecutadas_codigo_actividad_ejecutada_seq OWNED BY actividades_ejecutadas.codigo_actividad_ejecutada;


--
-- TOC entry 1923 (class 1259 OID 51704)
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
-- TOC entry 1924 (class 1259 OID 51707)
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
-- TOC entry 1925 (class 1259 OID 51713)
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
-- TOC entry 1926 (class 1259 OID 51719)
-- Dependencies: 1925 6
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
-- TOC entry 3006 (class 0 OID 0)
-- Dependencies: 1926
-- Name: almacen_codigo_almacen_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE almacen_codigo_almacen_seq_1 OWNED BY almacen.codigo_almacen;


--
-- TOC entry 1927 (class 1259 OID 51721)
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
-- TOC entry 1928 (class 1259 OID 51727)
-- Dependencies: 1927 6
-- Name: ascenso_codigo_ascenso_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ascenso_codigo_ascenso_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ascenso_codigo_ascenso_seq1 OWNER TO postgres;

--
-- TOC entry 3007 (class 0 OID 0)
-- Dependencies: 1928
-- Name: ascenso_codigo_ascenso_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ascenso_codigo_ascenso_seq1 OWNED BY ascenso.codigo_ascenso;


--
-- TOC entry 1929 (class 1259 OID 51729)
-- Dependencies: 6
-- Name: asistencia_jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE asistencia_jugador (
    codigo_asistencia integer NOT NULL,
    codigo_sesion_ejecutada integer NOT NULL,
    eventualidad integer NOT NULL,
    asistencia boolean NOT NULL,
    observacion character varying NOT NULL
);


ALTER TABLE public.asistencia_jugador OWNER TO postgres;

--
-- TOC entry 1930 (class 1259 OID 51735)
-- Dependencies: 1929 6
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
-- TOC entry 3008 (class 0 OID 0)
-- Dependencies: 1930
-- Name: asistencia_jugador_codigo_asistencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE asistencia_jugador_codigo_asistencia_seq_1 OWNED BY asistencia_jugador.codigo_asistencia;


--
-- TOC entry 1931 (class 1259 OID 51737)
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
-- TOC entry 1932 (class 1259 OID 51743)
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
-- TOC entry 1933 (class 1259 OID 51749)
-- Dependencies: 6 1932
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
-- TOC entry 3009 (class 0 OID 0)
-- Dependencies: 1933
-- Name: categoria_codigo_categoria_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE categoria_codigo_categoria_seq_1 OWNED BY categoria.codigo_categoria;


--
-- TOC entry 1934 (class 1259 OID 51751)
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
-- TOC entry 1935 (class 1259 OID 51754)
-- Dependencies: 6
-- Name: comision_actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE comision_actividad (
    codigo_comision integer NOT NULL,
    codigo_actividad integer NOT NULL
);


ALTER TABLE public.comision_actividad OWNER TO postgres;

--
-- TOC entry 1936 (class 1259 OID 51757)
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
-- TOC entry 1937 (class 1259 OID 51760)
-- Dependencies: 6 1936
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
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 1937
-- Name: comision_equipo_codigo_comision_equipo_seq_1_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE comision_equipo_codigo_comision_equipo_seq_1_1 OWNED BY comision_equipo.codigo_comision_equipo;


--
-- TOC entry 1938 (class 1259 OID 51762)
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
-- TOC entry 1939 (class 1259 OID 51768)
-- Dependencies: 6 1938
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
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 1939
-- Name: competencia_codigo_competencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE competencia_codigo_competencia_seq_1 OWNED BY competencia.codigo_competencia;


--
-- TOC entry 1940 (class 1259 OID 51770)
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
-- TOC entry 1941 (class 1259 OID 51776)
-- Dependencies: 1940 6
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
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 1941
-- Name: concepto_nomina_codigo_concepto_nomina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE concepto_nomina_codigo_concepto_nomina_seq OWNED BY concepto_nomina.codigo_concepto_nomina;


--
-- TOC entry 1942 (class 1259 OID 51778)
-- Dependencies: 6
-- Name: condicion_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE condicion_competencia (
    codigo_condicion integer NOT NULL,
    codigo_tipo_competencia integer NOT NULL
);


ALTER TABLE public.condicion_competencia OWNER TO postgres;

--
-- TOC entry 1943 (class 1259 OID 51781)
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
-- TOC entry 1944 (class 1259 OID 51787)
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
-- TOC entry 1945 (class 1259 OID 51790)
-- Dependencies: 1944 6
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
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 1945
-- Name: constante_categoria_codigo_constante_categoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE constante_categoria_codigo_constante_categoria_seq OWNED BY constante_categoria.codigo_constante_categoria;


--
-- TOC entry 1946 (class 1259 OID 51792)
-- Dependencies: 1943 6
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
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 1946
-- Name: constante_codigo_constante_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE constante_codigo_constante_seq_1 OWNED BY constante.codigo_constante;


--
-- TOC entry 1947 (class 1259 OID 51794)
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
-- TOC entry 1948 (class 1259 OID 51800)
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
-- TOC entry 1949 (class 1259 OID 51806)
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
-- TOC entry 1950 (class 1259 OID 51812)
-- Dependencies: 1949 6
-- Name: dato_academico_codigo_academico_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_academico_codigo_academico_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_academico_codigo_academico_seq1 OWNER TO postgres;

--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 1950
-- Name: dato_academico_codigo_academico_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_academico_codigo_academico_seq1 OWNED BY dato_academico.codigo_academico;


--
-- TOC entry 1951 (class 1259 OID 51814)
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
-- TOC entry 1952 (class 1259 OID 51820)
-- Dependencies: 6 1951
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
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 1952
-- Name: dato_academico_personal_codigo_dato_academico_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_academico_personal_codigo_dato_academico_seq OWNED BY dato_academico_personal.codigo_dato_academico;


--
-- TOC entry 1953 (class 1259 OID 51822)
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
-- TOC entry 1954 (class 1259 OID 51828)
-- Dependencies: 6 1953
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
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 1954
-- Name: dato_basico_codigo_dato_basico_seq_2_5; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_basico_codigo_dato_basico_seq_2_5 OWNED BY dato_basico.codigo_dato_basico;


--
-- TOC entry 1955 (class 1259 OID 51830)
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
-- TOC entry 1956 (class 1259 OID 51833)
-- Dependencies: 1955 6
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
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 1956
-- Name: dato_basico_dia_semana_seq_2_11; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_basico_dia_semana_seq_2_11 OWNED BY sesion.dia_semana;


--
-- TOC entry 1957 (class 1259 OID 51835)
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
-- TOC entry 1958 (class 1259 OID 51841)
-- Dependencies: 6 1957
-- Name: dato_conducta_codigo_dato_conducta_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_conducta_codigo_dato_conducta_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_conducta_codigo_dato_conducta_seq1 OWNER TO postgres;

--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 1958
-- Name: dato_conducta_codigo_dato_conducta_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_conducta_codigo_dato_conducta_seq1 OWNED BY dato_conducta.codigo_dato_conducta;


--
-- TOC entry 1959 (class 1259 OID 51843)
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
-- TOC entry 1960 (class 1259 OID 51849)
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
-- TOC entry 1961 (class 1259 OID 51855)
-- Dependencies: 1960 6
-- Name: dato_medico_codigo_dato_medico_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_medico_codigo_dato_medico_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_medico_codigo_dato_medico_seq1 OWNER TO postgres;

--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 1961
-- Name: dato_medico_codigo_dato_medico_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_medico_codigo_dato_medico_seq1 OWNED BY dato_medico.codigo_dato_medico;


--
-- TOC entry 1962 (class 1259 OID 51857)
-- Dependencies: 6
-- Name: dato_social; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dato_social (
    codigo_dato_social integer NOT NULL,
    codigo_actividad_social integer NOT NULL,
    cedula_rif character varying NOT NULL,
    codigo_institucion integer NOT NULL,
    horas_dedicadas integer,
    estatus character(1) NOT NULL,
    fecha_inicio date
);


ALTER TABLE public.dato_social OWNER TO postgres;

--
-- TOC entry 1963 (class 1259 OID 51863)
-- Dependencies: 6 1962
-- Name: dato_social_codigo_dato_social_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE dato_social_codigo_dato_social_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dato_social_codigo_dato_social_seq1 OWNER TO postgres;

--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 1963
-- Name: dato_social_codigo_dato_social_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE dato_social_codigo_dato_social_seq1 OWNED BY dato_social.codigo_dato_social;


--
-- TOC entry 1964 (class 1259 OID 51865)
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
-- TOC entry 1965 (class 1259 OID 51868)
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
-- TOC entry 1966 (class 1259 OID 51871)
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
-- TOC entry 1967 (class 1259 OID 51877)
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
-- TOC entry 1968 (class 1259 OID 51880)
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
-- TOC entry 1969 (class 1259 OID 51886)
-- Dependencies: 1968 6
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
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 1969
-- Name: divisa_codigo_divisa_seq_2; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE divisa_codigo_divisa_seq_2 OWNED BY divisa.codigo_divisa;


--
-- TOC entry 1970 (class 1259 OID 51888)
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
-- TOC entry 1971 (class 1259 OID 51891)
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
-- TOC entry 1972 (class 1259 OID 51897)
-- Dependencies: 1971 6
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
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 1972
-- Name: documento_acreedor_codigo_documento_acreedor_seq_3_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE documento_acreedor_codigo_documento_acreedor_seq_3_1 OWNED BY documento_acreedor.codigo_documento_acreedor;


--
-- TOC entry 1973 (class 1259 OID 51899)
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
-- TOC entry 1974 (class 1259 OID 51902)
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
-- TOC entry 1975 (class 1259 OID 51905)
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
-- TOC entry 1976 (class 1259 OID 51908)
-- Dependencies: 6
-- Name: documento_entregado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE documento_entregado (
    codigo_documento_entregado integer NOT NULL,
    codigo_recaudo_por_proceso integer NOT NULL,
    documento bytea NOT NULL,
    cantidad integer,
    fecha date NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.documento_entregado OWNER TO postgres;

--
-- TOC entry 1977 (class 1259 OID 51914)
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
-- TOC entry 1978 (class 1259 OID 51917)
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
-- TOC entry 1979 (class 1259 OID 51920)
-- Dependencies: 1976 6
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
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 1979
-- Name: documentos_entregados_codigo_documento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE documentos_entregados_codigo_documento_seq OWNED BY documento_entregado.codigo_documento_entregado;


--
-- TOC entry 1980 (class 1259 OID 51922)
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
-- TOC entry 1981 (class 1259 OID 51925)
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
-- TOC entry 1982 (class 1259 OID 51931)
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
-- TOC entry 1983 (class 1259 OID 51937)
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
-- TOC entry 1984 (class 1259 OID 51943)
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
-- TOC entry 1985 (class 1259 OID 51949)
-- Dependencies: 6 1984
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
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 1985
-- Name: equipo_codigo_equipo_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipo_codigo_equipo_seq_1 OWNED BY equipo.codigo_equipo;


--
-- TOC entry 1986 (class 1259 OID 51951)
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
-- TOC entry 1987 (class 1259 OID 51957)
-- Dependencies: 1986 6
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
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 1987
-- Name: equipo_competencia_codigo_equipo_competencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipo_competencia_codigo_equipo_competencia_seq OWNED BY equipo_competencia.codigo_equipo_competencia;


--
-- TOC entry 1988 (class 1259 OID 51959)
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
-- TOC entry 1989 (class 1259 OID 51962)
-- Dependencies: 6 1988
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
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 1989
-- Name: equipo_juego_codigo_equipo_juego_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE equipo_juego_codigo_equipo_juego_seq OWNED BY equipo_juego.codigo_equipo_juego;


--
-- TOC entry 1990 (class 1259 OID 51964)
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
-- TOC entry 1991 (class 1259 OID 51970)
-- Dependencies: 6 1990
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
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 1991
-- Name: escala_medicion_codigo_escala_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE escala_medicion_codigo_escala_seq_1 OWNED BY escala_medicion.codigo_escala;


--
-- TOC entry 1992 (class 1259 OID 51972)
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
-- TOC entry 1993 (class 1259 OID 51978)
-- Dependencies: 1992 6
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
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 1993
-- Name: estadio_codigo_estadio_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE estadio_codigo_estadio_seq_1 OWNED BY estadio.codigo_estadio;


--
-- TOC entry 1994 (class 1259 OID 51980)
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
-- TOC entry 1995 (class 1259 OID 51983)
-- Dependencies: 6
-- Name: familiar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE familiar (
    cedula_familiar character varying NOT NULL,
    codigo_profesion integer NOT NULL
);


ALTER TABLE public.familiar OWNER TO postgres;

--
-- TOC entry 1996 (class 1259 OID 51989)
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
-- TOC entry 1997 (class 1259 OID 51992)
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
-- TOC entry 1998 (class 1259 OID 51998)
-- Dependencies: 1997 6
-- Name: familiar_jugador_codigo_familiar_jugador_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE familiar_jugador_codigo_familiar_jugador_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.familiar_jugador_codigo_familiar_jugador_seq1 OWNER TO postgres;

--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 1998
-- Name: familiar_jugador_codigo_familiar_jugador_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE familiar_jugador_codigo_familiar_jugador_seq1 OWNED BY familiar_jugador.codigo_familiar_jugador;


--
-- TOC entry 1999 (class 1259 OID 52000)
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
-- TOC entry 2000 (class 1259 OID 52003)
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
-- TOC entry 2001 (class 1259 OID 52006)
-- Dependencies: 6 2000
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
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 2001
-- Name: horario_codigo_horario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE horario_codigo_horario_seq OWNED BY horario.codigo_horario;


--
-- TOC entry 2002 (class 1259 OID 52008)
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
-- TOC entry 2003 (class 1259 OID 52011)
-- Dependencies: 6 2002
-- Name: hospedaje_codigo_hospedaje_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hospedaje_codigo_hospedaje_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hospedaje_codigo_hospedaje_seq1 OWNER TO postgres;

--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 2003
-- Name: hospedaje_codigo_hospedaje_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hospedaje_codigo_hospedaje_seq1 OWNED BY hospedaje.codigo_hospedaje;


--
-- TOC entry 2004 (class 1259 OID 52013)
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
-- TOC entry 2005 (class 1259 OID 52019)
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
-- TOC entry 2006 (class 1259 OID 52022)
-- Dependencies: 6 2005
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
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 2006
-- Name: indicador_actividad_escala_codigo_indicador_actividad_escala21; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_actividad_escala_codigo_indicador_actividad_escala21 OWNED BY indicador_actividad_escala.codigo_indicador_actividad_escala;


--
-- TOC entry 2007 (class 1259 OID 52024)
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
-- TOC entry 2008 (class 1259 OID 52027)
-- Dependencies: 6 2007
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
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 2008
-- Name: indicador_categoria_competencia_codigo_indicador_competencia77; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_categoria_competencia_codigo_indicador_competencia77 OWNED BY indicador_categoria_competencia.codigo_indicador_competencia;


--
-- TOC entry 2009 (class 1259 OID 52029)
-- Dependencies: 2004 6
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
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 2009
-- Name: indicador_codigo_indicador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_codigo_indicador_seq OWNED BY indicador.codigo_indicador;


--
-- TOC entry 2010 (class 1259 OID 52031)
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
-- TOC entry 2011 (class 1259 OID 52034)
-- Dependencies: 6 2010
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
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 2011
-- Name: indicador_test_codigo_indicador_test_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_test_codigo_indicador_test_seq OWNED BY indicador_test.codigo_indicador_test;


--
-- TOC entry 2012 (class 1259 OID 52036)
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
-- TOC entry 2013 (class 1259 OID 52042)
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
-- TOC entry 2014 (class 1259 OID 52048)
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
-- TOC entry 2015 (class 1259 OID 52054)
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
-- TOC entry 2016 (class 1259 OID 52060)
-- Dependencies: 6 2015
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
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 2016
-- Name: instalacion_codigo_instalacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE instalacion_codigo_instalacion_seq OWNED BY instalacion.codigo_instalacion;


--
-- TOC entry 2017 (class 1259 OID 52062)
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
-- TOC entry 2018 (class 1259 OID 52068)
-- Dependencies: 2017 6
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
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 2018
-- Name: institucion_codigo_institucion_seq_1_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE institucion_codigo_institucion_seq_1_1 OWNED BY institucion.codigo_institucion;


--
-- TOC entry 2019 (class 1259 OID 52070)
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
-- TOC entry 2020 (class 1259 OID 52076)
-- Dependencies: 2019 6
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
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 2020
-- Name: juego_codigo_juego_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE juego_codigo_juego_seq_1 OWNED BY juego.codigo_juego;


--
-- TOC entry 2021 (class 1259 OID 52078)
-- Dependencies: 6
-- Name: jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE jugador (
    cedula_rif character varying NOT NULL,
    codigo_pais integer,
    codigo_parroquia_nacimiento integer,
    numero integer NOT NULL,
    tipo_de_sangre character varying NOT NULL,
    peso double precision,
    altura double precision,
    brazo_lanzar character varying NOT NULL,
    posicion_bateo character varying NOT NULL
);


ALTER TABLE public.jugador OWNER TO postgres;

--
-- TOC entry 2022 (class 1259 OID 52084)
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
-- TOC entry 2023 (class 1259 OID 52090)
-- Dependencies: 2022 6
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
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 2023
-- Name: jugador_foraneo_cedula_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE jugador_foraneo_cedula_seq OWNED BY jugador_foraneo.cedula;


--
-- TOC entry 2024 (class 1259 OID 52092)
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
-- TOC entry 2025 (class 1259 OID 52098)
-- Dependencies: 6 2024
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
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 2025
-- Name: lapso_deportivo_codigo_lapso_deportivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE lapso_deportivo_codigo_lapso_deportivo_seq OWNED BY lapso_deportivo.codigo_lapso_deportivo;


--
-- TOC entry 2026 (class 1259 OID 52100)
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
-- TOC entry 2027 (class 1259 OID 52106)
-- Dependencies: 6
-- Name: liga_categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE liga_categoria (
    codigo_liga integer NOT NULL,
    codigo_categoria integer NOT NULL
);


ALTER TABLE public.liga_categoria OWNER TO postgres;

--
-- TOC entry 2028 (class 1259 OID 52109)
-- Dependencies: 2026 6
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
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 2028
-- Name: liga_codigo_liga_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE liga_codigo_liga_seq OWNED BY liga.codigo_liga;


--
-- TOC entry 2029 (class 1259 OID 52111)
-- Dependencies: 6
-- Name: liga_competencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE liga_competencia (
    codigo_liga integer NOT NULL,
    codigo_competencia integer NOT NULL
);


ALTER TABLE public.liga_competencia OWNER TO postgres;

--
-- TOC entry 2030 (class 1259 OID 52114)
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
-- TOC entry 2031 (class 1259 OID 52117)
-- Dependencies: 2030 6
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
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 2031
-- Name: line_up_codigo_line_up_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE line_up_codigo_line_up_seq OWNED BY line_up.codigo_line_up;


--
-- TOC entry 2032 (class 1259 OID 52119)
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
-- TOC entry 2033 (class 1259 OID 52125)
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
-- TOC entry 2034 (class 1259 OID 52131)
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
-- TOC entry 2035 (class 1259 OID 52137)
-- Dependencies: 2034 6
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
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 2035
-- Name: material_actividad_codigo_material_actividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE material_actividad_codigo_material_actividad_seq OWNED BY material_actividad.codigo_material_actividad;


--
-- TOC entry 2036 (class 1259 OID 52139)
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
-- TOC entry 2037 (class 1259 OID 52142)
-- Dependencies: 2033 6
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
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 2037
-- Name: material_codigo_material_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE material_codigo_material_seq OWNED BY material.codigo_material;


--
-- TOC entry 2038 (class 1259 OID 52144)
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
-- TOC entry 2039 (class 1259 OID 52150)
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
-- TOC entry 2040 (class 1259 OID 52156)
-- Dependencies: 2039 6
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
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 2040
-- Name: modalidad_competencia_codigo_modalidad_competencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE modalidad_competencia_codigo_modalidad_competencia_seq OWNED BY modalidad_competencia.codigo_modalidad_competencia;


--
-- TOC entry 2041 (class 1259 OID 52158)
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
-- TOC entry 2042 (class 1259 OID 52161)
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
-- TOC entry 2043 (class 1259 OID 52167)
-- Dependencies: 2042 6
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
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 2043
-- Name: movimiento_codigo_movimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE movimiento_codigo_movimiento_seq OWNED BY movimiento.codigo_movimiento;


--
-- TOC entry 2044 (class 1259 OID 52169)
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
-- TOC entry 2045 (class 1259 OID 52175)
-- Dependencies: 2044 6
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
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 2045
-- Name: nomina_codigo_nomina_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE nomina_codigo_nomina_seq_1 OWNED BY nomina.codigo_nomina;


--
-- TOC entry 2046 (class 1259 OID 52177)
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
-- TOC entry 2047 (class 1259 OID 52183)
-- Dependencies: 2046 6
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
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 2047
-- Name: nota_entrega_codigo_nota_entrega_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE nota_entrega_codigo_nota_entrega_seq_1 OWNED BY nota_entrega.codigo_nota_entrega;


--
-- TOC entry 2048 (class 1259 OID 52185)
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
-- TOC entry 2049 (class 1259 OID 52191)
-- Dependencies: 6 2048
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
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 2049
-- Name: periodicidad_codigo_periodicidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE periodicidad_codigo_periodicidad_seq OWNED BY periodicidad.codigo_periodicidad;


--
-- TOC entry 2050 (class 1259 OID 52193)
-- Dependencies: 6
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
    cedula_rif character varying NOT NULL,
    codigo_tipo_persona integer NOT NULL,
    codigo_parroquia integer NOT NULL,
    telefono_habitacion character varying,
    fecha_ingreso date NOT NULL,
    correo_electronico character varying,
    twitter character varying,
    direccion character varying NOT NULL,
    fecha_egreso date,
    estatus character(1) NOT NULL
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 2051 (class 1259 OID 52199)
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
-- TOC entry 2052 (class 1259 OID 52205)
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
-- TOC entry 2053 (class 1259 OID 52211)
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
-- TOC entry 2054 (class 1259 OID 52217)
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
-- TOC entry 2055 (class 1259 OID 52223)
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
-- TOC entry 2056 (class 1259 OID 52229)
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
-- TOC entry 2057 (class 1259 OID 52235)
-- Dependencies: 6 2056
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
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 2057
-- Name: personal_cargo_codigo_personal_cargo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_cargo_codigo_personal_cargo_seq OWNED BY personal_cargo.codigo_personal_cargo;


--
-- TOC entry 2058 (class 1259 OID 52237)
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
-- TOC entry 2059 (class 1259 OID 52243)
-- Dependencies: 2058 6
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
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 2059
-- Name: personal_concepto_nomina_codigo_personal_concepto_nomina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_concepto_nomina_codigo_personal_concepto_nomina_seq OWNED BY personal_concepto_nomina.codigo_personal_concepto_nomina;


--
-- TOC entry 2060 (class 1259 OID 52245)
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
-- TOC entry 2061 (class 1259 OID 52251)
-- Dependencies: 2060 6
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
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 2061
-- Name: personal_contrato_codigo_personal_contrato_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_contrato_codigo_personal_contrato_seq OWNED BY personal_contrato.codigo_personal_contrato;


--
-- TOC entry 2062 (class 1259 OID 52253)
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
-- TOC entry 2063 (class 1259 OID 52259)
-- Dependencies: 2062 6
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
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 2063
-- Name: personal_equipo_codigo_personal_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_equipo_codigo_personal_equipo_seq OWNED BY personal_equipo.codigo_personal_equipo;


--
-- TOC entry 2064 (class 1259 OID 52261)
-- Dependencies: 6
-- Name: personal_equipo_juego; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal_equipo_juego (
    codigo_equipo_juego integer NOT NULL,
    codigo_personal_equipo integer NOT NULL
);


ALTER TABLE public.personal_equipo_juego OWNER TO postgres;

--
-- TOC entry 2065 (class 1259 OID 52264)
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
-- TOC entry 2066 (class 1259 OID 52270)
-- Dependencies: 2065 6
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
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 2066
-- Name: personal_foraneo_codigo_personal_foraneo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_foraneo_codigo_personal_foraneo_seq OWNED BY personal_foraneo.codigo_personal_foraneo;


--
-- TOC entry 2067 (class 1259 OID 52272)
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
-- TOC entry 2068 (class 1259 OID 52275)
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
-- TOC entry 2069 (class 1259 OID 52281)
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
-- TOC entry 2070 (class 1259 OID 52287)
-- Dependencies: 2069 6
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
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 2070
-- Name: personal_tipo_nomina_codigo_personal_tipo_nomina_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_tipo_nomina_codigo_personal_tipo_nomina_seq OWNED BY personal_tipo_nomina.codigo_personal_tipo_nomina;


--
-- TOC entry 2071 (class 1259 OID 52289)
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
-- TOC entry 2072 (class 1259 OID 52292)
-- Dependencies: 2071 6
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
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 2072
-- Name: plan_entrenamiento_codigo_plan_entrenamiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE plan_entrenamiento_codigo_plan_entrenamiento_seq OWNED BY plan_entrenamiento.codigo_plan_entrenamiento;


--
-- TOC entry 2073 (class 1259 OID 52294)
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
-- TOC entry 2074 (class 1259 OID 52297)
-- Dependencies: 2073 6
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
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 2074
-- Name: plan_rotacion_codigo_plan_rotacion_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE plan_rotacion_codigo_plan_rotacion_seq_1 OWNED BY plan_rotacion.codigo_plan_rotacion;


--
-- TOC entry 2075 (class 1259 OID 52299)
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
-- TOC entry 2076 (class 1259 OID 52302)
-- Dependencies: 6 2075
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
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 2076
-- Name: plan_temporada_codigo_plan_temporada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE plan_temporada_codigo_plan_temporada_seq OWNED BY plan_temporada.codigo_plan_temporada;


--
-- TOC entry 2077 (class 1259 OID 52304)
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
-- TOC entry 2078 (class 1259 OID 52307)
-- Dependencies: 6 2077
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
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 2078
-- Name: planificacion_actividad_codigo_planificacion_actividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE planificacion_actividad_codigo_planificacion_actividad_seq OWNED BY planificacion_actividad.codigo_planificacion_actividad;


--
-- TOC entry 2079 (class 1259 OID 52309)
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
-- TOC entry 2080 (class 1259 OID 52315)
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
-- TOC entry 2081 (class 1259 OID 52318)
-- Dependencies: 6 2080
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
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 2081
-- Name: recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1 OWNED BY recaudo_por_proceso.codigo_recaudo_por_proceso;


--
-- TOC entry 2082 (class 1259 OID 52320)
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
-- TOC entry 2083 (class 1259 OID 52326)
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
-- TOC entry 2084 (class 1259 OID 52332)
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
-- TOC entry 2085 (class 1259 OID 52338)
-- Dependencies: 6 2084
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
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 2085
-- Name: requisicion_codigo_requisicion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE requisicion_codigo_requisicion_seq OWNED BY requisicion.codigo_requisicion;


--
-- TOC entry 2086 (class 1259 OID 52340)
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
-- TOC entry 2087 (class 1259 OID 52346)
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
-- TOC entry 2088 (class 1259 OID 52352)
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
-- TOC entry 2089 (class 1259 OID 52358)
-- Dependencies: 2088 6
-- Name: roster_codigo_roster_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE roster_codigo_roster_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roster_codigo_roster_seq1 OWNER TO postgres;

--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 2089
-- Name: roster_codigo_roster_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roster_codigo_roster_seq1 OWNED BY roster.codigo_roster;


--
-- TOC entry 2090 (class 1259 OID 52360)
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
-- TOC entry 2091 (class 1259 OID 52363)
-- Dependencies: 2090 6
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
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 2091
-- Name: roster_competencia_codigo_roster_competencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roster_competencia_codigo_roster_competencia_seq_1 OWNED BY roster_competencia.codigo_roster_competencia;


--
-- TOC entry 2092 (class 1259 OID 52365)
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
-- TOC entry 2093 (class 1259 OID 52371)
-- Dependencies: 2092 6
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
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 2093
-- Name: seguridad_funcional_codigo_seguridad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE seguridad_funcional_codigo_seguridad_seq OWNED BY seguridad_funcional.codigo_seguridad;


--
-- TOC entry 2094 (class 1259 OID 52373)
-- Dependencies: 1955 6
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
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 2094
-- Name: sesion_codigo_sesion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sesion_codigo_sesion_seq OWNED BY sesion.codigo_sesion;


--
-- TOC entry 2095 (class 1259 OID 52375)
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
-- TOC entry 2096 (class 1259 OID 52378)
-- Dependencies: 2095 6
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
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 2096
-- Name: sesion_ejecutada_codigo_sesion_ejecutada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sesion_ejecutada_codigo_sesion_ejecutada_seq OWNED BY sesion_ejecutada.codigo_sesion_ejecutada;


--
-- TOC entry 2097 (class 1259 OID 52380)
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
-- TOC entry 2098 (class 1259 OID 52383)
-- Dependencies: 6 2097
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
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 2098
-- Name: solicitud_mantenimiento_codigo_solicitud_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE solicitud_mantenimiento_codigo_solicitud_seq_1 OWNED BY solicitud_mantenimiento.codigo_solicitud;


--
-- TOC entry 2099 (class 1259 OID 52385)
-- Dependencies: 6
-- Name: talla_por_indumentaria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE talla_por_indumentaria (
    codigo_talla_indumentaria integer NOT NULL,
    codigo_talla integer NOT NULL,
    codigo_indumentaria integer NOT NULL,
    precio real NOT NULL,
    estatus character(1) NOT NULL
);


ALTER TABLE public.talla_por_indumentaria OWNER TO postgres;

--
-- TOC entry 2100 (class 1259 OID 52388)
-- Dependencies: 6 2099
-- Name: talla_por_indumentaria_codigo_talla_indumentaria_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE talla_por_indumentaria_codigo_talla_indumentaria_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.talla_por_indumentaria_codigo_talla_indumentaria_seq1 OWNER TO postgres;

--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 2100
-- Name: talla_por_indumentaria_codigo_talla_indumentaria_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE talla_por_indumentaria_codigo_talla_indumentaria_seq1 OWNED BY talla_por_indumentaria.codigo_talla_indumentaria;


--
-- TOC entry 2101 (class 1259 OID 52390)
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
-- TOC entry 2102 (class 1259 OID 52396)
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
-- TOC entry 2103 (class 1259 OID 52402)
-- Dependencies: 2102 6
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
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 2103
-- Name: tarea_actividad_codigo_tarea_actividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarea_actividad_codigo_tarea_actividad_seq OWNED BY tarea_actividad.codigo_tarea_actividad;


--
-- TOC entry 2104 (class 1259 OID 52404)
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
-- TOC entry 2105 (class 1259 OID 52410)
-- Dependencies: 2104 6
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
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 2105
-- Name: tarea_actividad_planificada_codigo_personal_actividad_planif18; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tarea_actividad_planificada_codigo_personal_actividad_planif18 OWNED BY tarea_actividad_planificada.codigo_personal_actividad_planificada;


--
-- TOC entry 2106 (class 1259 OID 52412)
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
-- TOC entry 2107 (class 1259 OID 52415)
-- Dependencies: 2106 6
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
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 2107
-- Name: test_evaluativo_codigo_test_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE test_evaluativo_codigo_test_seq OWNED BY test_evaluativo.codigo_test;


--
-- TOC entry 2108 (class 1259 OID 52417)
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
-- TOC entry 2109 (class 1259 OID 52423)
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
-- TOC entry 2110 (class 1259 OID 52429)
-- Dependencies: 2109 6
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
-- TOC entry 3073 (class 0 OID 0)
-- Dependencies: 2110
-- Name: tipo_competencia_codigo_tipo_competencia_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_competencia_codigo_tipo_competencia_seq_1 OWNED BY tipo_competencia.codigo_tipo_competencia;


--
-- TOC entry 2111 (class 1259 OID 52431)
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
-- TOC entry 2112 (class 1259 OID 52437)
-- Dependencies: 6 2111
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
-- TOC entry 3074 (class 0 OID 0)
-- Dependencies: 2112
-- Name: tipo_dato_codigo_tipo_dato_seq_1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_dato_codigo_tipo_dato_seq_1 OWNED BY tipo_dato.codigo_tipo_dato;


--
-- TOC entry 2113 (class 1259 OID 52439)
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
-- TOC entry 2114 (class 1259 OID 52445)
-- Dependencies: 2113 6
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
-- TOC entry 3075 (class 0 OID 0)
-- Dependencies: 2114
-- Name: tipo_pago_representante_codigo_tipo_pago_representante_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_pago_representante_codigo_tipo_pago_representante_seq OWNED BY tipo_pago_representante.codigo_tipo_pago_representante;


--
-- TOC entry 2115 (class 1259 OID 52447)
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
-- TOC entry 2116 (class 1259 OID 52453)
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
-- TOC entry 2117 (class 1259 OID 52459)
-- Dependencies: 2116 6
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
-- TOC entry 3076 (class 0 OID 0)
-- Dependencies: 2117
-- Name: valor_escala_codigo_valor_escala_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE valor_escala_codigo_valor_escala_seq OWNED BY valor_escala.codigo_valor_escala;


--
-- TOC entry 2395 (class 2604 OID 52461)
-- Dependencies: 1917 1914
-- Name: codigo_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividad ALTER COLUMN codigo_actividad SET DEFAULT nextval('actividad_codigo_actividad_seq_6_1_1'::regclass);


--
-- TOC entry 2396 (class 2604 OID 52462)
-- Dependencies: 1916 1915
-- Name: codigo_actividad_calendario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividad_calendario ALTER COLUMN codigo_actividad_calendario SET DEFAULT nextval('actividad_calendario_codigo_actividad_calendario_seq'::regclass);


--
-- TOC entry 2397 (class 2604 OID 52463)
-- Dependencies: 1919 1918
-- Name: cod_actividad_entrenamiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividad_entrenamiento ALTER COLUMN cod_actividad_entrenamiento SET DEFAULT nextval('actividad_entrenamiento_cod_actividad_entrenamiento_seq'::regclass);


--
-- TOC entry 2398 (class 2604 OID 52464)
-- Dependencies: 1922 1921
-- Name: codigo_actividad_ejecutada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE actividades_ejecutadas ALTER COLUMN codigo_actividad_ejecutada SET DEFAULT nextval('actividades_ejecutadas_codigo_actividad_ejecutada_seq'::regclass);


--
-- TOC entry 2399 (class 2604 OID 52465)
-- Dependencies: 1926 1925
-- Name: codigo_almacen; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE almacen ALTER COLUMN codigo_almacen SET DEFAULT nextval('almacen_codigo_almacen_seq_1'::regclass);


--
-- TOC entry 2400 (class 2604 OID 52466)
-- Dependencies: 1928 1927
-- Name: codigo_ascenso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ascenso ALTER COLUMN codigo_ascenso SET DEFAULT nextval('ascenso_codigo_ascenso_seq1'::regclass);


--
-- TOC entry 2401 (class 2604 OID 52467)
-- Dependencies: 1930 1929
-- Name: codigo_asistencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE asistencia_jugador ALTER COLUMN codigo_asistencia SET DEFAULT nextval('asistencia_jugador_codigo_asistencia_seq_1'::regclass);


--
-- TOC entry 2402 (class 2604 OID 52468)
-- Dependencies: 1933 1932
-- Name: codigo_categoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE categoria ALTER COLUMN codigo_categoria SET DEFAULT nextval('categoria_codigo_categoria_seq_1'::regclass);


--
-- TOC entry 2403 (class 2604 OID 52469)
-- Dependencies: 1937 1936
-- Name: codigo_comision_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE comision_equipo ALTER COLUMN codigo_comision_equipo SET DEFAULT nextval('comision_equipo_codigo_comision_equipo_seq_1_1'::regclass);


--
-- TOC entry 2404 (class 2604 OID 52470)
-- Dependencies: 1939 1938
-- Name: codigo_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE competencia ALTER COLUMN codigo_competencia SET DEFAULT nextval('competencia_codigo_competencia_seq_1'::regclass);


--
-- TOC entry 2405 (class 2604 OID 52471)
-- Dependencies: 1941 1940
-- Name: codigo_concepto_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE concepto_nomina ALTER COLUMN codigo_concepto_nomina SET DEFAULT nextval('concepto_nomina_codigo_concepto_nomina_seq'::regclass);


--
-- TOC entry 2406 (class 2604 OID 52472)
-- Dependencies: 1946 1943
-- Name: codigo_constante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE constante ALTER COLUMN codigo_constante SET DEFAULT nextval('constante_codigo_constante_seq_1'::regclass);


--
-- TOC entry 2407 (class 2604 OID 52473)
-- Dependencies: 1945 1944
-- Name: codigo_constante_categoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE constante_categoria ALTER COLUMN codigo_constante_categoria SET DEFAULT nextval('constante_categoria_codigo_constante_categoria_seq'::regclass);


--
-- TOC entry 2408 (class 2604 OID 52474)
-- Dependencies: 1950 1949
-- Name: codigo_academico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_academico ALTER COLUMN codigo_academico SET DEFAULT nextval('dato_academico_codigo_academico_seq1'::regclass);


--
-- TOC entry 2409 (class 2604 OID 52475)
-- Dependencies: 1952 1951
-- Name: codigo_dato_academico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_academico_personal ALTER COLUMN codigo_dato_academico SET DEFAULT nextval('dato_academico_personal_codigo_dato_academico_seq'::regclass);


--
-- TOC entry 2410 (class 2604 OID 52476)
-- Dependencies: 1954 1953
-- Name: codigo_dato_basico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_basico ALTER COLUMN codigo_dato_basico SET DEFAULT nextval('dato_basico_codigo_dato_basico_seq_2_5'::regclass);


--
-- TOC entry 2413 (class 2604 OID 52477)
-- Dependencies: 1958 1957
-- Name: codigo_dato_conducta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_conducta ALTER COLUMN codigo_dato_conducta SET DEFAULT nextval('dato_conducta_codigo_dato_conducta_seq1'::regclass);


--
-- TOC entry 2414 (class 2604 OID 52478)
-- Dependencies: 1961 1960
-- Name: codigo_dato_medico; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_medico ALTER COLUMN codigo_dato_medico SET DEFAULT nextval('dato_medico_codigo_dato_medico_seq1'::regclass);


--
-- TOC entry 2415 (class 2604 OID 52479)
-- Dependencies: 1963 1962
-- Name: codigo_dato_social; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE dato_social ALTER COLUMN codigo_dato_social SET DEFAULT nextval('dato_social_codigo_dato_social_seq1'::regclass);


--
-- TOC entry 2416 (class 2604 OID 52480)
-- Dependencies: 1969 1968
-- Name: codigo_divisa; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE divisa ALTER COLUMN codigo_divisa SET DEFAULT nextval('divisa_codigo_divisa_seq_2'::regclass);


--
-- TOC entry 2417 (class 2604 OID 52481)
-- Dependencies: 1972 1971
-- Name: codigo_documento_acreedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE documento_acreedor ALTER COLUMN codigo_documento_acreedor SET DEFAULT nextval('documento_acreedor_codigo_documento_acreedor_seq_3_1'::regclass);


--
-- TOC entry 2418 (class 2604 OID 52482)
-- Dependencies: 1979 1976
-- Name: codigo_documento_entregado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE documento_entregado ALTER COLUMN codigo_documento_entregado SET DEFAULT nextval('documentos_entregados_codigo_documento_seq'::regclass);


--
-- TOC entry 2419 (class 2604 OID 52483)
-- Dependencies: 1985 1984
-- Name: codigo_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE equipo ALTER COLUMN codigo_equipo SET DEFAULT nextval('equipo_codigo_equipo_seq_1'::regclass);


--
-- TOC entry 2420 (class 2604 OID 52484)
-- Dependencies: 1987 1986
-- Name: codigo_equipo_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE equipo_competencia ALTER COLUMN codigo_equipo_competencia SET DEFAULT nextval('equipo_competencia_codigo_equipo_competencia_seq'::regclass);


--
-- TOC entry 2421 (class 2604 OID 52485)
-- Dependencies: 1989 1988
-- Name: codigo_equipo_juego; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE equipo_juego ALTER COLUMN codigo_equipo_juego SET DEFAULT nextval('equipo_juego_codigo_equipo_juego_seq'::regclass);


--
-- TOC entry 2422 (class 2604 OID 52486)
-- Dependencies: 1991 1990
-- Name: codigo_escala; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE escala_medicion ALTER COLUMN codigo_escala SET DEFAULT nextval('escala_medicion_codigo_escala_seq_1'::regclass);


--
-- TOC entry 2423 (class 2604 OID 52487)
-- Dependencies: 1993 1992
-- Name: codigo_estadio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE estadio ALTER COLUMN codigo_estadio SET DEFAULT nextval('estadio_codigo_estadio_seq_1'::regclass);


--
-- TOC entry 2424 (class 2604 OID 52488)
-- Dependencies: 1998 1997
-- Name: codigo_familiar_jugador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE familiar_jugador ALTER COLUMN codigo_familiar_jugador SET DEFAULT nextval('familiar_jugador_codigo_familiar_jugador_seq1'::regclass);


--
-- TOC entry 2425 (class 2604 OID 52489)
-- Dependencies: 2001 2000
-- Name: codigo_horario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE horario ALTER COLUMN codigo_horario SET DEFAULT nextval('horario_codigo_horario_seq'::regclass);


--
-- TOC entry 2426 (class 2604 OID 52490)
-- Dependencies: 2003 2002
-- Name: codigo_hospedaje; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE hospedaje ALTER COLUMN codigo_hospedaje SET DEFAULT nextval('hospedaje_codigo_hospedaje_seq1'::regclass);


--
-- TOC entry 2427 (class 2604 OID 52491)
-- Dependencies: 2009 2004
-- Name: codigo_indicador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador ALTER COLUMN codigo_indicador SET DEFAULT nextval('indicador_codigo_indicador_seq'::regclass);


--
-- TOC entry 2428 (class 2604 OID 52492)
-- Dependencies: 2006 2005
-- Name: codigo_indicador_actividad_escala; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador_actividad_escala ALTER COLUMN codigo_indicador_actividad_escala SET DEFAULT nextval('indicador_actividad_escala_codigo_indicador_actividad_escala21'::regclass);


--
-- TOC entry 2429 (class 2604 OID 52493)
-- Dependencies: 2008 2007
-- Name: codigo_indicador_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador_categoria_competencia ALTER COLUMN codigo_indicador_competencia SET DEFAULT nextval('indicador_categoria_competencia_codigo_indicador_competencia77'::regclass);


--
-- TOC entry 2430 (class 2604 OID 52494)
-- Dependencies: 2011 2010
-- Name: codigo_indicador_test; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE indicador_test ALTER COLUMN codigo_indicador_test SET DEFAULT nextval('indicador_test_codigo_indicador_test_seq'::regclass);


--
-- TOC entry 2431 (class 2604 OID 52495)
-- Dependencies: 2016 2015
-- Name: codigo_instalacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE instalacion ALTER COLUMN codigo_instalacion SET DEFAULT nextval('instalacion_codigo_instalacion_seq'::regclass);


--
-- TOC entry 2432 (class 2604 OID 52496)
-- Dependencies: 2018 2017
-- Name: codigo_institucion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE institucion ALTER COLUMN codigo_institucion SET DEFAULT nextval('institucion_codigo_institucion_seq_1_1'::regclass);


--
-- TOC entry 2433 (class 2604 OID 52497)
-- Dependencies: 2020 2019
-- Name: codigo_juego; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE juego ALTER COLUMN codigo_juego SET DEFAULT nextval('juego_codigo_juego_seq_1'::regclass);


--
-- TOC entry 2434 (class 2604 OID 52498)
-- Dependencies: 2023 2022
-- Name: cedula; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE jugador_foraneo ALTER COLUMN cedula SET DEFAULT nextval('jugador_foraneo_cedula_seq'::regclass);


--
-- TOC entry 2435 (class 2604 OID 52499)
-- Dependencies: 2025 2024
-- Name: codigo_lapso_deportivo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE lapso_deportivo ALTER COLUMN codigo_lapso_deportivo SET DEFAULT nextval('lapso_deportivo_codigo_lapso_deportivo_seq'::regclass);


--
-- TOC entry 2436 (class 2604 OID 52500)
-- Dependencies: 2028 2026
-- Name: codigo_liga; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE liga ALTER COLUMN codigo_liga SET DEFAULT nextval('liga_codigo_liga_seq'::regclass);


--
-- TOC entry 2437 (class 2604 OID 52501)
-- Dependencies: 2031 2030
-- Name: codigo_line_up; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE line_up ALTER COLUMN codigo_line_up SET DEFAULT nextval('line_up_codigo_line_up_seq'::regclass);


--
-- TOC entry 2438 (class 2604 OID 52502)
-- Dependencies: 2037 2033
-- Name: codigo_material; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE material ALTER COLUMN codigo_material SET DEFAULT nextval('material_codigo_material_seq'::regclass);


--
-- TOC entry 2439 (class 2604 OID 52503)
-- Dependencies: 2035 2034
-- Name: codigo_material_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE material_actividad ALTER COLUMN codigo_material_actividad SET DEFAULT nextval('material_actividad_codigo_material_actividad_seq'::regclass);


--
-- TOC entry 2440 (class 2604 OID 52504)
-- Dependencies: 2040 2039
-- Name: codigo_modalidad_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE modalidad_competencia ALTER COLUMN codigo_modalidad_competencia SET DEFAULT nextval('modalidad_competencia_codigo_modalidad_competencia_seq'::regclass);


--
-- TOC entry 2441 (class 2604 OID 52505)
-- Dependencies: 2043 2042
-- Name: codigo_movimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE movimiento ALTER COLUMN codigo_movimiento SET DEFAULT nextval('movimiento_codigo_movimiento_seq'::regclass);


--
-- TOC entry 2442 (class 2604 OID 52506)
-- Dependencies: 2045 2044
-- Name: codigo_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE nomina ALTER COLUMN codigo_nomina SET DEFAULT nextval('nomina_codigo_nomina_seq_1'::regclass);


--
-- TOC entry 2443 (class 2604 OID 52507)
-- Dependencies: 2047 2046
-- Name: codigo_nota_entrega; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE nota_entrega ALTER COLUMN codigo_nota_entrega SET DEFAULT nextval('nota_entrega_codigo_nota_entrega_seq_1'::regclass);


--
-- TOC entry 2444 (class 2604 OID 52508)
-- Dependencies: 2049 2048
-- Name: codigo_periodicidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE periodicidad ALTER COLUMN codigo_periodicidad SET DEFAULT nextval('periodicidad_codigo_periodicidad_seq'::regclass);


--
-- TOC entry 2445 (class 2604 OID 52509)
-- Dependencies: 2057 2056
-- Name: codigo_personal_cargo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_cargo ALTER COLUMN codigo_personal_cargo SET DEFAULT nextval('personal_cargo_codigo_personal_cargo_seq'::regclass);


--
-- TOC entry 2446 (class 2604 OID 52510)
-- Dependencies: 2059 2058
-- Name: codigo_personal_concepto_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_concepto_nomina ALTER COLUMN codigo_personal_concepto_nomina SET DEFAULT nextval('personal_concepto_nomina_codigo_personal_concepto_nomina_seq'::regclass);


--
-- TOC entry 2447 (class 2604 OID 52511)
-- Dependencies: 2061 2060
-- Name: codigo_personal_contrato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_contrato ALTER COLUMN codigo_personal_contrato SET DEFAULT nextval('personal_contrato_codigo_personal_contrato_seq'::regclass);


--
-- TOC entry 2448 (class 2604 OID 52512)
-- Dependencies: 2063 2062
-- Name: codigo_personal_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_equipo ALTER COLUMN codigo_personal_equipo SET DEFAULT nextval('personal_equipo_codigo_personal_equipo_seq'::regclass);


--
-- TOC entry 2449 (class 2604 OID 52513)
-- Dependencies: 2066 2065
-- Name: codigo_personal_foraneo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_foraneo ALTER COLUMN codigo_personal_foraneo SET DEFAULT nextval('personal_foraneo_codigo_personal_foraneo_seq'::regclass);


--
-- TOC entry 2450 (class 2604 OID 52514)
-- Dependencies: 2070 2069
-- Name: codigo_personal_tipo_nomina; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE personal_tipo_nomina ALTER COLUMN codigo_personal_tipo_nomina SET DEFAULT nextval('personal_tipo_nomina_codigo_personal_tipo_nomina_seq'::regclass);


--
-- TOC entry 2451 (class 2604 OID 52515)
-- Dependencies: 2072 2071
-- Name: codigo_plan_entrenamiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE plan_entrenamiento ALTER COLUMN codigo_plan_entrenamiento SET DEFAULT nextval('plan_entrenamiento_codigo_plan_entrenamiento_seq'::regclass);


--
-- TOC entry 2452 (class 2604 OID 52516)
-- Dependencies: 2074 2073
-- Name: codigo_plan_rotacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE plan_rotacion ALTER COLUMN codigo_plan_rotacion SET DEFAULT nextval('plan_rotacion_codigo_plan_rotacion_seq_1'::regclass);


--
-- TOC entry 2453 (class 2604 OID 52517)
-- Dependencies: 2076 2075
-- Name: codigo_plan_temporada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE plan_temporada ALTER COLUMN codigo_plan_temporada SET DEFAULT nextval('plan_temporada_codigo_plan_temporada_seq'::regclass);


--
-- TOC entry 2454 (class 2604 OID 52518)
-- Dependencies: 2078 2077
-- Name: codigo_planificacion_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE planificacion_actividad ALTER COLUMN codigo_planificacion_actividad SET DEFAULT nextval('planificacion_actividad_codigo_planificacion_actividad_seq'::regclass);


--
-- TOC entry 2455 (class 2604 OID 52519)
-- Dependencies: 2081 2080
-- Name: codigo_recaudo_por_proceso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE recaudo_por_proceso ALTER COLUMN codigo_recaudo_por_proceso SET DEFAULT nextval('recaudo_por_proceso_codigo_recaudo_por_proceso_seq_1'::regclass);


--
-- TOC entry 2456 (class 2604 OID 52520)
-- Dependencies: 2085 2084
-- Name: codigo_requisicion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE requisicion ALTER COLUMN codigo_requisicion SET DEFAULT nextval('requisicion_codigo_requisicion_seq'::regclass);


--
-- TOC entry 2457 (class 2604 OID 52521)
-- Dependencies: 2089 2088
-- Name: codigo_roster; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE roster ALTER COLUMN codigo_roster SET DEFAULT nextval('roster_codigo_roster_seq1'::regclass);


--
-- TOC entry 2458 (class 2604 OID 52522)
-- Dependencies: 2091 2090
-- Name: codigo_roster_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE roster_competencia ALTER COLUMN codigo_roster_competencia SET DEFAULT nextval('roster_competencia_codigo_roster_competencia_seq_1'::regclass);


--
-- TOC entry 2459 (class 2604 OID 52523)
-- Dependencies: 2093 2092
-- Name: codigo_seguridad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE seguridad_funcional ALTER COLUMN codigo_seguridad SET DEFAULT nextval('seguridad_funcional_codigo_seguridad_seq'::regclass);


--
-- TOC entry 2411 (class 2604 OID 52524)
-- Dependencies: 2094 1955
-- Name: codigo_sesion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE sesion ALTER COLUMN codigo_sesion SET DEFAULT nextval('sesion_codigo_sesion_seq'::regclass);


--
-- TOC entry 2412 (class 2604 OID 52525)
-- Dependencies: 1956 1955
-- Name: dia_semana; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE sesion ALTER COLUMN dia_semana SET DEFAULT nextval('dato_basico_dia_semana_seq_2_11'::regclass);


--
-- TOC entry 2460 (class 2604 OID 52526)
-- Dependencies: 2096 2095
-- Name: codigo_sesion_ejecutada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE sesion_ejecutada ALTER COLUMN codigo_sesion_ejecutada SET DEFAULT nextval('sesion_ejecutada_codigo_sesion_ejecutada_seq'::regclass);


--
-- TOC entry 2461 (class 2604 OID 52527)
-- Dependencies: 2098 2097
-- Name: codigo_solicitud; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE solicitud_mantenimiento ALTER COLUMN codigo_solicitud SET DEFAULT nextval('solicitud_mantenimiento_codigo_solicitud_seq_1'::regclass);


--
-- TOC entry 2462 (class 2604 OID 52528)
-- Dependencies: 2100 2099
-- Name: codigo_talla_indumentaria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE talla_por_indumentaria ALTER COLUMN codigo_talla_indumentaria SET DEFAULT nextval('talla_por_indumentaria_codigo_talla_indumentaria_seq1'::regclass);


--
-- TOC entry 2463 (class 2604 OID 52529)
-- Dependencies: 2103 2102
-- Name: codigo_tarea_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tarea_actividad ALTER COLUMN codigo_tarea_actividad SET DEFAULT nextval('tarea_actividad_codigo_tarea_actividad_seq'::regclass);


--
-- TOC entry 2464 (class 2604 OID 52530)
-- Dependencies: 2105 2104
-- Name: codigo_personal_actividad_planificada; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tarea_actividad_planificada ALTER COLUMN codigo_personal_actividad_planificada SET DEFAULT nextval('tarea_actividad_planificada_codigo_personal_actividad_planif18'::regclass);


--
-- TOC entry 2465 (class 2604 OID 52531)
-- Dependencies: 2107 2106
-- Name: codigo_test; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE test_evaluativo ALTER COLUMN codigo_test SET DEFAULT nextval('test_evaluativo_codigo_test_seq'::regclass);


--
-- TOC entry 2466 (class 2604 OID 52532)
-- Dependencies: 2110 2109
-- Name: codigo_tipo_competencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_competencia ALTER COLUMN codigo_tipo_competencia SET DEFAULT nextval('tipo_competencia_codigo_tipo_competencia_seq_1'::regclass);


--
-- TOC entry 2467 (class 2604 OID 52533)
-- Dependencies: 2112 2111
-- Name: codigo_tipo_dato; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_dato ALTER COLUMN codigo_tipo_dato SET DEFAULT nextval('tipo_dato_codigo_tipo_dato_seq_1'::regclass);


--
-- TOC entry 2468 (class 2604 OID 52534)
-- Dependencies: 2114 2113
-- Name: codigo_tipo_pago_representante; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE tipo_pago_representante ALTER COLUMN codigo_tipo_pago_representante SET DEFAULT nextval('tipo_pago_representante_codigo_tipo_pago_representante_seq'::regclass);


--
-- TOC entry 2469 (class 2604 OID 52535)
-- Dependencies: 2117 2116
-- Name: codigo_valor_escala; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE valor_escala ALTER COLUMN codigo_valor_escala SET DEFAULT nextval('valor_escala_codigo_valor_escala_seq'::regclass);


--
-- TOC entry 2473 (class 2606 OID 52537)
-- Dependencies: 1915 1915
-- Name: actividad_calendario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT actividad_calendario_pk PRIMARY KEY (codigo_actividad_calendario);


--
-- TOC entry 2475 (class 2606 OID 52539)
-- Dependencies: 1918 1918
-- Name: actividad_entrenamiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad_entrenamiento
    ADD CONSTRAINT actividad_entrenamiento_pk PRIMARY KEY (cod_actividad_entrenamiento);


--
-- TOC entry 2471 (class 2606 OID 52541)
-- Dependencies: 1914 1914
-- Name: actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT actividad_pk PRIMARY KEY (codigo_actividad);


--
-- TOC entry 2477 (class 2606 OID 52543)
-- Dependencies: 1920 1920 1920
-- Name: actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT actividad_planificada_pk PRIMARY KEY (codigo_indicador_actividad_escala, codigo_sesion);


--
-- TOC entry 2479 (class 2606 OID 52545)
-- Dependencies: 1921 1921
-- Name: actividades_ejecutadas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividades_ejecutadas
    ADD CONSTRAINT actividades_ejecutadas_pk PRIMARY KEY (codigo_actividad_ejecutada);


--
-- TOC entry 2481 (class 2606 OID 52547)
-- Dependencies: 1923 1923 1923
-- Name: afeccion_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT afeccion_jugador_pk PRIMARY KEY (codigo_afeccion, codigo_dato_medico);


--
-- TOC entry 2483 (class 2606 OID 52549)
-- Dependencies: 1924 1924 1924
-- Name: afeccion_personal_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY afeccion_personal
    ADD CONSTRAINT afeccion_personal_pk PRIMARY KEY (cedula_rif, codigo_tipo_afeccion);


--
-- TOC entry 2485 (class 2606 OID 52551)
-- Dependencies: 1925 1925
-- Name: almacen_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY almacen
    ADD CONSTRAINT almacen_pk PRIMARY KEY (codigo_almacen);


--
-- TOC entry 2487 (class 2606 OID 52553)
-- Dependencies: 1927 1927
-- Name: ascenso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ascenso
    ADD CONSTRAINT ascenso_pk PRIMARY KEY (codigo_ascenso);


--
-- TOC entry 2489 (class 2606 OID 52555)
-- Dependencies: 1929 1929
-- Name: asistencia_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY asistencia_jugador
    ADD CONSTRAINT asistencia_jugador_pk PRIMARY KEY (codigo_asistencia);


--
-- TOC entry 2491 (class 2606 OID 52557)
-- Dependencies: 1931 1931 1931
-- Name: asistencia_personal_entrenamiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT asistencia_personal_entrenamiento_pk PRIMARY KEY (codigo_sesion_ejecutada, codigo_personal_equipo);


--
-- TOC entry 2495 (class 2606 OID 52559)
-- Dependencies: 1934 1934 1934
-- Name: categoria_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT categoria_competencia_pk PRIMARY KEY (codigo_competencia, codigo_categoria);


--
-- TOC entry 2493 (class 2606 OID 52561)
-- Dependencies: 1932 1932
-- Name: categoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY (codigo_categoria);


--
-- TOC entry 2617 (class 2606 OID 52563)
-- Dependencies: 2027 2027 2027
-- Name: codigo_liga_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY liga_categoria
    ADD CONSTRAINT codigo_liga_pk PRIMARY KEY (codigo_liga, codigo_categoria);


--
-- TOC entry 2497 (class 2606 OID 52565)
-- Dependencies: 1935 1935 1935
-- Name: comision_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comision_actividad
    ADD CONSTRAINT comision_actividad_pk PRIMARY KEY (codigo_comision, codigo_actividad);


--
-- TOC entry 2499 (class 2606 OID 52567)
-- Dependencies: 1936 1936
-- Name: comision_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT comision_equipo_pk PRIMARY KEY (codigo_comision_equipo);


--
-- TOC entry 2501 (class 2606 OID 52569)
-- Dependencies: 1938 1938
-- Name: competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT competencia_pk PRIMARY KEY (codigo_competencia);


--
-- TOC entry 2503 (class 2606 OID 52571)
-- Dependencies: 1940 1940
-- Name: concepto_nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY concepto_nomina
    ADD CONSTRAINT concepto_nomina_pk PRIMARY KEY (codigo_concepto_nomina);


--
-- TOC entry 2505 (class 2606 OID 52573)
-- Dependencies: 1942 1942 1942
-- Name: condicion_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY condicion_competencia
    ADD CONSTRAINT condicion_competencia_pk PRIMARY KEY (codigo_condicion, codigo_tipo_competencia);


--
-- TOC entry 2509 (class 2606 OID 52575)
-- Dependencies: 1944 1944 1944
-- Name: constante_categoria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY constante_categoria
    ADD CONSTRAINT constante_categoria_pk PRIMARY KEY (codigo_constante_categoria, codigo_constante);


--
-- TOC entry 2507 (class 2606 OID 52577)
-- Dependencies: 1943 1943
-- Name: constante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY constante
    ADD CONSTRAINT constante_pk PRIMARY KEY (codigo_constante);


--
-- TOC entry 2513 (class 2606 OID 52579)
-- Dependencies: 1948 1948 1948
-- Name: cuenta_pagar_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT cuenta_pagar_material_pk PRIMARY KEY (codigo_material, origen);


--
-- TOC entry 2511 (class 2606 OID 52581)
-- Dependencies: 1947 1947
-- Name: cuenta_pagar_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT cuenta_pagar_pk PRIMARY KEY (origen);


--
-- TOC entry 2517 (class 2606 OID 52583)
-- Dependencies: 1951 1951
-- Name: dato_academico_personal_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_academico_personal
    ADD CONSTRAINT dato_academico_personal_pk PRIMARY KEY (codigo_dato_academico);


--
-- TOC entry 2515 (class 2606 OID 52585)
-- Dependencies: 1949 1949
-- Name: dato_academico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_academico_pk PRIMARY KEY (codigo_academico);


--
-- TOC entry 2519 (class 2606 OID 52587)
-- Dependencies: 1953 1953
-- Name: dato_basico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT dato_basico_pk PRIMARY KEY (codigo_dato_basico);


--
-- TOC entry 2523 (class 2606 OID 52589)
-- Dependencies: 1957 1957
-- Name: dato_conducta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT dato_conducta_pk PRIMARY KEY (codigo_dato_conducta);


--
-- TOC entry 2525 (class 2606 OID 52591)
-- Dependencies: 1959 1959 1959
-- Name: dato_deportivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT dato_deportivo_pk PRIMARY KEY (codigo_competencia, cedula_rif);


--
-- TOC entry 2527 (class 2606 OID 52593)
-- Dependencies: 1960 1960
-- Name: dato_medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT dato_medico_pk PRIMARY KEY (codigo_dato_medico);


--
-- TOC entry 2529 (class 2606 OID 52595)
-- Dependencies: 1962 1962
-- Name: dato_social_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT dato_social_pk PRIMARY KEY (codigo_dato_social);


--
-- TOC entry 2531 (class 2606 OID 52597)
-- Dependencies: 1964 1964 1964
-- Name: desempenno_colectivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT desempenno_colectivo_pk PRIMARY KEY (codigo_equipo_juego, codigo_indicador_competencia);


--
-- TOC entry 2533 (class 2606 OID 52599)
-- Dependencies: 1965 1965 1965
-- Name: desempenno_individual_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desempenno_individual
    ADD CONSTRAINT desempenno_individual_pk PRIMARY KEY (codigo_indicador_competencia, codigo_line_up);


--
-- TOC entry 2535 (class 2606 OID 52601)
-- Dependencies: 1966 1966 1966
-- Name: desempeo_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT desempeo_jugador_pk PRIMARY KEY (codigo_asistencia, codigo_actividad_ejecutada);


--
-- TOC entry 2537 (class 2606 OID 52603)
-- Dependencies: 1967 1967 1967
-- Name: detalle_requisicion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_requisicion
    ADD CONSTRAINT detalle_requisicion_pk PRIMARY KEY (codigo_material, codigo_requisicion);


--
-- TOC entry 2539 (class 2606 OID 52605)
-- Dependencies: 1968 1968
-- Name: divisa_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY divisa
    ADD CONSTRAINT divisa_pk PRIMARY KEY (codigo_divisa);


--
-- TOC entry 2541 (class 2606 OID 52607)
-- Dependencies: 1970 1970 1970
-- Name: documento_academico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT documento_academico_pk PRIMARY KEY (codigo_documento_entregado, codigo_academico);


--
-- TOC entry 2545 (class 2606 OID 52609)
-- Dependencies: 1973 1973 1973
-- Name: documento_acreedor_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_acreedor_material
    ADD CONSTRAINT documento_acreedor_material_pk PRIMARY KEY (codigo_material, codigo_documento_acreedor);


--
-- TOC entry 2543 (class 2606 OID 52611)
-- Dependencies: 1971 1971
-- Name: documento_acreedor_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT documento_acreedor_pk PRIMARY KEY (codigo_documento_acreedor);


--
-- TOC entry 2547 (class 2606 OID 52613)
-- Dependencies: 1974 1974 1974
-- Name: documento_ascenso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT documento_ascenso_pk PRIMARY KEY (codigo_documento_entregado, codigo_ascenso);


--
-- TOC entry 2549 (class 2606 OID 52615)
-- Dependencies: 1975 1975 1975
-- Name: documento_conducta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT documento_conducta_pk PRIMARY KEY (codigo_documento_entregado, codigo_dato_conducta);


--
-- TOC entry 2551 (class 2606 OID 52617)
-- Dependencies: 1976 1976
-- Name: documento_entregado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_entregado
    ADD CONSTRAINT documento_entregado_pk PRIMARY KEY (codigo_documento_entregado);


--
-- TOC entry 2553 (class 2606 OID 52619)
-- Dependencies: 1977 1977 1977
-- Name: documento_indumentaria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_indumentaria
    ADD CONSTRAINT documento_indumentaria_pk PRIMARY KEY (codigo_documento_acreedor, codigo_talla_indumentaria);


--
-- TOC entry 2555 (class 2606 OID 52621)
-- Dependencies: 1978 1978 1978
-- Name: documento_medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT documento_medico_pk PRIMARY KEY (codigo_documento_entregado, codigo_dato_medico);


--
-- TOC entry 2557 (class 2606 OID 52623)
-- Dependencies: 1980 1980 1980
-- Name: donacion_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY donacion_material
    ADD CONSTRAINT donacion_material_pk PRIMARY KEY (codigo_material, codigo_documento_acreedor);


--
-- TOC entry 2561 (class 2606 OID 52625)
-- Dependencies: 1982 1982 1982
-- Name: egreso_cuenta_pagar_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY egreso_cuenta_pagar
    ADD CONSTRAINT egreso_cuenta_pagar_pk PRIMARY KEY (origen, numero_documento);


--
-- TOC entry 2563 (class 2606 OID 52627)
-- Dependencies: 1983 1983
-- Name: egreso_forma_pago_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT egreso_forma_pago_pk PRIMARY KEY (numero_documento);


--
-- TOC entry 2559 (class 2606 OID 52629)
-- Dependencies: 1981 1981
-- Name: egreso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY egreso
    ADD CONSTRAINT egreso_pk PRIMARY KEY (numero_documento);


--
-- TOC entry 2567 (class 2606 OID 52631)
-- Dependencies: 1986 1986
-- Name: equipo_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT equipo_competencia_pk PRIMARY KEY (codigo_equipo_competencia);


--
-- TOC entry 2569 (class 2606 OID 52633)
-- Dependencies: 1988 1988
-- Name: equipo_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT equipo_juego_pk PRIMARY KEY (codigo_equipo_juego);


--
-- TOC entry 2565 (class 2606 OID 52635)
-- Dependencies: 1984 1984
-- Name: equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT equipo_pk PRIMARY KEY (codigo_equipo);


--
-- TOC entry 2571 (class 2606 OID 52637)
-- Dependencies: 1990 1990
-- Name: escala_medicion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY escala_medicion
    ADD CONSTRAINT escala_medicion_pk PRIMARY KEY (codigo_escala);


--
-- TOC entry 2573 (class 2606 OID 52639)
-- Dependencies: 1992 1992
-- Name: estadio_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estadio
    ADD CONSTRAINT estadio_pk PRIMARY KEY (codigo_estadio);


--
-- TOC entry 2575 (class 2606 OID 52641)
-- Dependencies: 1994 1994 1994
-- Name: estado_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estado_actividad
    ADD CONSTRAINT estado_actividad_pk PRIMARY KEY (codigo_estado, codigo_actividad);


--
-- TOC entry 2579 (class 2606 OID 52643)
-- Dependencies: 1996 1996 1996
-- Name: familiar_comision_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT familiar_comision_equipo_pk PRIMARY KEY (codigo_comision_equipo, codigo_familiar_jugador);


--
-- TOC entry 2581 (class 2606 OID 52645)
-- Dependencies: 1997 1997
-- Name: familiar_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT familiar_jugador_pk PRIMARY KEY (codigo_familiar_jugador);


--
-- TOC entry 2577 (class 2606 OID 52647)
-- Dependencies: 1995 1995
-- Name: familiar_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT familiar_pk PRIMARY KEY (cedula_familiar);


--
-- TOC entry 2583 (class 2606 OID 52649)
-- Dependencies: 1999 1999 1999
-- Name: fase_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fase_competencia
    ADD CONSTRAINT fase_competencia_pk PRIMARY KEY (codigo_competencia, numero_fase);


--
-- TOC entry 2585 (class 2606 OID 52651)
-- Dependencies: 2000 2000
-- Name: horario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT horario_pk PRIMARY KEY (codigo_horario);


--
-- TOC entry 2587 (class 2606 OID 52653)
-- Dependencies: 2002 2002
-- Name: hospedaje_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT hospedaje_pk PRIMARY KEY (codigo_hospedaje);


--
-- TOC entry 2691 (class 2606 OID 52655)
-- Dependencies: 2084 2084
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY requisicion
    ADD CONSTRAINT id PRIMARY KEY (codigo_requisicion);


--
-- TOC entry 2591 (class 2606 OID 52657)
-- Dependencies: 2005 2005
-- Name: indicador_actividad_escala_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT indicador_actividad_escala_pk PRIMARY KEY (codigo_indicador_actividad_escala);


--
-- TOC entry 2593 (class 2606 OID 52659)
-- Dependencies: 2007 2007
-- Name: indicador_categoria_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT indicador_categoria_competencia_pk PRIMARY KEY (codigo_indicador_competencia);


--
-- TOC entry 2589 (class 2606 OID 52661)
-- Dependencies: 2004 2004
-- Name: indicador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador
    ADD CONSTRAINT indicador_pk PRIMARY KEY (codigo_indicador);


--
-- TOC entry 2595 (class 2606 OID 52663)
-- Dependencies: 2010 2010
-- Name: indicador_test_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT indicador_test_pk PRIMARY KEY (codigo_indicador_test);


--
-- TOC entry 2599 (class 2606 OID 52665)
-- Dependencies: 2013 2013 2013
-- Name: ingreso_documento_acreedor_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso_documento_acreedor
    ADD CONSTRAINT ingreso_documento_acreedor_pk PRIMARY KEY (numero_documento, codigo_documento_acreedor);


--
-- TOC entry 2601 (class 2606 OID 52667)
-- Dependencies: 2014 2014 2014
-- Name: ingreso_forma_pago_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT ingreso_forma_pago_pk PRIMARY KEY (numero_documento, codigo_forma_pago);


--
-- TOC entry 2597 (class 2606 OID 52669)
-- Dependencies: 2012 2012
-- Name: ingreso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ingreso
    ADD CONSTRAINT ingreso_pk PRIMARY KEY (numero_documento);


--
-- TOC entry 2603 (class 2606 OID 52671)
-- Dependencies: 2015 2015
-- Name: instalacion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY instalacion
    ADD CONSTRAINT instalacion_pk PRIMARY KEY (codigo_instalacion);


--
-- TOC entry 2605 (class 2606 OID 52673)
-- Dependencies: 2017 2017
-- Name: institucion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT institucion_pk PRIMARY KEY (codigo_institucion);


--
-- TOC entry 2607 (class 2606 OID 52675)
-- Dependencies: 2019 2019
-- Name: juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT juego_pk PRIMARY KEY (codigo_juego);


--
-- TOC entry 2611 (class 2606 OID 52677)
-- Dependencies: 2022 2022
-- Name: jugador_foraneo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT jugador_foraneo_pk PRIMARY KEY (cedula);


--
-- TOC entry 2609 (class 2606 OID 52679)
-- Dependencies: 2021 2021
-- Name: jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT jugador_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2613 (class 2606 OID 52681)
-- Dependencies: 2024 2024
-- Name: lapso_deportivo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY lapso_deportivo
    ADD CONSTRAINT lapso_deportivo_pk PRIMARY KEY (codigo_lapso_deportivo);


--
-- TOC entry 2619 (class 2606 OID 52683)
-- Dependencies: 2029 2029 2029
-- Name: liga_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY liga_competencia
    ADD CONSTRAINT liga_competencia_pk PRIMARY KEY (codigo_liga, codigo_competencia);


--
-- TOC entry 2615 (class 2606 OID 52685)
-- Dependencies: 2026 2026
-- Name: liga_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY liga
    ADD CONSTRAINT liga_pk PRIMARY KEY (codigo_liga);


--
-- TOC entry 2621 (class 2606 OID 52687)
-- Dependencies: 2030 2030
-- Name: line_up_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT line_up_pk PRIMARY KEY (codigo_line_up);


--
-- TOC entry 2623 (class 2606 OID 52689)
-- Dependencies: 2032 2032 2032 2032
-- Name: logro_por_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT logro_por_jugador_pk PRIMARY KEY (codigo_competencia, cedula_rif, codigo_logro);


--
-- TOC entry 2627 (class 2606 OID 52691)
-- Dependencies: 2034 2034
-- Name: material_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY material_actividad
    ADD CONSTRAINT material_actividad_pk PRIMARY KEY (codigo_material_actividad);


--
-- TOC entry 2629 (class 2606 OID 52693)
-- Dependencies: 2036 2036 2036
-- Name: material_actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY material_actividad_planificada
    ADD CONSTRAINT material_actividad_planificada_pk PRIMARY KEY (codigo_planificacion_actividad, codigo_material);


--
-- TOC entry 2625 (class 2606 OID 52695)
-- Dependencies: 2033 2033
-- Name: material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY material
    ADD CONSTRAINT material_pk PRIMARY KEY (codigo_material);


--
-- TOC entry 2631 (class 2606 OID 52697)
-- Dependencies: 2038 2038
-- Name: medico_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT medico_pk PRIMARY KEY (numero_colegio);


--
-- TOC entry 2633 (class 2606 OID 52699)
-- Dependencies: 2039 2039
-- Name: modalidad_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY modalidad_competencia
    ADD CONSTRAINT modalidad_competencia_pk PRIMARY KEY (codigo_modalidad_competencia);


--
-- TOC entry 2635 (class 2606 OID 52701)
-- Dependencies: 2041 2041 2041
-- Name: motivo_sancion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT motivo_sancion_pk PRIMARY KEY (codigo_motivo, codigo_dato_conducta);


--
-- TOC entry 2637 (class 2606 OID 52703)
-- Dependencies: 2042 2042
-- Name: movimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT movimiento_pk PRIMARY KEY (codigo_movimiento);


--
-- TOC entry 2639 (class 2606 OID 52705)
-- Dependencies: 2044 2044
-- Name: nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY nomina
    ADD CONSTRAINT nomina_pk PRIMARY KEY (codigo_nomina);


--
-- TOC entry 2641 (class 2606 OID 52707)
-- Dependencies: 2046 2046
-- Name: nota_entrega_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY nota_entrega
    ADD CONSTRAINT nota_entrega_pk PRIMARY KEY (codigo_nota_entrega);


--
-- TOC entry 2643 (class 2606 OID 52709)
-- Dependencies: 2048 2048
-- Name: periodicidad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY periodicidad
    ADD CONSTRAINT periodicidad_pk PRIMARY KEY (codigo_periodicidad);


--
-- TOC entry 2647 (class 2606 OID 52711)
-- Dependencies: 2051 2051
-- Name: persona_juridica_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona_juridica
    ADD CONSTRAINT persona_juridica_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2649 (class 2606 OID 52713)
-- Dependencies: 2052 2052
-- Name: persona_natural_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT persona_natural_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2645 (class 2606 OID 52715)
-- Dependencies: 2050 2050
-- Name: persona_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2653 (class 2606 OID 52717)
-- Dependencies: 2054 2054 2054
-- Name: personal_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_actividad
    ADD CONSTRAINT personal_actividad_pk PRIMARY KEY (cedula_rif, codigo_actividad);


--
-- TOC entry 2655 (class 2606 OID 52719)
-- Dependencies: 2055 2055 2055
-- Name: personal_actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_actividad_planificada
    ADD CONSTRAINT personal_actividad_planificada_pk PRIMARY KEY (cedula_rif, codigo_planificacion_actividad);


--
-- TOC entry 2657 (class 2606 OID 52721)
-- Dependencies: 2056 2056
-- Name: personal_cargo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_cargo
    ADD CONSTRAINT personal_cargo_pk PRIMARY KEY (codigo_personal_cargo);


--
-- TOC entry 2659 (class 2606 OID 52723)
-- Dependencies: 2058 2058
-- Name: personal_concepto_nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_concepto_nomina
    ADD CONSTRAINT personal_concepto_nomina_pk PRIMARY KEY (codigo_personal_concepto_nomina);


--
-- TOC entry 2661 (class 2606 OID 52725)
-- Dependencies: 2060 2060
-- Name: personal_contrato_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT personal_contrato_pk PRIMARY KEY (codigo_personal_contrato);


--
-- TOC entry 2665 (class 2606 OID 52727)
-- Dependencies: 2064 2064 2064
-- Name: personal_equipo_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_equipo_juego
    ADD CONSTRAINT personal_equipo_juego_pk PRIMARY KEY (codigo_equipo_juego, codigo_personal_equipo);


--
-- TOC entry 2663 (class 2606 OID 52729)
-- Dependencies: 2062 2062
-- Name: personal_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT personal_equipo_pk PRIMARY KEY (codigo_personal_equipo);


--
-- TOC entry 2669 (class 2606 OID 52731)
-- Dependencies: 2067 2067 2067
-- Name: personal_foraneo_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT personal_foraneo_juego_pk PRIMARY KEY (codigo_juego, codigo_personal_foraneo);


--
-- TOC entry 2667 (class 2606 OID 52733)
-- Dependencies: 2065 2065
-- Name: personal_foraneo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_foraneo
    ADD CONSTRAINT personal_foraneo_pk PRIMARY KEY (codigo_personal_foraneo);


--
-- TOC entry 2671 (class 2606 OID 52735)
-- Dependencies: 2068 2068 2068
-- Name: personal_juego_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT personal_juego_pk PRIMARY KEY (codigo_juego, cedula_rif);


--
-- TOC entry 2651 (class 2606 OID 52737)
-- Dependencies: 2053 2053
-- Name: personal_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT personal_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2673 (class 2606 OID 52739)
-- Dependencies: 2069 2069
-- Name: personal_tipo_nomina_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal_tipo_nomina
    ADD CONSTRAINT personal_tipo_nomina_pk PRIMARY KEY (codigo_personal_tipo_nomina);


--
-- TOC entry 2675 (class 2606 OID 52741)
-- Dependencies: 2071 2071
-- Name: plan_entrenamiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_entrenamiento
    ADD CONSTRAINT plan_entrenamiento_pk PRIMARY KEY (codigo_plan_entrenamiento);


--
-- TOC entry 2677 (class 2606 OID 52743)
-- Dependencies: 2073 2073
-- Name: plan_rotacion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT plan_rotacion_pk PRIMARY KEY (codigo_plan_rotacion);


--
-- TOC entry 2679 (class 2606 OID 52745)
-- Dependencies: 2075 2075
-- Name: plan_temporada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY plan_temporada
    ADD CONSTRAINT plan_temporada_pk PRIMARY KEY (codigo_plan_temporada);


--
-- TOC entry 2681 (class 2606 OID 52747)
-- Dependencies: 2077 2077
-- Name: planificacion_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY planificacion_actividad
    ADD CONSTRAINT planificacion_actividad_pk PRIMARY KEY (codigo_planificacion_actividad);


--
-- TOC entry 2683 (class 2606 OID 52749)
-- Dependencies: 2079 2079
-- Name: proveedor_banco_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY proveedor_banco
    ADD CONSTRAINT proveedor_banco_pk PRIMARY KEY (codigo_cuenta_banco);


--
-- TOC entry 2685 (class 2606 OID 52751)
-- Dependencies: 2080 2080
-- Name: recaudo_por_proceso_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT recaudo_por_proceso_pk PRIMARY KEY (codigo_recaudo_por_proceso);


--
-- TOC entry 2687 (class 2606 OID 52753)
-- Dependencies: 2082 2082 2082
-- Name: recepcion_material_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recepcion_material
    ADD CONSTRAINT recepcion_material_pk PRIMARY KEY (codigo_nota_entrega, codigo_material);


--
-- TOC entry 2689 (class 2606 OID 52755)
-- Dependencies: 2083 2083
-- Name: representante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY representante
    ADD CONSTRAINT representante_pk PRIMARY KEY (codigo_familiar_jugador);


--
-- TOC entry 2693 (class 2606 OID 52757)
-- Dependencies: 2086 2086 2086
-- Name: resultado_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY resultado_actividad
    ADD CONSTRAINT resultado_actividad_pk PRIMARY KEY (codigo_resultado, codigo_actividad);


--
-- TOC entry 2695 (class 2606 OID 52759)
-- Dependencies: 2087 2087
-- Name: retiro_traslado_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY retiro_traslado
    ADD CONSTRAINT retiro_traslado_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2699 (class 2606 OID 52761)
-- Dependencies: 2090 2090
-- Name: roster_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT roster_competencia_pk PRIMARY KEY (codigo_roster_competencia);


--
-- TOC entry 2697 (class 2606 OID 52763)
-- Dependencies: 2088 2088
-- Name: roster_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT roster_pk PRIMARY KEY (codigo_roster);


--
-- TOC entry 2701 (class 2606 OID 52765)
-- Dependencies: 2092 2092
-- Name: seguridad_funcional_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT seguridad_funcional_pk PRIMARY KEY (codigo_seguridad);


--
-- TOC entry 2703 (class 2606 OID 52767)
-- Dependencies: 2095 2095
-- Name: sesion_ejecutada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT sesion_ejecutada_pk PRIMARY KEY (codigo_sesion_ejecutada);


--
-- TOC entry 2521 (class 2606 OID 52769)
-- Dependencies: 1955 1955
-- Name: sesion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT sesion_pk PRIMARY KEY (codigo_sesion);


--
-- TOC entry 2705 (class 2606 OID 52771)
-- Dependencies: 2097 2097 2097
-- Name: solicitud_mantenimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY solicitud_mantenimiento
    ADD CONSTRAINT solicitud_mantenimiento_pk PRIMARY KEY (codigo_solicitud, codigo_actividad);


--
-- TOC entry 2707 (class 2606 OID 52773)
-- Dependencies: 2099 2099
-- Name: talla_por_indumentaria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT talla_por_indumentaria_pk PRIMARY KEY (codigo_talla_indumentaria);


--
-- TOC entry 2709 (class 2606 OID 52775)
-- Dependencies: 2101 2101 2101
-- Name: talla_por_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT talla_por_jugador_pk PRIMARY KEY (cedula_rif, codigo_talla_indumentaria);


--
-- TOC entry 2711 (class 2606 OID 52777)
-- Dependencies: 2102 2102
-- Name: tarea_actividad_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT tarea_actividad_pk PRIMARY KEY (codigo_tarea_actividad);


--
-- TOC entry 2713 (class 2606 OID 52779)
-- Dependencies: 2104 2104
-- Name: tarea_actividad_planificada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT tarea_actividad_planificada_pk PRIMARY KEY (codigo_personal_actividad_planificada);


--
-- TOC entry 2715 (class 2606 OID 52781)
-- Dependencies: 2106 2106
-- Name: test_evaluativo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY test_evaluativo
    ADD CONSTRAINT test_evaluativo_pk PRIMARY KEY (codigo_test);


--
-- TOC entry 2717 (class 2606 OID 52783)
-- Dependencies: 2108 2108 2108
-- Name: test_jugador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY test_jugador
    ADD CONSTRAINT test_jugador_pk PRIMARY KEY (codigo_indicador_test, codigo_roster);


--
-- TOC entry 2719 (class 2606 OID 52785)
-- Dependencies: 2109 2109
-- Name: tipo_competencia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_competencia
    ADD CONSTRAINT tipo_competencia_pk PRIMARY KEY (codigo_tipo_competencia);


--
-- TOC entry 2721 (class 2606 OID 52787)
-- Dependencies: 2111 2111
-- Name: tipo_dato_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_dato
    ADD CONSTRAINT tipo_dato_pk PRIMARY KEY (codigo_tipo_dato);


--
-- TOC entry 2723 (class 2606 OID 52789)
-- Dependencies: 2113 2113
-- Name: tipo_pago_representante_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_pago_representante
    ADD CONSTRAINT tipo_pago_representante_pk PRIMARY KEY (codigo_tipo_pago_representante);


--
-- TOC entry 2725 (class 2606 OID 52791)
-- Dependencies: 2115 2115
-- Name: usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (cedula_rif);


--
-- TOC entry 2727 (class 2606 OID 52793)
-- Dependencies: 2116 2116
-- Name: valor_escala_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY valor_escala
    ADD CONSTRAINT valor_escala_pk PRIMARY KEY (codigo_valor_escala);


--
-- TOC entry 2729 (class 2606 OID 52794)
-- Dependencies: 2470 1914 1915
-- Name: actividad_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT actividad_actividad_calendario_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2753 (class 2606 OID 52799)
-- Dependencies: 1914 1935 2470
-- Name: actividad_comision_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_actividad
    ADD CONSTRAINT actividad_comision_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2851 (class 2606 OID 52804)
-- Dependencies: 2474 1918 2005
-- Name: actividad_entrenamiento_indicador_actividad_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT actividad_entrenamiento_indicador_actividad_escala_fk FOREIGN KEY (cod_actividad_entrenamiento) REFERENCES actividad_entrenamiento(cod_actividad_entrenamiento);


--
-- TOC entry 2835 (class 2606 OID 52809)
-- Dependencies: 2470 1994 1914
-- Name: actividad_estado_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado_actividad
    ADD CONSTRAINT actividad_estado_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2894 (class 2606 OID 52814)
-- Dependencies: 2470 1914 2034
-- Name: actividad_material_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad
    ADD CONSTRAINT actividad_material_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2916 (class 2606 OID 52819)
-- Dependencies: 1914 2054 2470
-- Name: actividad_personal_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad
    ADD CONSTRAINT actividad_personal_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2959 (class 2606 OID 52824)
-- Dependencies: 2086 1914 2470
-- Name: actividad_resultado_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY resultado_actividad
    ADD CONSTRAINT actividad_resultado_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2977 (class 2606 OID 52829)
-- Dependencies: 1914 2470 2097
-- Name: actividad_solicitud_mantenimiento_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitud_mantenimiento
    ADD CONSTRAINT actividad_solicitud_mantenimiento_fk1 FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2983 (class 2606 OID 52834)
-- Dependencies: 2102 2470 1914
-- Name: actividad_tarea_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT actividad_tarea_actividad_fk FOREIGN KEY (codigo_actividad) REFERENCES actividad(codigo_actividad);


--
-- TOC entry 2796 (class 2606 OID 52839)
-- Dependencies: 1966 1921 2478
-- Name: actividades_ejecutadas_desempeo_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT actividades_ejecutadas_desempeo_jugador_fk FOREIGN KEY (codigo_actividad_ejecutada) REFERENCES actividades_ejecutadas(codigo_actividad_ejecutada);


--
-- TOC entry 2891 (class 2606 OID 52844)
-- Dependencies: 1925 2484 2033
-- Name: almacen_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material
    ADD CONSTRAINT almacen_material_fk FOREIGN KEY (codigo_almacen) REFERENCES almacen(codigo_almacen);


--
-- TOC entry 2809 (class 2606 OID 52849)
-- Dependencies: 1974 1927 2486
-- Name: ascenso_documento_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT ascenso_documento_ascenso_fk FOREIGN KEY (codigo_ascenso) REFERENCES ascenso(codigo_ascenso);


--
-- TOC entry 2797 (class 2606 OID 52854)
-- Dependencies: 2488 1929 1966
-- Name: asistencia_jugador_desempeo_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT asistencia_jugador_desempeo_jugador_fk FOREIGN KEY (codigo_asistencia) REFERENCES asistencia_jugador(codigo_asistencia);


--
-- TOC entry 2733 (class 2606 OID 52859)
-- Dependencies: 1932 2492 1918
-- Name: categoria_actividad_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_entrenamiento
    ADD CONSTRAINT categoria_actividad_entrenamiento_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2751 (class 2606 OID 52864)
-- Dependencies: 2492 1934 1932
-- Name: categoria_categoria_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT categoria_categoria_competencia_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2765 (class 2606 OID 52869)
-- Dependencies: 2492 1944 1932
-- Name: categoria_constante_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY constante_categoria
    ADD CONSTRAINT categoria_constante_categoria_fk FOREIGN KEY (codigo_categoria_1) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2825 (class 2606 OID 52874)
-- Dependencies: 2492 1984 1932
-- Name: categoria_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT categoria_equipo_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2854 (class 2606 OID 52879)
-- Dependencies: 2007 2492 1932
-- Name: categoria_indicador_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT categoria_indicador_competencia_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2881 (class 2606 OID 52884)
-- Dependencies: 2492 2027 1932
-- Name: categoria_liga_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_categoria
    ADD CONSTRAINT categoria_liga_categoria_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2946 (class 2606 OID 52889)
-- Dependencies: 2075 1932 2492
-- Name: categoria_temporada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_temporada
    ADD CONSTRAINT categoria_temporada_fk FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo_categoria);


--
-- TOC entry 2839 (class 2606 OID 52894)
-- Dependencies: 1936 1996 2498
-- Name: comision_equipo_familiar_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT comision_equipo_familiar_comision_equipo_fk FOREIGN KEY (codigo_comision_equipo) REFERENCES comision_equipo(codigo_comision_equipo);


--
-- TOC entry 2730 (class 2606 OID 52899)
-- Dependencies: 1938 2500 1915
-- Name: competencia_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT competencia_actividad_calendario_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2752 (class 2606 OID 52904)
-- Dependencies: 2500 1934 1938
-- Name: competencia_categoria_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY categoria_competencia
    ADD CONSTRAINT competencia_categoria_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2785 (class 2606 OID 52909)
-- Dependencies: 1938 1959 2500
-- Name: competencia_dato_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT competencia_dato_deportivo_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2828 (class 2606 OID 52914)
-- Dependencies: 2500 1986 1938
-- Name: competencia_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT competencia_equipo_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2844 (class 2606 OID 52919)
-- Dependencies: 1938 2500 1999
-- Name: competencia_fase_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY fase_competencia
    ADD CONSTRAINT competencia_fase_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2847 (class 2606 OID 52924)
-- Dependencies: 2500 1938 2002
-- Name: competencia_hospedaje_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT competencia_hospedaje_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2855 (class 2606 OID 52929)
-- Dependencies: 1938 2500 2007
-- Name: competencia_indicador_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT competencia_indicador_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2870 (class 2606 OID 52934)
-- Dependencies: 2019 2500 1938
-- Name: competencia_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT competencia_juego_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2883 (class 2606 OID 52939)
-- Dependencies: 2029 2500 1938
-- Name: competencia_liga_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_competencia
    ADD CONSTRAINT competencia_liga_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2965 (class 2606 OID 52944)
-- Dependencies: 1938 2090 2500
-- Name: competencia_roster_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT competencia_roster_competencia_fk FOREIGN KEY (codigo_competencia) REFERENCES competencia(codigo_competencia);


--
-- TOC entry 2902 (class 2606 OID 52949)
-- Dependencies: 2042 1940 2502
-- Name: concepto_nomina_movimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT concepto_nomina_movimiento_fk FOREIGN KEY (codigo_concepto_nomina) REFERENCES concepto_nomina(codigo_concepto_nomina);


--
-- TOC entry 2922 (class 2606 OID 52954)
-- Dependencies: 2058 2502 1940
-- Name: concepto_nomina_personal_concepto_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_concepto_nomina
    ADD CONSTRAINT concepto_nomina_personal_concepto_nomina_fk FOREIGN KEY (codigo_concepto_nomina) REFERENCES concepto_nomina(codigo_concepto_nomina);


--
-- TOC entry 2766 (class 2606 OID 52959)
-- Dependencies: 1944 2506 1943
-- Name: constante_constante_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY constante_categoria
    ADD CONSTRAINT constante_constante_categoria_fk FOREIGN KEY (codigo_constante) REFERENCES constante(codigo_constante);


--
-- TOC entry 2770 (class 2606 OID 52964)
-- Dependencies: 1948 2510 1947
-- Name: cuenta_pagar_cuenta_pagar_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT cuenta_pagar_cuenta_pagar_material_fk FOREIGN KEY (origen) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2820 (class 2606 OID 52969)
-- Dependencies: 2510 1947 1982
-- Name: cuenta_pagar_egreso_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_cuenta_pagar
    ADD CONSTRAINT cuenta_pagar_egreso_cuenta_pagar_fk FOREIGN KEY (origen) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2905 (class 2606 OID 52974)
-- Dependencies: 2044 2510 1947
-- Name: cuenta_pagar_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nomina
    ADD CONSTRAINT cuenta_pagar_nomina_fk FOREIGN KEY (codigo_nomina) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2907 (class 2606 OID 52979)
-- Dependencies: 1947 2510 2046
-- Name: cuenta_pagar_nota_entrega_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nota_entrega
    ADD CONSTRAINT cuenta_pagar_nota_entrega_fk FOREIGN KEY (origen) REFERENCES cuenta_pagar(origen);


--
-- TOC entry 2802 (class 2606 OID 52984)
-- Dependencies: 1970 2514 1949
-- Name: dato_academico_documento_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT dato_academico_documento_academico_fk FOREIGN KEY (codigo_academico) REFERENCES dato_academico(codigo_academico);


--
-- TOC entry 2731 (class 2606 OID 52989)
-- Dependencies: 2518 1915 1953
-- Name: dato_basico_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT dato_basico_actividad_calendario_fk FOREIGN KEY (codigo_tipo_actividad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2734 (class 2606 OID 52994)
-- Dependencies: 1953 1918 2518
-- Name: dato_basico_actividad_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_entrenamiento
    ADD CONSTRAINT dato_basico_actividad_entrenamiento_fk FOREIGN KEY (fase) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2740 (class 2606 OID 52999)
-- Dependencies: 1923 1953 2518
-- Name: dato_basico_afeccion_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT dato_basico_afeccion_jugador_fk FOREIGN KEY (codigo_afeccion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2742 (class 2606 OID 53004)
-- Dependencies: 2518 1924 1953
-- Name: dato_basico_afeccion_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_personal
    ADD CONSTRAINT dato_basico_afeccion_personal_fk FOREIGN KEY (codigo_tipo_afeccion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2746 (class 2606 OID 53009)
-- Dependencies: 1929 1953 2518
-- Name: dato_basico_asistencia_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_jugador
    ADD CONSTRAINT dato_basico_asistencia_jugador_fk FOREIGN KEY (eventualidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2754 (class 2606 OID 53014)
-- Dependencies: 1935 2518 1953
-- Name: dato_basico_comision_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_actividad
    ADD CONSTRAINT dato_basico_comision_actividad_fk FOREIGN KEY (codigo_comision) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2755 (class 2606 OID 53019)
-- Dependencies: 2518 1936 1953
-- Name: dato_basico_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT dato_basico_comision_equipo_fk FOREIGN KEY (codigo_comision) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2757 (class 2606 OID 53024)
-- Dependencies: 1938 2518 1953
-- Name: dato_basico_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk FOREIGN KEY (codigo_estado_competencia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2758 (class 2606 OID 53029)
-- Dependencies: 1938 1953 2518
-- Name: dato_basico_competencia_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk1 FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2759 (class 2606 OID 53034)
-- Dependencies: 1953 1938 2518
-- Name: dato_basico_competencia_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT dato_basico_competencia_fk2 FOREIGN KEY (codigo_organizacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2762 (class 2606 OID 53039)
-- Dependencies: 1940 1953 2518
-- Name: dato_basico_concepto_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY concepto_nomina
    ADD CONSTRAINT dato_basico_concepto_nomina_fk FOREIGN KEY (codigo_tipo_concepto) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2763 (class 2606 OID 53044)
-- Dependencies: 1953 2518 1942
-- Name: dato_basico_condicion_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY condicion_competencia
    ADD CONSTRAINT dato_basico_condicion_competencia_fk FOREIGN KEY (codigo_condicion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2767 (class 2606 OID 53049)
-- Dependencies: 1947 1953 2518
-- Name: dato_basico_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT dato_basico_cuenta_pagar_fk FOREIGN KEY (codigo_tipo_egreso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2768 (class 2606 OID 53054)
-- Dependencies: 1953 1947 2518
-- Name: dato_basico_cuenta_pagar_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT dato_basico_cuenta_pagar_fk2 FOREIGN KEY (codigo_tipo_documento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2773 (class 2606 OID 53059)
-- Dependencies: 2518 1953 1949
-- Name: dato_basico_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_basico_dato_academico_fk FOREIGN KEY (codigo_anno_escolar) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2774 (class 2606 OID 53064)
-- Dependencies: 2518 1953 1949
-- Name: dato_basico_dato_academico_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT dato_basico_dato_academico_fk1 FOREIGN KEY (codigo_curso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2778 (class 2606 OID 53069)
-- Dependencies: 1953 1953 2518
-- Name: dato_basico_dato_basico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT dato_basico_dato_basico_fk FOREIGN KEY (parent_codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2783 (class 2606 OID 53074)
-- Dependencies: 1957 2518 1953
-- Name: dato_basico_dato_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT dato_basico_dato_conducta_fk FOREIGN KEY (codigo_tipo_suspension) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2789 (class 2606 OID 53079)
-- Dependencies: 1953 2518 1962
-- Name: dato_basico_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT dato_basico_dato_social_fk FOREIGN KEY (codigo_actividad_social) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2801 (class 2606 OID 53084)
-- Dependencies: 1953 1968 2518
-- Name: dato_basico_divisa_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY divisa
    ADD CONSTRAINT dato_basico_divisa_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2804 (class 2606 OID 53089)
-- Dependencies: 1953 2518 1971
-- Name: dato_basico_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT dato_basico_documento_acreedor_fk FOREIGN KEY (codigo_tipo_ingreso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2952 (class 2606 OID 53094)
-- Dependencies: 1953 2080 2518
-- Name: dato_basico_documento_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_documento_fk1 FOREIGN KEY (codigo_documento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2953 (class 2606 OID 53099)
-- Dependencies: 1953 2080 2518
-- Name: dato_basico_documento_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_documento_fk2 FOREIGN KEY (codigo_proceso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2822 (class 2606 OID 53104)
-- Dependencies: 2518 1953 1983
-- Name: dato_basico_egreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT dato_basico_egreso_forma_pago_fk FOREIGN KEY (codigo_tarjeta) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2823 (class 2606 OID 53109)
-- Dependencies: 1983 1953 2518
-- Name: dato_basico_egreso_forma_pago_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT dato_basico_egreso_forma_pago_fk1 FOREIGN KEY (codigo_banco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2826 (class 2606 OID 53114)
-- Dependencies: 1984 1953 2518
-- Name: dato_basico_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT dato_basico_equipo_fk FOREIGN KEY (codigo_clasificacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2833 (class 2606 OID 53119)
-- Dependencies: 1990 1953 2518
-- Name: dato_basico_escala_medicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY escala_medicion
    ADD CONSTRAINT dato_basico_escala_medicion_fk FOREIGN KEY (tipo_escala) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2834 (class 2606 OID 53124)
-- Dependencies: 2518 1992 1953
-- Name: dato_basico_estadio_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estadio
    ADD CONSTRAINT dato_basico_estadio_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2836 (class 2606 OID 53129)
-- Dependencies: 1953 2518 1994
-- Name: dato_basico_estado_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado_actividad
    ADD CONSTRAINT dato_basico_estado_mantenimiento_fk FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2837 (class 2606 OID 53134)
-- Dependencies: 1995 1953 2518
-- Name: dato_basico_familiar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT dato_basico_familiar_fk FOREIGN KEY (codigo_profesion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2841 (class 2606 OID 53139)
-- Dependencies: 2518 1997 1953
-- Name: dato_basico_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT dato_basico_familiar_jugador_fk FOREIGN KEY (codigo_parentesco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2845 (class 2606 OID 53144)
-- Dependencies: 2518 1953 2000
-- Name: dato_basico_horario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT dato_basico_horario_fk FOREIGN KEY (codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2852 (class 2606 OID 53149)
-- Dependencies: 1953 2005 2518
-- Name: dato_basico_indicador_actividad_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT dato_basico_indicador_actividad_escala_fk FOREIGN KEY (indicador) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2849 (class 2606 OID 53154)
-- Dependencies: 1953 2518 2004
-- Name: dato_basico_indicador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador
    ADD CONSTRAINT dato_basico_indicador_fk FOREIGN KEY (codigo_tipo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2850 (class 2606 OID 53159)
-- Dependencies: 1953 2518 2004
-- Name: dato_basico_indicador_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador
    ADD CONSTRAINT dato_basico_indicador_fk1 FOREIGN KEY (codigo_modalidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2857 (class 2606 OID 53164)
-- Dependencies: 1953 2518 2010
-- Name: dato_basico_indicador_test_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT dato_basico_indicador_test_fk FOREIGN KEY (indicador) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2860 (class 2606 OID 53169)
-- Dependencies: 2518 2012 1953
-- Name: dato_basico_ingreso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso
    ADD CONSTRAINT dato_basico_ingreso_fk FOREIGN KEY (codigo_tipo_documento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2863 (class 2606 OID 53174)
-- Dependencies: 2014 1953 2518
-- Name: dato_basico_ingreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk FOREIGN KEY (codigo_forma_pago) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2864 (class 2606 OID 53179)
-- Dependencies: 1953 2518 2014
-- Name: dato_basico_ingreso_forma_pago_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk1 FOREIGN KEY (codigo_tarjeta) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2865 (class 2606 OID 53184)
-- Dependencies: 2518 2014 1953
-- Name: dato_basico_ingreso_forma_pago_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT dato_basico_ingreso_forma_pago_fk2 FOREIGN KEY (codigo_banco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2867 (class 2606 OID 53189)
-- Dependencies: 2518 2015 1953
-- Name: dato_basico_instalacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instalacion
    ADD CONSTRAINT dato_basico_instalacion_fk FOREIGN KEY (codigo_tipo_instalacion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2868 (class 2606 OID 53194)
-- Dependencies: 2017 1953 2518
-- Name: dato_basico_institucion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT dato_basico_institucion_fk FOREIGN KEY (codigo_tipo_institucion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2869 (class 2606 OID 53199)
-- Dependencies: 1953 2017 2518
-- Name: dato_basico_institucion_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY institucion
    ADD CONSTRAINT dato_basico_institucion_fk1 FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2871 (class 2606 OID 53204)
-- Dependencies: 1953 2518 2019
-- Name: dato_basico_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT dato_basico_juego_fk FOREIGN KEY (codigo_estado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2873 (class 2606 OID 53209)
-- Dependencies: 2021 1953 2518
-- Name: dato_basico_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT dato_basico_jugador_fk FOREIGN KEY (codigo_parroquia_nacimiento) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2874 (class 2606 OID 53214)
-- Dependencies: 2021 1953 2518
-- Name: dato_basico_jugador_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT dato_basico_jugador_fk1 FOREIGN KEY (codigo_pais) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2876 (class 2606 OID 53219)
-- Dependencies: 2518 1953 2022
-- Name: dato_basico_jugador_foraneo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT dato_basico_jugador_foraneo_fk FOREIGN KEY (codigo_tipo_mencion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2879 (class 2606 OID 53224)
-- Dependencies: 2518 1953 2024
-- Name: dato_basico_lapso_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lapso_deportivo
    ADD CONSTRAINT dato_basico_lapso_deportivo_fk FOREIGN KEY (tipo_lapso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2880 (class 2606 OID 53229)
-- Dependencies: 2518 1953 2026
-- Name: dato_basico_liga_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga
    ADD CONSTRAINT dato_basico_liga_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2885 (class 2606 OID 53234)
-- Dependencies: 2030 1953 2518
-- Name: dato_basico_line_up_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT dato_basico_line_up_fk FOREIGN KEY (codigo_posicion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2886 (class 2606 OID 53239)
-- Dependencies: 2030 2518 1953
-- Name: dato_basico_line_up_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT dato_basico_line_up_fk1 FOREIGN KEY (codigo_tipo_mencion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2889 (class 2606 OID 53244)
-- Dependencies: 1953 2032 2518
-- Name: dato_basico_logro_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT dato_basico_logro_por_jugador_fk FOREIGN KEY (codigo_logro) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2892 (class 2606 OID 53249)
-- Dependencies: 1953 2033 2518
-- Name: dato_basico_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material
    ADD CONSTRAINT dato_basico_material_fk FOREIGN KEY (codigo_tipo_material) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2893 (class 2606 OID 53254)
-- Dependencies: 1953 2518 2033
-- Name: dato_basico_material_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material
    ADD CONSTRAINT dato_basico_material_fk1 FOREIGN KEY (codigo_unidad_medida) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2898 (class 2606 OID 53259)
-- Dependencies: 2038 1953 2518
-- Name: dato_basico_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medico
    ADD CONSTRAINT dato_basico_medico_fk FOREIGN KEY (codigo_especialidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2900 (class 2606 OID 53264)
-- Dependencies: 2518 2041 1953
-- Name: dato_basico_motivo_sancion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT dato_basico_motivo_sancion_fk FOREIGN KEY (codigo_motivo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2906 (class 2606 OID 53269)
-- Dependencies: 2518 2044 1953
-- Name: dato_basico_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nomina
    ADD CONSTRAINT dato_basico_nomina_fk FOREIGN KEY (codigo_tipo_nomina) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2910 (class 2606 OID 53274)
-- Dependencies: 2050 1953 2518
-- Name: dato_basico_persona_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT dato_basico_persona_fk FOREIGN KEY (codigo_parroquia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2911 (class 2606 OID 53279)
-- Dependencies: 2518 2050 1953
-- Name: dato_basico_persona_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT dato_basico_persona_fk1 FOREIGN KEY (codigo_tipo_persona) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2913 (class 2606 OID 53284)
-- Dependencies: 2052 1953 2518
-- Name: dato_basico_persona_natural_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT dato_basico_persona_natural_fk FOREIGN KEY (codigo_genero) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2920 (class 2606 OID 53289)
-- Dependencies: 2518 1953 2056
-- Name: dato_basico_personal_cargo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_cargo
    ADD CONSTRAINT dato_basico_personal_cargo_fk FOREIGN KEY (codigo_cargo) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2924 (class 2606 OID 53294)
-- Dependencies: 1953 2060 2518
-- Name: dato_basico_personal_contrato_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT dato_basico_personal_contrato_fk FOREIGN KEY (codigo_modalidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2925 (class 2606 OID 53299)
-- Dependencies: 1953 2060 2518
-- Name: dato_basico_personal_contrato_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT dato_basico_personal_contrato_fk1 FOREIGN KEY (codigo_horario) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2937 (class 2606 OID 53304)
-- Dependencies: 2518 1953 2068
-- Name: dato_basico_personal_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT dato_basico_personal_juego_fk FOREIGN KEY (codigo_cargo_personal) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2933 (class 2606 OID 53309)
-- Dependencies: 2518 2065 1953
-- Name: dato_basico_personal_juego_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo
    ADD CONSTRAINT dato_basico_personal_juego_fk1 FOREIGN KEY (codigo_tipo_personal_juego) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2940 (class 2606 OID 53314)
-- Dependencies: 2069 1953 2518
-- Name: dato_basico_personal_tipo_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_tipo_nomina
    ADD CONSTRAINT dato_basico_personal_tipo_nomina_fk FOREIGN KEY (codigo_tipo_nomina) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2943 (class 2606 OID 53319)
-- Dependencies: 2518 1953 2073
-- Name: dato_basico_plan_rotacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT dato_basico_plan_rotacion_fk FOREIGN KEY (eventualidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2948 (class 2606 OID 53324)
-- Dependencies: 2518 2077 1953
-- Name: dato_basico_planificacion_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY planificacion_actividad
    ADD CONSTRAINT dato_basico_planificacion_mantenimiento_fk FOREIGN KEY (codigo_tipo_actividad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2950 (class 2606 OID 53329)
-- Dependencies: 1953 2079 2518
-- Name: dato_basico_proveedor_banco_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY proveedor_banco
    ADD CONSTRAINT dato_basico_proveedor_banco_fk FOREIGN KEY (codigo_banco) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2954 (class 2606 OID 53334)
-- Dependencies: 2518 2080 1953
-- Name: dato_basico_recaudo_por_proceso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recaudo_por_proceso
    ADD CONSTRAINT dato_basico_recaudo_por_proceso_fk FOREIGN KEY (codigo_importancia) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2960 (class 2606 OID 53339)
-- Dependencies: 2518 2086 1953
-- Name: dato_basico_resultado_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY resultado_actividad
    ADD CONSTRAINT dato_basico_resultado_mantenimiento_fk FOREIGN KEY (codigo_resultado) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2961 (class 2606 OID 53344)
-- Dependencies: 2518 2087 1953
-- Name: dato_basico_retiro_traslado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY retiro_traslado
    ADD CONSTRAINT dato_basico_retiro_traslado_fk FOREIGN KEY (codigo_motivo_retiro) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2966 (class 2606 OID 53349)
-- Dependencies: 1953 2090 2518
-- Name: dato_basico_roster_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT dato_basico_roster_competencia_fk FOREIGN KEY (codigo_jugador_clave) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2967 (class 2606 OID 53354)
-- Dependencies: 1953 2518 2090
-- Name: dato_basico_roster_competencia_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT dato_basico_roster_competencia_fk1 FOREIGN KEY (codigo_tipo_jugador) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2969 (class 2606 OID 53359)
-- Dependencies: 2518 2092 1953
-- Name: dato_basico_seguridad_funcional_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT dato_basico_seguridad_funcional_fk FOREIGN KEY (codigo_dato_basico) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2972 (class 2606 OID 53364)
-- Dependencies: 2518 1953 2095
-- Name: dato_basico_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT dato_basico_sesion_ejecutada_fk FOREIGN KEY (eventualidad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2780 (class 2606 OID 53369)
-- Dependencies: 1955 2518 1953
-- Name: dato_basico_sesion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT dato_basico_sesion_fk FOREIGN KEY (dia_semana) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2978 (class 2606 OID 53374)
-- Dependencies: 1953 2518 2097
-- Name: dato_basico_solicitud_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitud_mantenimiento
    ADD CONSTRAINT dato_basico_solicitud_mantenimiento_fk FOREIGN KEY (codigo_prioridad) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2979 (class 2606 OID 53379)
-- Dependencies: 2099 2518 1953
-- Name: dato_basico_talla_por_indumentaria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT dato_basico_talla_por_indumentaria_fk FOREIGN KEY (codigo_talla) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2980 (class 2606 OID 53384)
-- Dependencies: 2099 2518 1953
-- Name: dato_basico_talla_por_indumentaria_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_indumentaria
    ADD CONSTRAINT dato_basico_talla_por_indumentaria_fk1 FOREIGN KEY (codigo_indumentaria) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2984 (class 2606 OID 53389)
-- Dependencies: 1953 2102 2518
-- Name: dato_basico_tarea_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT dato_basico_tarea_mantenimiento_fk FOREIGN KEY (codigo_tarea) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2986 (class 2606 OID 53394)
-- Dependencies: 2104 2518 1953
-- Name: dato_basico_tarea_mantenimiento_planificado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT dato_basico_tarea_mantenimiento_planificado_fk FOREIGN KEY (codigo_tarea) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2993 (class 2606 OID 53399)
-- Dependencies: 2113 1953 2518
-- Name: dato_basico_tipo_pago_representante_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_pago_representante
    ADD CONSTRAINT dato_basico_tipo_pago_representante_fk FOREIGN KEY (codigo_tipo_ingreso) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2934 (class 2606 OID 53404)
-- Dependencies: 2067 2518 1953
-- Name: dato_basico_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT dato_basico_umpire_juego_fk FOREIGN KEY (codigo_posicion) REFERENCES dato_basico(codigo_dato_basico);


--
-- TOC entry 2811 (class 2606 OID 53409)
-- Dependencies: 1957 2522 1975
-- Name: dato_conducta_documento_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT dato_conducta_documento_conducta_fk FOREIGN KEY (codigo_dato_conducta) REFERENCES dato_conducta(codigo_dato_conducta);


--
-- TOC entry 2901 (class 2606 OID 53414)
-- Dependencies: 2041 1957 2522
-- Name: dato_conducta_motivo_sancion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT dato_conducta_motivo_sancion_fk FOREIGN KEY (codigo_dato_conducta) REFERENCES dato_conducta(codigo_dato_conducta);


--
-- TOC entry 2890 (class 2606 OID 53419)
-- Dependencies: 2032 2524 1959 1959 2032
-- Name: dato_deportivo_logro_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logro_por_jugador
    ADD CONSTRAINT dato_deportivo_logro_por_jugador_fk FOREIGN KEY (codigo_competencia, cedula_rif) REFERENCES dato_deportivo(codigo_competencia, cedula_rif);


--
-- TOC entry 2741 (class 2606 OID 53424)
-- Dependencies: 1923 1960 2526
-- Name: dato_medico_afeccion_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_jugador
    ADD CONSTRAINT dato_medico_afeccion_jugador_fk FOREIGN KEY (codigo_dato_medico) REFERENCES dato_medico(codigo_dato_medico);


--
-- TOC entry 2816 (class 2606 OID 53429)
-- Dependencies: 2526 1960 1978
-- Name: dato_medico_documento_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT dato_medico_documento_medico_fk FOREIGN KEY (codigo_dato_medico) REFERENCES dato_medico(codigo_dato_medico);


--
-- TOC entry 2827 (class 2606 OID 53434)
-- Dependencies: 1984 2538 1968
-- Name: divisa_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo
    ADD CONSTRAINT divisa_equipo_fk FOREIGN KEY (codigo_divisa) REFERENCES divisa(codigo_divisa);


--
-- TOC entry 2807 (class 2606 OID 53439)
-- Dependencies: 1973 2542 1971
-- Name: documento_acreedor_documento_acreedor_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor_material
    ADD CONSTRAINT documento_acreedor_documento_acreedor_material_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2814 (class 2606 OID 53444)
-- Dependencies: 2542 1977 1971
-- Name: documento_acreedor_documento_indumentaria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_indumentaria
    ADD CONSTRAINT documento_acreedor_documento_indumentaria_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2818 (class 2606 OID 53449)
-- Dependencies: 2542 1980 1971
-- Name: documento_acreedor_donacion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY donacion_material
    ADD CONSTRAINT documento_acreedor_donacion_material_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2861 (class 2606 OID 53454)
-- Dependencies: 2013 2542 1971
-- Name: documento_acreedor_ingreso_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_documento_acreedor
    ADD CONSTRAINT documento_acreedor_ingreso_documento_acreedor_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2908 (class 2606 OID 53459)
-- Dependencies: 1971 2046 2542
-- Name: documento_acreedor_nota_entrega_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nota_entrega
    ADD CONSTRAINT documento_acreedor_nota_entrega_fk FOREIGN KEY (codigo_documento_acreedor) REFERENCES documento_acreedor(codigo_documento_acreedor);


--
-- TOC entry 2803 (class 2606 OID 53464)
-- Dependencies: 1970 1976 2550
-- Name: documento_entregado_documento_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_academico
    ADD CONSTRAINT documento_entregado_documento_academico_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2810 (class 2606 OID 53469)
-- Dependencies: 1974 2550 1976
-- Name: documento_entregado_documento_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_ascenso
    ADD CONSTRAINT documento_entregado_documento_ascenso_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2812 (class 2606 OID 53474)
-- Dependencies: 1975 2550 1976
-- Name: documento_entregado_documento_conducta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_conducta
    ADD CONSTRAINT documento_entregado_documento_conducta_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2817 (class 2606 OID 53479)
-- Dependencies: 1978 2550 1976
-- Name: documento_entregado_documento_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_medico
    ADD CONSTRAINT documento_entregado_documento_medico_fk FOREIGN KEY (codigo_documento_entregado) REFERENCES documento_entregado(codigo_documento_entregado);


--
-- TOC entry 2821 (class 2606 OID 53484)
-- Dependencies: 1982 2558 1981
-- Name: egreso_egreso_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_cuenta_pagar
    ADD CONSTRAINT egreso_egreso_cuenta_pagar_fk FOREIGN KEY (numero_documento) REFERENCES egreso(numero_documento);


--
-- TOC entry 2824 (class 2606 OID 53489)
-- Dependencies: 2558 1981 1983
-- Name: egreso_egreso_forma_pago_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY egreso_forma_pago
    ADD CONSTRAINT egreso_egreso_forma_pago_fk FOREIGN KEY (numero_documento) REFERENCES egreso(numero_documento);


--
-- TOC entry 2756 (class 2606 OID 53494)
-- Dependencies: 1984 2564 1936
-- Name: equipo_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY comision_equipo
    ADD CONSTRAINT equipo_comision_equipo_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2831 (class 2606 OID 53499)
-- Dependencies: 1986 2566 1988
-- Name: equipo_competencia_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT equipo_competencia_equipo_juego_fk FOREIGN KEY (codigo_equipo_competencia) REFERENCES equipo_competencia(codigo_equipo_competencia);


--
-- TOC entry 2877 (class 2606 OID 53504)
-- Dependencies: 1986 2566 2022
-- Name: equipo_competencia_jugador_foraneo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT equipo_competencia_jugador_foraneo_fk FOREIGN KEY (codigo_equipo_competencia) REFERENCES equipo_competencia(codigo_equipo_competencia);


--
-- TOC entry 2829 (class 2606 OID 53509)
-- Dependencies: 2564 1984 1986
-- Name: equipo_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT equipo_equipo_competencia_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2792 (class 2606 OID 53514)
-- Dependencies: 2568 1988 1964
-- Name: equipo_juego_desempenno_colectivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT equipo_juego_desempenno_colectivo_fk FOREIGN KEY (codigo_equipo_juego) REFERENCES equipo_juego(codigo_equipo_juego);


--
-- TOC entry 2931 (class 2606 OID 53519)
-- Dependencies: 1988 2064 2568
-- Name: equipo_juego_personal_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo_juego
    ADD CONSTRAINT equipo_juego_personal_equipo_juego_fk FOREIGN KEY (codigo_equipo_juego) REFERENCES equipo_juego(codigo_equipo_juego);


--
-- TOC entry 2927 (class 2606 OID 53524)
-- Dependencies: 2062 1984 2564
-- Name: equipo_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT equipo_personal_equipo_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2963 (class 2606 OID 53529)
-- Dependencies: 2088 1984 2564
-- Name: equipo_roster_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT equipo_roster_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2973 (class 2606 OID 53534)
-- Dependencies: 2095 1984 2564
-- Name: equipo_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT equipo_sesion_ejecutada_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2781 (class 2606 OID 53539)
-- Dependencies: 1955 1984 2564
-- Name: equipo_sesion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT equipo_sesion_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2989 (class 2606 OID 53544)
-- Dependencies: 2106 1984 2564
-- Name: equipo_test_evaluativo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test_evaluativo
    ADD CONSTRAINT equipo_test_evaluativo_fk FOREIGN KEY (codigo_equipo) REFERENCES equipo(codigo_equipo);


--
-- TOC entry 2853 (class 2606 OID 53549)
-- Dependencies: 2005 1990 2570
-- Name: escala_medicion_indicador_actividad_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_actividad_escala
    ADD CONSTRAINT escala_medicion_indicador_actividad_escala_fk FOREIGN KEY (codigo_escala) REFERENCES escala_medicion(codigo_escala);


--
-- TOC entry 2858 (class 2606 OID 53554)
-- Dependencies: 2010 1990 2570
-- Name: escala_medicion_indicador_test_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT escala_medicion_indicador_test_fk FOREIGN KEY (codigo_escala) REFERENCES escala_medicion(codigo_escala);


--
-- TOC entry 2995 (class 2606 OID 53559)
-- Dependencies: 1990 2116 2570
-- Name: escala_medicion_valor_escala_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY valor_escala
    ADD CONSTRAINT escala_medicion_valor_escala_fk FOREIGN KEY (codigo_escala) REFERENCES escala_medicion(codigo_escala);


--
-- TOC entry 2872 (class 2606 OID 53564)
-- Dependencies: 1992 2019 2572
-- Name: estadio_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juego
    ADD CONSTRAINT estadio_juego_fk FOREIGN KEY (codigo_estadio) REFERENCES estadio(codigo_estadio);


--
-- TOC entry 2842 (class 2606 OID 53569)
-- Dependencies: 1997 1995 2576
-- Name: familiar_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT familiar_familiar_jugador_fk FOREIGN KEY (cedula_familiar) REFERENCES familiar(cedula_familiar);


--
-- TOC entry 2840 (class 2606 OID 53574)
-- Dependencies: 2580 1996 1997
-- Name: familiar_jugador_familiar_comision_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_comision_equipo
    ADD CONSTRAINT familiar_jugador_familiar_comision_equipo_fk FOREIGN KEY (codigo_familiar_jugador) REFERENCES familiar_jugador(codigo_familiar_jugador);


--
-- TOC entry 2848 (class 2606 OID 53579)
-- Dependencies: 2580 1997 2002
-- Name: familiar_jugador_hospedaje_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hospedaje
    ADD CONSTRAINT familiar_jugador_hospedaje_fk FOREIGN KEY (codigo_familiar_jugador) REFERENCES familiar_jugador(codigo_familiar_jugador);


--
-- TOC entry 2957 (class 2606 OID 53584)
-- Dependencies: 2580 1997 2083
-- Name: familiar_jugador_representante_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY representante
    ADD CONSTRAINT familiar_jugador_representante_fk FOREIGN KEY (codigo_familiar_jugador) REFERENCES familiar_jugador(codigo_familiar_jugador);


--
-- TOC entry 2735 (class 2606 OID 53589)
-- Dependencies: 2590 2005 1920
-- Name: indicador_actividad_escala_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT indicador_actividad_escala_actividad_planificada_fk FOREIGN KEY (codigo_indicador_actividad_escala) REFERENCES indicador_actividad_escala(codigo_indicador_actividad_escala);


--
-- TOC entry 2738 (class 2606 OID 53594)
-- Dependencies: 1921 2590 2005
-- Name: indicador_actividad_escala_actividades_ejecutadas_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividades_ejecutadas
    ADD CONSTRAINT indicador_actividad_escala_actividades_ejecutadas_fk FOREIGN KEY (codigo_indicador_actividad_escala) REFERENCES indicador_actividad_escala(codigo_indicador_actividad_escala);


--
-- TOC entry 2793 (class 2606 OID 53599)
-- Dependencies: 2592 1964 2007
-- Name: indicador_competencia_desempenno_colectivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_colectivo
    ADD CONSTRAINT indicador_competencia_desempenno_colectivo_fk FOREIGN KEY (codigo_indicador_competencia) REFERENCES indicador_categoria_competencia(codigo_indicador_competencia);


--
-- TOC entry 2794 (class 2606 OID 53604)
-- Dependencies: 1965 2007 2592
-- Name: indicador_competencia_desempenno_individual_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_individual
    ADD CONSTRAINT indicador_competencia_desempenno_individual_fk FOREIGN KEY (codigo_indicador_competencia) REFERENCES indicador_categoria_competencia(codigo_indicador_competencia);


--
-- TOC entry 2856 (class 2606 OID 53609)
-- Dependencies: 2588 2007 2004
-- Name: indicador_indicador_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_categoria_competencia
    ADD CONSTRAINT indicador_indicador_competencia_fk FOREIGN KEY (codigo_indicador) REFERENCES indicador(codigo_indicador);


--
-- TOC entry 2990 (class 2606 OID 53614)
-- Dependencies: 2010 2108 2594
-- Name: indicador_test_test_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test_jugador
    ADD CONSTRAINT indicador_test_test_jugador_fk FOREIGN KEY (codigo_indicador_test) REFERENCES indicador_test(codigo_indicador_test);


--
-- TOC entry 2862 (class 2606 OID 53619)
-- Dependencies: 2596 2012 2013
-- Name: ingreso_ingreso_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_documento_acreedor
    ADD CONSTRAINT ingreso_ingreso_documento_acreedor_fk FOREIGN KEY (numero_documento) REFERENCES ingreso(numero_documento);


--
-- TOC entry 2866 (class 2606 OID 53624)
-- Dependencies: 2596 2014 2012
-- Name: ingreso_ingreso_forma_pago_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ingreso_forma_pago
    ADD CONSTRAINT ingreso_ingreso_forma_pago_fk1 FOREIGN KEY (numero_documento) REFERENCES ingreso(numero_documento);


--
-- TOC entry 2744 (class 2606 OID 53629)
-- Dependencies: 1925 2602 2015
-- Name: instalacion_almacen_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY almacen
    ADD CONSTRAINT instalacion_almacen_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2944 (class 2606 OID 53634)
-- Dependencies: 2602 2015 2073
-- Name: instalacion_plan_rotacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT instalacion_plan_rotacion_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2949 (class 2606 OID 53639)
-- Dependencies: 2077 2015 2602
-- Name: instalacion_planificacion_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY planificacion_actividad
    ADD CONSTRAINT instalacion_planificacion_mantenimiento_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2974 (class 2606 OID 53644)
-- Dependencies: 2015 2602 2095
-- Name: instalacion_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT instalacion_sesion_ejecutada_fk FOREIGN KEY (codigo_instalacion) REFERENCES instalacion(codigo_instalacion);


--
-- TOC entry 2775 (class 2606 OID 53649)
-- Dependencies: 1949 2017 2604
-- Name: institucion_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT institucion_dato_academico_fk FOREIGN KEY (codigo_institucion) REFERENCES institucion(codigo_institucion);


--
-- TOC entry 2790 (class 2606 OID 53654)
-- Dependencies: 1962 2604 2017
-- Name: institucion_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT institucion_dato_social_fk FOREIGN KEY (codigo_institucion) REFERENCES institucion(codigo_institucion);


--
-- TOC entry 2732 (class 2606 OID 53659)
-- Dependencies: 2606 1915 2019
-- Name: juego_actividad_calendario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_calendario
    ADD CONSTRAINT juego_actividad_calendario_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2832 (class 2606 OID 53664)
-- Dependencies: 1988 2019 2606
-- Name: juego_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_juego
    ADD CONSTRAINT juego_equipo_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2878 (class 2606 OID 53669)
-- Dependencies: 2606 2022 2019
-- Name: juego_jugador_foraneo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador_foraneo
    ADD CONSTRAINT juego_jugador_foraneo_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2887 (class 2606 OID 53674)
-- Dependencies: 2030 2019 2606
-- Name: juego_line_up_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT juego_line_up_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2928 (class 2606 OID 53679)
-- Dependencies: 2062 2606 2019
-- Name: juego_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT juego_personal_equipo_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2938 (class 2606 OID 53684)
-- Dependencies: 2068 2019 2606
-- Name: juego_personal_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT juego_personal_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2935 (class 2606 OID 53689)
-- Dependencies: 2067 2606 2019
-- Name: juego_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT juego_umpire_juego_fk FOREIGN KEY (codigo_juego) REFERENCES juego(codigo_juego);


--
-- TOC entry 2776 (class 2606 OID 53694)
-- Dependencies: 1949 2021 2608
-- Name: jugador_dato_academico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico
    ADD CONSTRAINT jugador_dato_academico_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2786 (class 2606 OID 53699)
-- Dependencies: 1959 2021 2608
-- Name: jugador_dato_deportivo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_deportivo
    ADD CONSTRAINT jugador_dato_deportivo_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2787 (class 2606 OID 53704)
-- Dependencies: 1960 2021 2608
-- Name: jugador_dato_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT jugador_dato_medico_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2784 (class 2606 OID 53709)
-- Dependencies: 1957 2021 2608
-- Name: jugador_dato_sancion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_conducta
    ADD CONSTRAINT jugador_dato_sancion_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2791 (class 2606 OID 53714)
-- Dependencies: 1962 2021 2608
-- Name: jugador_dato_social_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_social
    ADD CONSTRAINT jugador_dato_social_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2843 (class 2606 OID 53719)
-- Dependencies: 1997 2021 2608
-- Name: jugador_familiar_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar_jugador
    ADD CONSTRAINT jugador_familiar_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2962 (class 2606 OID 53724)
-- Dependencies: 2087 2021 2608
-- Name: jugador_retiro_traslado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY retiro_traslado
    ADD CONSTRAINT jugador_retiro_traslado_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2964 (class 2606 OID 53729)
-- Dependencies: 2608 2088 2021
-- Name: jugador_roster_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster
    ADD CONSTRAINT jugador_roster_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2981 (class 2606 OID 53734)
-- Dependencies: 2021 2101 2608
-- Name: jugador_talla_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT jugador_talla_por_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES jugador(cedula_rif);


--
-- TOC entry 2882 (class 2606 OID 53739)
-- Dependencies: 2614 2027 2026
-- Name: liga_liga_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_categoria
    ADD CONSTRAINT liga_liga_categoria_fk FOREIGN KEY (codigo_liga) REFERENCES liga(codigo_liga);


--
-- TOC entry 2884 (class 2606 OID 53744)
-- Dependencies: 2026 2029 2614
-- Name: liga_liga_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY liga_competencia
    ADD CONSTRAINT liga_liga_competencia_fk FOREIGN KEY (codigo_liga) REFERENCES liga(codigo_liga);


--
-- TOC entry 2795 (class 2606 OID 53749)
-- Dependencies: 2030 1965 2620
-- Name: line_up_desempenno_individual_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempenno_individual
    ADD CONSTRAINT line_up_desempenno_individual_fk FOREIGN KEY (codigo_line_up) REFERENCES line_up(codigo_line_up);


--
-- TOC entry 2771 (class 2606 OID 53754)
-- Dependencies: 2033 1948 2624
-- Name: material_cuenta_pagar_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT material_cuenta_pagar_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2772 (class 2606 OID 53759)
-- Dependencies: 2033 1948 2624
-- Name: material_cuenta_pagar_material_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar_material
    ADD CONSTRAINT material_cuenta_pagar_material_fk1 FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2799 (class 2606 OID 53764)
-- Dependencies: 2033 1967 2624
-- Name: material_detalle_requisicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_requisicion
    ADD CONSTRAINT material_detalle_requisicion_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2808 (class 2606 OID 53769)
-- Dependencies: 2033 1973 2624
-- Name: material_documento_acreedor_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor_material
    ADD CONSTRAINT material_documento_acreedor_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2819 (class 2606 OID 53774)
-- Dependencies: 1980 2033 2624
-- Name: material_donacion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY donacion_material
    ADD CONSTRAINT material_donacion_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2895 (class 2606 OID 53779)
-- Dependencies: 2034 2033 2624
-- Name: material_material_mantenimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad
    ADD CONSTRAINT material_material_mantenimiento_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2896 (class 2606 OID 53784)
-- Dependencies: 2624 2036 2033
-- Name: material_material_mantenimiento_planificado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad_planificada
    ADD CONSTRAINT material_material_mantenimiento_planificado_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2955 (class 2606 OID 53789)
-- Dependencies: 2033 2082 2624
-- Name: material_recepcion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recepcion_material
    ADD CONSTRAINT material_recepcion_material_fk FOREIGN KEY (codigo_material) REFERENCES material(codigo_material);


--
-- TOC entry 2788 (class 2606 OID 53794)
-- Dependencies: 2038 1960 2630
-- Name: medico_dato_medico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_medico
    ADD CONSTRAINT medico_dato_medico_fk FOREIGN KEY (numero_colegio) REFERENCES medico(numero_colegio);


--
-- TOC entry 2903 (class 2606 OID 53799)
-- Dependencies: 2044 2042 2638
-- Name: nomina_movimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT nomina_movimiento_fk FOREIGN KEY (codigo_nomina) REFERENCES nomina(codigo_nomina);


--
-- TOC entry 2956 (class 2606 OID 53804)
-- Dependencies: 2046 2082 2640
-- Name: nota_entrega_recepcion_material_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recepcion_material
    ADD CONSTRAINT nota_entrega_recepcion_material_fk FOREIGN KEY (codigo_nota_entrega) REFERENCES nota_entrega(codigo_nota_entrega);


--
-- TOC entry 2769 (class 2606 OID 53809)
-- Dependencies: 2050 1947 2644
-- Name: persona_cuenta_pagar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cuenta_pagar
    ADD CONSTRAINT persona_cuenta_pagar_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2805 (class 2606 OID 53814)
-- Dependencies: 2050 1971 2644
-- Name: persona_documento_acreedor_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT persona_documento_acreedor_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2806 (class 2606 OID 53819)
-- Dependencies: 1971 2644 2050
-- Name: persona_documento_acreedor_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_acreedor
    ADD CONSTRAINT persona_documento_acreedor_fk1 FOREIGN KEY (cedula_atleta) REFERENCES persona(cedula_rif);


--
-- TOC entry 2830 (class 2606 OID 53824)
-- Dependencies: 1986 2050 2644
-- Name: persona_equipo_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY equipo_competencia
    ADD CONSTRAINT persona_equipo_competencia_fk FOREIGN KEY (delegado) REFERENCES persona(cedula_rif);


--
-- TOC entry 2838 (class 2606 OID 53829)
-- Dependencies: 2644 1995 2050
-- Name: persona_familiar_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY familiar
    ADD CONSTRAINT persona_familiar_fk FOREIGN KEY (cedula_familiar) REFERENCES persona(cedula_rif);


--
-- TOC entry 2875 (class 2606 OID 53834)
-- Dependencies: 2050 2021 2644
-- Name: persona_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT persona_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2951 (class 2606 OID 53839)
-- Dependencies: 2051 2079 2646
-- Name: persona_juridica_proveedor_banco_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY proveedor_banco
    ADD CONSTRAINT persona_juridica_proveedor_banco_fk FOREIGN KEY (cedula_rif) REFERENCES persona_juridica(cedula_rif);


--
-- TOC entry 2915 (class 2606 OID 53844)
-- Dependencies: 2052 2053 2648
-- Name: persona_natural_personal_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT persona_natural_personal_fk1 FOREIGN KEY (cedula_rif) REFERENCES persona_natural(cedula_rif);


--
-- TOC entry 2912 (class 2606 OID 53849)
-- Dependencies: 2050 2051 2644
-- Name: persona_persona_juridica_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_juridica
    ADD CONSTRAINT persona_persona_juridica_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2914 (class 2606 OID 53854)
-- Dependencies: 2050 2052 2644
-- Name: persona_persona_natural_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona_natural
    ADD CONSTRAINT persona_persona_natural_fk FOREIGN KEY (cedula_rif) REFERENCES persona(cedula_rif);


--
-- TOC entry 2987 (class 2606 OID 53859)
-- Dependencies: 2055 2104 2104 2055 2654
-- Name: personal_actividad_planificada_tarea_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT personal_actividad_planificada_tarea_actividad_planificada_fk FOREIGN KEY (cedula_rif, codigo_planificacion_actividad) REFERENCES personal_actividad_planificada(cedula_rif, codigo_planificacion_actividad);


--
-- TOC entry 2985 (class 2606 OID 53864)
-- Dependencies: 2652 2102 2102 2054 2054
-- Name: personal_actividad_tarea_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad
    ADD CONSTRAINT personal_actividad_tarea_actividad_fk FOREIGN KEY (cedula_rif, codigo_actividad) REFERENCES personal_actividad(cedula_rif, codigo_actividad);


--
-- TOC entry 2743 (class 2606 OID 53869)
-- Dependencies: 2053 1924 2650
-- Name: personal_afeccion_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afeccion_personal
    ADD CONSTRAINT personal_afeccion_personal_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2777 (class 2606 OID 53874)
-- Dependencies: 2053 1951 2650
-- Name: personal_dato_academico_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_academico_personal
    ADD CONSTRAINT personal_dato_academico_personal_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2918 (class 2606 OID 53879)
-- Dependencies: 2053 2055 2650
-- Name: personal_empleado_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad_planificada
    ADD CONSTRAINT personal_empleado_actividad_planificada_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2748 (class 2606 OID 53884)
-- Dependencies: 2062 1931 2662
-- Name: personal_equipo_asistencia_personal_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT personal_equipo_asistencia_personal_entrenamiento_fk FOREIGN KEY (codigo_personal_equipo) REFERENCES personal_equipo(codigo_personal_equipo);


--
-- TOC entry 2932 (class 2606 OID 53889)
-- Dependencies: 2062 2064 2662
-- Name: personal_equipo_personal_equipo_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo_juego
    ADD CONSTRAINT personal_equipo_personal_equipo_juego_fk FOREIGN KEY (codigo_personal_equipo) REFERENCES personal_equipo(codigo_personal_equipo);


--
-- TOC entry 2904 (class 2606 OID 53894)
-- Dependencies: 2042 2650 2053
-- Name: personal_movimiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT personal_movimiento_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2917 (class 2606 OID 53899)
-- Dependencies: 2053 2054 2650
-- Name: personal_personal_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad
    ADD CONSTRAINT personal_personal_actividad_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2921 (class 2606 OID 53904)
-- Dependencies: 2650 2053 2056
-- Name: personal_personal_cargo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_cargo
    ADD CONSTRAINT personal_personal_cargo_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2923 (class 2606 OID 53909)
-- Dependencies: 2058 2650 2053
-- Name: personal_personal_concepto_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_concepto_nomina
    ADD CONSTRAINT personal_personal_concepto_nomina_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2926 (class 2606 OID 53914)
-- Dependencies: 2053 2060 2650
-- Name: personal_personal_contrato_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_contrato
    ADD CONSTRAINT personal_personal_contrato_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2929 (class 2606 OID 53919)
-- Dependencies: 2650 2062 2053
-- Name: personal_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT personal_personal_equipo_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2939 (class 2606 OID 53924)
-- Dependencies: 2650 2068 2053
-- Name: personal_personal_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_juego
    ADD CONSTRAINT personal_personal_juego_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2941 (class 2606 OID 53929)
-- Dependencies: 2650 2069 2053
-- Name: personal_personal_tipo_nomina_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_tipo_nomina
    ADD CONSTRAINT personal_personal_tipo_nomina_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2958 (class 2606 OID 53934)
-- Dependencies: 2650 2084 2053
-- Name: personal_requisicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY requisicion
    ADD CONSTRAINT personal_requisicion_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2994 (class 2606 OID 53939)
-- Dependencies: 2650 2115 2053
-- Name: personal_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT personal_usuario_fk FOREIGN KEY (cedula_rif) REFERENCES personal(cedula_rif);


--
-- TOC entry 2975 (class 2606 OID 53944)
-- Dependencies: 2674 2071 2095
-- Name: plan_entrenamiento_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT plan_entrenamiento_sesion_ejecutada_fk FOREIGN KEY (codigo_plan_entrenamiento) REFERENCES plan_entrenamiento(codigo_plan_entrenamiento);


--
-- TOC entry 2782 (class 2606 OID 53949)
-- Dependencies: 2674 1955 2071
-- Name: plan_entrenamiento_sesion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion
    ADD CONSTRAINT plan_entrenamiento_sesion_fk FOREIGN KEY (codigo_plan_entrenamiento) REFERENCES plan_entrenamiento(codigo_plan_entrenamiento);


--
-- TOC entry 2976 (class 2606 OID 53954)
-- Dependencies: 2676 2095 2073
-- Name: plan_rotacion_sesion_ejecutada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sesion_ejecutada
    ADD CONSTRAINT plan_rotacion_sesion_ejecutada_fk FOREIGN KEY (codigo_plan_rotacion) REFERENCES plan_rotacion(codigo_plan_rotacion);


--
-- TOC entry 2728 (class 2606 OID 53959)
-- Dependencies: 2680 1914 2077
-- Name: planificacion_actividad_actividad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT planificacion_actividad_actividad_fk FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2919 (class 2606 OID 53964)
-- Dependencies: 2077 2680 2055
-- Name: planificacion_mantenimiento_empleado_mantenimiento_planifica195; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_actividad_planificada
    ADD CONSTRAINT planificacion_mantenimiento_empleado_mantenimiento_planifica195 FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2897 (class 2606 OID 53969)
-- Dependencies: 2680 2077 2036
-- Name: planificacion_mantenimiento_material_mantenimiento_planifica583; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY material_actividad_planificada
    ADD CONSTRAINT planificacion_mantenimiento_material_mantenimiento_planifica583 FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2909 (class 2606 OID 53974)
-- Dependencies: 2048 2077 2680
-- Name: planificacion_mantenimiento_periodicidad_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY periodicidad
    ADD CONSTRAINT planificacion_mantenimiento_periodicidad_fk FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2988 (class 2606 OID 53979)
-- Dependencies: 2104 2077 2680
-- Name: planificacion_mantenimiento_tarea_mantenimiento_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tarea_actividad_planificada
    ADD CONSTRAINT planificacion_mantenimiento_tarea_mantenimiento_planificada_fk FOREIGN KEY (codigo_planificacion_actividad) REFERENCES planificacion_actividad(codigo_planificacion_actividad);


--
-- TOC entry 2813 (class 2606 OID 53984)
-- Dependencies: 1976 2080 2684
-- Name: recaudo_por_proceso_documento_entregado_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_entregado
    ADD CONSTRAINT recaudo_por_proceso_documento_entregado_fk FOREIGN KEY (codigo_recaudo_por_proceso) REFERENCES recaudo_por_proceso(codigo_recaudo_por_proceso);


--
-- TOC entry 2800 (class 2606 OID 53989)
-- Dependencies: 2084 1967 2690
-- Name: requisicion_detalle_requisicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_requisicion
    ADD CONSTRAINT requisicion_detalle_requisicion_fk FOREIGN KEY (codigo_requisicion) REFERENCES requisicion(codigo_requisicion);


--
-- TOC entry 2745 (class 2606 OID 53994)
-- Dependencies: 2088 2696 1927
-- Name: roster_ascenso_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ascenso
    ADD CONSTRAINT roster_ascenso_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2888 (class 2606 OID 53999)
-- Dependencies: 2030 2090 2698
-- Name: roster_competencia_line_up_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY line_up
    ADD CONSTRAINT roster_competencia_line_up_fk FOREIGN KEY (codigo_roster_competencia) REFERENCES roster_competencia(codigo_roster_competencia);


--
-- TOC entry 2968 (class 2606 OID 54004)
-- Dependencies: 2696 2090 2088
-- Name: roster_roster_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roster_competencia
    ADD CONSTRAINT roster_roster_competencia_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2991 (class 2606 OID 54009)
-- Dependencies: 2088 2108 2696
-- Name: roster_test_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY test_jugador
    ADD CONSTRAINT roster_test_jugador_fk FOREIGN KEY (codigo_roster) REFERENCES roster(codigo_roster);


--
-- TOC entry 2736 (class 2606 OID 54014)
-- Dependencies: 2520 1955 1920
-- Name: sesion_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT sesion_actividad_planificada_fk FOREIGN KEY (codigo_sesion) REFERENCES sesion(codigo_sesion);


--
-- TOC entry 2739 (class 2606 OID 54019)
-- Dependencies: 2095 1921 2702
-- Name: sesion_ejecutada_actividades_ejecutadas_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividades_ejecutadas
    ADD CONSTRAINT sesion_ejecutada_actividades_ejecutadas_fk FOREIGN KEY (codigo_sesion_ejecutada) REFERENCES sesion_ejecutada(codigo_sesion_ejecutada);


--
-- TOC entry 2747 (class 2606 OID 54024)
-- Dependencies: 1929 2702 2095
-- Name: sesion_ejecutada_asistencia_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_jugador
    ADD CONSTRAINT sesion_ejecutada_asistencia_jugador_fk FOREIGN KEY (codigo_sesion_ejecutada) REFERENCES sesion_ejecutada(codigo_sesion_ejecutada);


--
-- TOC entry 2749 (class 2606 OID 54029)
-- Dependencies: 1931 2095 2702
-- Name: sesion_ejecutada_asistencia_personal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT sesion_ejecutada_asistencia_personal_fk FOREIGN KEY (codigo_sesion_ejecutada) REFERENCES sesion_ejecutada(codigo_sesion_ejecutada);


--
-- TOC entry 2945 (class 2606 OID 54034)
-- Dependencies: 2073 1955 2520
-- Name: sesion_plan_rotacion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_rotacion
    ADD CONSTRAINT sesion_plan_rotacion_fk FOREIGN KEY (codigo_sesion) REFERENCES sesion(codigo_sesion);


--
-- TOC entry 2815 (class 2606 OID 54039)
-- Dependencies: 1977 2099 2706
-- Name: talla_por_indumentaria_documento_indumentaria_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY documento_indumentaria
    ADD CONSTRAINT talla_por_indumentaria_documento_indumentaria_fk FOREIGN KEY (codigo_talla_indumentaria) REFERENCES talla_por_indumentaria(codigo_talla_indumentaria);


--
-- TOC entry 2982 (class 2606 OID 54044)
-- Dependencies: 2101 2099 2706
-- Name: talla_por_indumentaria_talla_por_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY talla_por_jugador
    ADD CONSTRAINT talla_por_indumentaria_talla_por_jugador_fk FOREIGN KEY (codigo_talla_indumentaria) REFERENCES talla_por_indumentaria(codigo_talla_indumentaria);


--
-- TOC entry 2760 (class 2606 OID 54049)
-- Dependencies: 1938 2024 2612
-- Name: temporada_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT temporada_competencia_fk FOREIGN KEY (codigo_lapso_deportivo) REFERENCES lapso_deportivo(codigo_lapso_deportivo);


--
-- TOC entry 2846 (class 2606 OID 54054)
-- Dependencies: 2000 2075 2678
-- Name: temporada_horario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY horario
    ADD CONSTRAINT temporada_horario_fk FOREIGN KEY (codigo_plan_temporada) REFERENCES plan_temporada(codigo_plan_temporada);


--
-- TOC entry 2930 (class 2606 OID 54059)
-- Dependencies: 2062 2075 2678
-- Name: temporada_personal_equipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_equipo
    ADD CONSTRAINT temporada_personal_equipo_fk FOREIGN KEY (codigo_plan_temporada) REFERENCES plan_temporada(codigo_plan_temporada);


--
-- TOC entry 2942 (class 2606 OID 54064)
-- Dependencies: 2071 2075 2678
-- Name: temporada_plan_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_entrenamiento
    ADD CONSTRAINT temporada_plan_entrenamiento_fk FOREIGN KEY (codigo_plan_temporada) REFERENCES plan_temporada(codigo_plan_temporada);


--
-- TOC entry 2947 (class 2606 OID 54069)
-- Dependencies: 2075 2024 2612
-- Name: temporada_plan_temporada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY plan_temporada
    ADD CONSTRAINT temporada_plan_temporada_fk FOREIGN KEY (codigo_lapso_deportivo) REFERENCES lapso_deportivo(codigo_lapso_deportivo);


--
-- TOC entry 2859 (class 2606 OID 54074)
-- Dependencies: 2106 2714 2010
-- Name: test_evaluativo_indicador_test_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_test
    ADD CONSTRAINT test_evaluativo_indicador_test_fk FOREIGN KEY (codigo_test) REFERENCES test_evaluativo(codigo_test);


--
-- TOC entry 2761 (class 2606 OID 54079)
-- Dependencies: 1938 2109 2718
-- Name: tipo_competencia_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY competencia
    ADD CONSTRAINT tipo_competencia_competencia_fk FOREIGN KEY (codigo_tipo_competencia) REFERENCES tipo_competencia(codigo_tipo_competencia);


--
-- TOC entry 2764 (class 2606 OID 54084)
-- Dependencies: 2718 2109 1942
-- Name: tipo_competencia_condicion_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY condicion_competencia
    ADD CONSTRAINT tipo_competencia_condicion_competencia_fk FOREIGN KEY (codigo_tipo_competencia) REFERENCES tipo_competencia(codigo_tipo_competencia);


--
-- TOC entry 2899 (class 2606 OID 54089)
-- Dependencies: 2039 2718 2109
-- Name: tipo_competencia_modalidad_competencia_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY modalidad_competencia
    ADD CONSTRAINT tipo_competencia_modalidad_competencia_fk FOREIGN KEY (codigo_tipo_competencia) REFERENCES tipo_competencia(codigo_tipo_competencia);


--
-- TOC entry 2779 (class 2606 OID 54094)
-- Dependencies: 2720 2111 1953
-- Name: tipo_dato_dato_basico_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dato_basico
    ADD CONSTRAINT tipo_dato_dato_basico_fk FOREIGN KEY (codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 2970 (class 2606 OID 54099)
-- Dependencies: 2092 2111 2720
-- Name: tipo_dato_seguridad_funcional_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT tipo_dato_seguridad_funcional_fk FOREIGN KEY (codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 2992 (class 2606 OID 54104)
-- Dependencies: 2720 2111 2111
-- Name: tipo_dato_tipo_dato_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_dato
    ADD CONSTRAINT tipo_dato_tipo_dato_fk FOREIGN KEY (parent_codigo_tipo_dato) REFERENCES tipo_dato(codigo_tipo_dato);


--
-- TOC entry 2936 (class 2606 OID 54109)
-- Dependencies: 2065 2067 2666
-- Name: umpire_umpire_juego_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal_foraneo_juego
    ADD CONSTRAINT umpire_umpire_juego_fk FOREIGN KEY (codigo_personal_foraneo) REFERENCES personal_foraneo(codigo_personal_foraneo);


--
-- TOC entry 2737 (class 2606 OID 54114)
-- Dependencies: 2724 2115 1920
-- Name: usuario_actividad_planificada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad_planificada
    ADD CONSTRAINT usuario_actividad_planificada_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 2750 (class 2606 OID 54119)
-- Dependencies: 1931 2115 2724
-- Name: usuario_asistencia_personal_entrenamiento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY asistencia_personal_entrenamiento
    ADD CONSTRAINT usuario_asistencia_personal_entrenamiento_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 2798 (class 2606 OID 54124)
-- Dependencies: 2115 1966 2724
-- Name: usuario_desempeo_jugador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desempeo_jugador
    ADD CONSTRAINT usuario_desempeo_jugador_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 2971 (class 2606 OID 54129)
-- Dependencies: 2115 2092 2724
-- Name: usuario_seguridad_funcional_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seguridad_funcional
    ADD CONSTRAINT usuario_seguridad_funcional_fk FOREIGN KEY (cedula_rif) REFERENCES usuario(cedula_rif);


--
-- TOC entry 3001 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2011-12-31 01:22:49

--
-- PostgreSQL database dump complete
--

