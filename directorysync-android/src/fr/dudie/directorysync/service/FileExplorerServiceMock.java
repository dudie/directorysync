package fr.dudie.directorysync.service;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.androidannotations.annotations.EBean;

@EBean
public class FileExplorerServiceMock {

    public List<String> list() {
        final List<String> files = new ArrayList<String>();
        files.add("pacman");
        files.add("pacman");
        files.add("pear");
        files.add("perl5");
        files.add("pgadmin3");
        files.add("phonon");
        files.add("pixmaps");
        files.add("pkgconfig");
        files.add("polkit-1");
        files.add("poppler");
        files.add("postgresql");
        files.add("ppd");
        files.add("pygobject");
        files.add("pygtk");
        files.add("qalculate");
        files.add("qt");
        files.add("readline");
        files.add("redland");
        files.add("sane");
        files.add("sgml");
        files.add("shared-color-profiles");
        files.add("sip");
        files.add("smartmontools");
        files.add("smplayer");
        files.add("snmp");
        files.add("soprano");
        files.add("sounds");
        files.add("sqliteman");
        files.add("ss");
        files.add("strigi");
        files.add("subversion");
        files.add("svnqt");
        files.add("syslog-ng");
        files.add("system-config-printer");
        files.add("systemd");
        return files;
    }
}
