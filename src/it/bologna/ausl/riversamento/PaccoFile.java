/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.riversamento;

import java.io.File;
import java.util.UUID;

/**
 *
 * @author andrea
 */
class PaccoFile {

    private File file;
    private String fileName;
    private UUID id;
    private String mime = "binary/octet-stream";

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public PaccoFile() {
        id = UUID.randomUUID();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
