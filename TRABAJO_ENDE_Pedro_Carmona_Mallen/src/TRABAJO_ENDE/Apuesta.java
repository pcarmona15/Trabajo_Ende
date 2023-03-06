package TRABAJO_ENDE;

// TODO: Auto-generated Javadoc
/**
 * The Class Apuesta.
 */
/**
 * 
 * @author Pedro Carmona Mallén
 * @version Version final del documento.
 */
public class Apuesta {

    /**
     * Gets the goles local.
     *
     * @return the goles_local
     */
    
	public int getGoles_local() {
        return goles_local;
    }

    /**
     * Sets the goles local.
     *
     * @param goles_local the goles_local to set
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * Gets the goles visitante.
     *
     * @return the goles_visitante
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Sets the goles visitante.
     *
     * @param goles_visitante the goles_visitante to set
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Gets the apostado.
     *
     * @return the apostado
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Sets the apostado.
     *
     * @param apostado the apostado to set
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }
    
    /** The dinero disp. */
    private int dinero_disp;
    
    /** The goles local. */
    private int goles_local;
    
    /** The goles visitante. */
    private int goles_visitante;
    
    /** The apostado. */
    private int apostado;

    /**
     * Instantiates a new apuesta.
     */
    /*Contructor por defecto*/
    public Apuesta() {
    }

    /**
     * Instantiates a new apuesta.
     *
     * @param dinero_disp the dinero disp
     * @param goles_local the goles local
     * @param goles_visitante the goles visitante
     */
    /*Contructor por parámetros*/
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    /*Método para obtener el valor del atributo dinero_disp*/

    /**
     * Gets the dinero disp.
     *
     * @return the dinero disp
     */
    public int getDinero_disp() {
        return dinero_disp;
    }
    /*Método para modificar el valor del atributo dinero_disp*/

    /**
     * Sets the dinero disp.
     *
     * @param dinero_disp the new dinero disp
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Apostar.
     *
     * @param dinero the dinero
     * @throws Exception the exception
     */
    /*Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    /*Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * 
     */

    /**
     * Comprobar resultado.
     *
     * @param local the local
     * @param visitante the visitante
     * @return true, if successful
     * @throws Exception the exception
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     */

    /**
     * Cobrar apuesta.
     *
     * @param cantidad_goles_local the cantidad goles local
     * @param cantidad_goles_visit the cantidad goles visit
     * @throws Exception the exception
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}

