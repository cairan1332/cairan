package com.caiRanSystem.util.pullText;

import com.caiRanSystem.entity.book.RegexReplace;
import lombok.Data;

import java.util.List;

@Data
public class UrlText {
    private String beginStr;

    private String endStr;

    private String urlRegex;

    private String contentRegex;

    private List<RegexReplace> replaceList;

    private String ip;

    private String path;

    private String filePath;

    private String fileName;
}
