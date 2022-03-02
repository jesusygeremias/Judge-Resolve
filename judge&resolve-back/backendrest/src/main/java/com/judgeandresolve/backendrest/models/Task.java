package com.judgeandresolve.backendrest.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "judge_resolve_task")
@NamedQueries({
        @NamedQuery(name = Task.FIND_ALL, query = "select t from Task t")
})
@ToString @EqualsAndHashCode
public class Task {

    public static final String FIND_ALL = "findAll";

    @Id
    @Getter @Setter
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "resumen")
    private String resumen;

    @Getter @Setter
    @Column(name = "resuelta")
    private Boolean resuelta;

    @Getter @Setter
    @Column(name = "fecha_proximo_juicio")
    private Date fechaProximoJuicio;

    @Getter @Setter
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Getter @Setter
    @Column(name = "creador")
    private Long creador;

    @Getter @Setter
    @Column(name = "juez")
    private Long juez;

}
