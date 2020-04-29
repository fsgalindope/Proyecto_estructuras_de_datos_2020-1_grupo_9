package data;

import Estructuras_de_datos.MyArrayList;
import java.io.Serializable;


public class RawMaterial implements Serializable{
    private String name;
    private String admissionDate;
    private String expirationDate;
    private String batch;
    private String description;
    private MyArrayList parametrosCalidad;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MyArrayList getParametrosCalidad() {
        return parametrosCalidad;
    }

    public void setParametrosCalidad(MyArrayList parametrosCalidad) {
        this.parametrosCalidad = parametrosCalidad;
    }

    public RawMaterial(String admissionDate, String expirationDate,
                       String batch, String description, MyArrayList parametrosCalidad) {

        this.admissionDate = admissionDate;
        this.expirationDate = expirationDate;
        this.batch = batch;
        this.description = description;
        this.parametrosCalidad = parametrosCalidad;
    }

    public RawMaterial(String name, String admissionDate, String expirationDate, String batch, String description, MyArrayList parametrosCalidad) {
        this.name = name;
        this.admissionDate = admissionDate;
        this.expirationDate = expirationDate;
        this.batch = batch;
        this.description = description;
        this.parametrosCalidad = parametrosCalidad;
    }
    
}
