package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import controlador.HibernateUtil;

public class GestorProvincias {

    public ArrayList<Provincias> cargarProvincias() {
        try (Session sesion = sesion()) {
            return (ArrayList<Provincias>) 
                sesion.createQuery("from Provincias", Provincias.class).list();
        }
    }

    public void incluir() {

        Session sesion = sesion();
        Transaction tx = null;

        try {
            tx = sesion.beginTransaction();

            Provincias provincia = new Provincias();
            provincia.setNombre("ProvinciaPrueba");
            sesion.persist(provincia);
            sesion.flush();

            Municipios municipio = new Municipios();
            municipio.setCodMunicipio(9999);
            municipio.setNombre("MunicipioPrueba");
            municipio.setDescripcion("Descripción de prueba");
            sesion.persist(municipio);
            sesion.flush();

            EspaciosNaturales espacio = new EspaciosNaturales();
            espacio.setNombre("EspacioPrueba");
            espacio.setDescripcion("Descripción");
            espacio.setTipo("Tipo");
            espacio.setCategoria("Categoria");
            espacio.setLatitud(43.0);
            espacio.setLongitud(-2.0);
            sesion.persist(espacio);
            sesion.flush();

            MunicipiosEspaciosNatId meId = new MunicipiosEspaciosNatId();
            meId.setIdMunicipio(municipio.getIdMunicipio());
            meId.setIdEspacio(espacio.getIdEspacio());

            MunicipiosEspaciosNat me = new MunicipiosEspaciosNat();
            me.setId(meId);
            sesion.persist(me);

            CentrosMeteorologicos centro = new CentrosMeteorologicos();
            centro.setNombre("CentroPrueba");
            centro.setDireccion("Dirección de prueba");
            centro.setLatitud(43.1);
            centro.setLongitud(-2.1);
            centro.setUrl("URL prueba");
            sesion.persist(centro);
            sesion.flush();            

            MedicionesCentroMetId medId = new MedicionesCentroMetId();
            medId.setIdCentroMet(centro.getIdCentroMet());
            medId.setFecha(Date.valueOf(LocalDate.now()));
            medId.setHora(Time.valueOf(LocalTime.now()));

            MedicionesCentroMet medicion = new MedicionesCentroMet();
            medicion.setTempAmbiente(22.5f);
            medicion.setDirViento(123);
            medicion.setVViento(5.6f);
            medicion.setHRelativa(70);
            medicion.setPrecip(0.0f);
            medicion.setRadSolar(100f);
            medicion.setPAtmosferica(1010f);
            medicion.setIca("Bueno");
            medicion.setId(medId);
            sesion.persist(medicion);

            tx.commit();
            System.out.println("Todo creado correctamente");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            sesion.close();
        }
    }

    private static Session sesion() {
        return HibernateUtil.getSessionFactory().openSession();
    }

}
