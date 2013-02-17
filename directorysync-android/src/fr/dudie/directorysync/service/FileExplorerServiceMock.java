package fr.dudie.directorysync.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.androidannotations.annotations.EBean;

import fr.dudie.directorysync.service.model.RemoteFile;

@EBean
public class FileExplorerServiceMock {

    public List<RemoteFile> list() {
        final List<RemoteFile> files = new ArrayList<RemoteFile>();
        files.add(createMock("pacman"));
        files.add(createMock("pacman"));
        files.add(createMock("pear"));
        files.add(createMock("perl5"));
        files.add(createMock("pgadmin3"));
        files.add(createMock("phonon"));
        files.add(createMock("pixmaps"));
        files.add(createMock("pkgconfig"));
        files.add(createMock("polkit-1"));
        files.add(createMock("poppler"));
        files.add(createMock("postgresql"));
        files.add(createMock("ppd"));
        files.add(createMock("pygobject"));
        files.add(createMock("pygtk"));
        files.add(createMock("qalculate"));
        files.add(createMock("qt"));
        files.add(createMock("readline"));
        files.add(createMock("redland"));
        files.add(createMock("sane"));
        files.add(createMock("sgml"));
        files.add(createMock("shared-color-profiles"));
        files.add(createMock("sip"));
        files.add(createMock("smartmontools"));
        files.add(createMock("smplayer"));
        files.add(createMock("snmp"));
        files.add(createMock("soprano"));
        files.add(createMock("sounds"));
        files.add(createMock("sqliteman"));
        files.add(createMock("ss"));
        files.add(createMock("strigi"));
        files.add(createMock("subversion"));
        files.add(createMock("svnqt"));
        files.add(createMock("syslog-ng"));
        files.add(createMock("system-config-printer"));
        files.add(createMock("systemd"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return files;
    }

    private RemoteFile createMock(String name) {
        final RemoteFile rf = new RemoteFile();
        rf.setName(name);
        rf.setUri(URI.create(String.format("file:///home/directory/%s", name)));
        return rf;
    }
}
