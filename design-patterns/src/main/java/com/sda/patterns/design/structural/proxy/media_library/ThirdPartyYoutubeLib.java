package com.sda.patterns.design.structural.proxy.media_library;

import java.util.Map;

public interface ThirdPartyYoutubeLib {

    Map<String, Video> popularVideos();

    Video getVideo(String videoId);
}
