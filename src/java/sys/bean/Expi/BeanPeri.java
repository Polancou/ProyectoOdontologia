/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean.Expi;

import sys.model.pacientes.TestPeri;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sys.dao.daoConsultaPaciente;
import sys.imp.ConsultaPacienteImp;
import sys.model.pacientes.Periodontograma;
/**
 *
 * @author polancou
 */
@Named(value = "beanPeri")
@ViewScoped
public class BeanPeri implements Serializable  {
    private String dienteimg;
    private String dienteBD;
    public static Periodontograma periodonto;
    
    /**
     * Creates a new instance of BeanPeri
     */
    @PostConstruct
    public void init(){
        String cadena = "svg/dientes/18.png,svg/dientes/17.png,svg/dientes/16.png,svg/dientes/15.png,svg/dientes/14.png,svg/dientes/13.png,svg/dientes/12.png,svg/dientes/11.png,svg/dientes/21.png,svg/dientes/22.png,svg/dientes/23.png,svg/dientes/24.png,svg/dientes/25.png,svg/dientes/26.png,svg/dientes/27.png,svg/dientes/28.png,svg/dientes/55.png,svg/dientes/54.png,svg/dientes/53.png,svg/dientes/52.png,svg/dientes/51.png,svg/dientes/61.png,svg/dientes/62.png,svg/dientes/63.png,svg/dientes/64.png,svg/dientes/65.png,svg/dientes/85.png,svg/dientes/84.png,svg/dientes/83.png,svg/dientes/82.png,svg/dientes/81.png,svg/dientes/71.png,svg/dientes/72.png,svg/dientes/73.png,svg/dientes/74.png,svg/dientes/75.png,svg/dientes/48.png,svg/dientes/47.png,svg/dientes/46.png,svg/dientes/45.png,svg/dientes/44.png,svg/dientes/43.png,svg/dientes/42.png,svg/dientes/41.png,svg/dientes/31.png,svg/dientes/32.png,svg/dientes/33.png,svg/dientes/34.png,svg/dientes/35.png,svg/dientes/36.png,svg/dientes/37.png,svg/dientes/38.png";
        String dienteperi = periodonto.getDientes();
        if (dienteperi == null){
            periodonto.setDientes(cadena);
        }
    
    }
    
    public Periodontograma getPeriodontograma(){
        return periodonto;
    }
    
    public BeanPeri() {
        periodonto = new Periodontograma();
    }

    public String getDienteBD() {
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        String dientes = bdao.verPeriodontograma();
        this.dienteBD=dientes;
        return dienteBD;
    }

    public void setDienteBD(String dienteBD) {
        this.dienteBD = dienteBD;
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El Odontograma se guardÃ³ con Ã©xito da click en siguiente para continuar", "")); 
    }
    
    public void Obtienetodo(){
        String nuevotexto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nuevotexto");
        periodonto.setDientes(nuevotexto);
    }

    /**
     * @return the dienteimg
     */
    public String getDienteimg() {
        return dienteimg;
    }

    /**
     * @param dienteimg the dienteimg to set
     */
    public void setDienteimg(String dienteimg) {
        this.dienteimg = dienteimg;
    }

    
}
