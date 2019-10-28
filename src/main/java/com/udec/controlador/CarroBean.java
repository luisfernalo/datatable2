/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.controlador;

import com.udec.Modelo.Carro;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author luis fernando
 */
@Named(value = "carroBean")
@RequestScoped
public class CarroBean {

    private Carro carro = new Carro();
    private static List<Carro> listacarros = new ArrayList();
    String[] marcasmenu = {"Nissan", "Hyundai", "Chevrolet", "Kia"};
    private String nombre;
    private String marca;
    private int modelo;

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getListacarros() {
        return listacarros;
    }

    public void setListacarros(List<Carro> listacarros) {
        CarroBean.listacarros = listacarros;
    }

    public String[] getMarcasmenu() {
        return marcasmenu;
    }

    public void setMarcasmenu(String[] marcasmenu) {
        this.marcasmenu = marcasmenu;
    }

    public void agregarCarro() {
        try {
            Logger.getLogger(CarroBean.class.getName()).log(Level.INFO,
                    "se agrego un carro nombre:" + carro.getNombre()
                    + " marca:" + carro.getMarca()
                    + " modelo:" + carro.getModelo(), carro);
            CarroBean.listacarros.add(this.carro);
        } catch (Exception ex) {
            Logger.getLogger(CarroBean.class.getName()).log(Level.WARNING, "error", ex);

        }

    }

    public void eliminarCarro(Carro car) {
        try {
            Logger.getLogger(CarroBean.class.getName()).log(Level.INFO,
                    "se elimino el carro nombre:" + car.getNombre()
                    + " marca:" + car.getMarca()
                    + " modelo:" + car.getModelo(), car);
            listacarros.remove(car);
        } catch (Exception ex) {
            Logger.getLogger(CarroBean.class.getName()).log(Level.WARNING, "error", ex);

        }
    }

    public void actualizar(RowEditEvent event) {
        Carro carroactualizar = (Carro) event.getObject();
        try {
            if (nombre != "") {
                Logger.getLogger(CarroBean.class.getName()).log(Level.INFO,
                        "anteriores nombre: " + carroactualizar.getNombre()+ 
                                " por nombre:" + nombre, carro);
                carroactualizar.setNombre(nombre);
            }
            if (marca != "") {
                Logger.getLogger(CarroBean.class.getName()).log(Level.INFO,
                        "anteriores marca: " + carroactualizar.getMarca()+ 
                                " por marca:" + marca, carro);
                carroactualizar.setMarca(marca);
            }
            if (modelo != 0) {
                Logger.getLogger(CarroBean.class.getName()).log(Level.INFO,
                        "anteriores modelo: " + carroactualizar.getModelo()+ 
                                " por modelo:" + modelo, carro);
                carroactualizar.setModelo(modelo);
            }
        } catch (Exception ex) {
            Logger.getLogger(CarroBean.class.getName()).log(Level.WARNING, "error", ex);
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actualizado"));

    }

    public void cancelar(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancelado"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public CarroBean() {
    }

}
