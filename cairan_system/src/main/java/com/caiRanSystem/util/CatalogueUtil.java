package com.caiRanSystem.util;

import com.caiRanSystem.entity.sys.Catalogue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogueUtil {


    public static String createCatalogue(List<Catalogue> catalogueList) {
        if (catalogueList == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer("<ul class=\"nav\">");
        for (Catalogue catalogue : catalogueList) {
            buffer.append("<li>");
            if (catalogue.isPage()) {
                buffer.append("<a href=\"")
                        .append(catalogue.getPath())
                        .append("\" target=\"")
                        .append(catalogue.getTarget())
                        .append("\" class=\" \">")
                        .append(catalogue.getCatalogueName())
                        .append("</a>");
            } else {
                buffer.append("<div class=\"nav-header\"><a href=\"")
                        .append(catalogue.getPath())
                        .append("\" class=\"ue-clear\"><i class=\"")
                        .append(catalogue.getIcon())
                        .append("\"></i><span>")
                        .append(catalogue.getCatalogueName())
                        .append("</span></a></div>");
                if (catalogue.getChildrenCatalogueList() != null) {
                    String str = createCatalogue(catalogue.getChildrenCatalogueList());
                    buffer.append(str == null ? "" : str);
                }
            }
            buffer.append("</li>");
        }
        buffer.append("</ul>");
        return buffer.toString();
    }

    public static List<Catalogue> getTree(List<Catalogue> catalogueList) {

        Map<Integer, List<Catalogue>> map = new HashMap<>();
        catalogueList.forEach(catalogue -> {
            Integer num = catalogue.getRuleCode().length() / 2;
            map.computeIfAbsent(num, k -> new ArrayList<>());
            map.get(num).add(catalogue);
        });
        System.out.println(map);
        for (int i = map.size(); i > 1; i--) {
            final Integer num = i;
            map.get(num - 1).forEach(superCatalogue -> {
                String ruleCode = superCatalogue.getRuleCode();
                map.get(num).forEach(childrenCatalogue -> {
                    if (ruleCode.equals(childrenCatalogue.getRuleCode().substring(0, (num - 1) * 2))) {
                        if (superCatalogue.getChildrenCatalogueList() == null) {
                            superCatalogue.setChildrenCatalogueList(new ArrayList<>());
                        }
                        superCatalogue.getChildrenCatalogueList().add(childrenCatalogue);
                    }
                });
            });
        }

        return map.get(1);
    }
}
