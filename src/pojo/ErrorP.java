package pojo;

import java.util.Objects;

public class ErrorP {
    private String description;
    private String catalogTruId;
    private String mat;
    private String par;

    public ErrorP(String description, String catalogTruId, String mat, String par) {
        this.description = description;
        this.catalogTruId = catalogTruId;
        this.mat = mat;
        this.par = par;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatalogTruId() {
        return catalogTruId;
    }

    public void setCatalogTruId(String catalogTruId) {
        this.catalogTruId = catalogTruId;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorP errorP = (ErrorP) o;
        return description.equals(errorP.description) && catalogTruId.equals(errorP.catalogTruId) && Objects.equals(mat, errorP.mat) && Objects.equals(par, errorP.par);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, catalogTruId, mat, par);
    }
}
