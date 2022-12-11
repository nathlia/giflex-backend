package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArtifactSubstatId implements Serializable {

    private static final long serialVersionUID = 1L;

    private int artifact;
    private int substat;

    public ArtifactSubstatId() {
    }

    public ArtifactSubstatId(int artifact, int substat) {
        super();
        this.artifact = artifact;
        this.substat = substat;
    }

    public int getArtifact() {
        return artifact;
    }

    public void setArtifact(int artifact) {
        this.artifact = artifact;
    }

    public int getSubstat() {
        return substat;
    }

    public void setSubstat(int substat) {
        this.substat = substat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtifactSubstatId that = (ArtifactSubstatId) o;
        return artifact == that.artifact && substat == that.substat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifact, substat);
    }

}
