package id.ac.umn.uts1_37928;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class SFX implements Serializable {
    private String title;
    private String keterangan;
    private String SfxURI;
    public SFX (String title, String keterangan, String sfxURI){
        this.title = title;
        this.keterangan = keterangan;
        this.SfxURI = sfxURI;
    }
    public String getTitle() {
        return this.title;
    }
    public String getKeterangan() {
        return this.keterangan;
    }
    public String getSfxURI() {
        return this.SfxURI;
    }

    @NonNull
    public String toString() {
        return this.getTitle() + " => " + this.getKeterangan();
    }
}
