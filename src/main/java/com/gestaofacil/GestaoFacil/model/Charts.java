// package com.gestaofacil.GestaoFacil.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.NotNull;

// @Entity
// public class Charts {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotEmpty
//     private String name;

//     @NotNull
//     private Double value;

//     @NotEmpty
//     private String tipo;

//     public Charts() {
        
//     }

//     public Charts(String name, Double value) {
//         this.name = name;
//         this.value = value;
//     }

//     public String getTipo() {
//         return tipo;
//     }

//     public void setTipo(String tipo) {
//         this.tipo = tipo;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Double getValue() {
//         return value;
//     }

//     public void setValue(Double value) {
//         this.value = value;
//     }
// }
