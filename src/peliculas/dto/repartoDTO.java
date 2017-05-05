
package peliculas.dto;

public class repartoDTO {
    private int id;
    private int peliculaId;
    private int actorId;
    private String reparto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }
    
}
