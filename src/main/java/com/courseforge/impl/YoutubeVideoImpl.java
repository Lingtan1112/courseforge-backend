package com.courseforge.impl;

import java.util.List;

import com.courseforge.interfaces.YoutubeVideoInterface;
import com.courseforge.model.YoutubeVideo;

public class YoutubeVideoImpl implements YoutubeVideoInterface{

    @Override
    public List<YoutubeVideo> save(YoutubeVideo youtubeVideo) {
        // TODO Auto-generated method stub
//         Component CommunityInstaller.EnableFeaturesAction failed: Not found 
//    at CommunityInstaller.InstallWorkflow.<DoHandleD4WPackageAsync>d__30.MoveNext()
// --- End of stack trace from previous location where exception was thrown ---
//    at System.Runtime.ExceptionServices.ExceptionDispatchInfo.Throw()
//    at System.Runtime.CompilerServices.TaskAwaiter.HandleNonSuccessAndDebuggerNotification(Task task)
//    at CommunityInstaller.InstallWorkflow.<DoProcessAsync>d__23.MoveNext()
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<YoutubeVideo> fetchVideosByCourseId(String courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchVideosByCourseId'");
    }

    @Override
    public List<YoutubeVideo> deleteVideo(Long videoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVideo'");
    }
    
}
