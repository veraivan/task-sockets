
create database bd_suministro;
\c bd_suministro

create table registro_operaciones (
    id serial,
    fecha_hora timestamp,
    origen_ip text,
    destino_ip text,
    tipo_operacion text
);

create table consumo (
    id serial,
    descripcion text,
    potencia_en_watts integer,
    horas_utilizacion integer,
    consumo_mensual integer, 
    id_nis integer
);