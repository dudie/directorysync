package fr.dudie.directorysync.service.model;

import java.io.Serializable;
import java.net.URI;

public class RemoteFile implements Serializable {

    private String name;

    private URI uri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

}
