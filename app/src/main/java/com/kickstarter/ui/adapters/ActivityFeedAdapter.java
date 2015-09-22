package com.kickstarter.ui.adapters;

import android.view.View;

import com.kickstarter.R;
import com.kickstarter.models.Activity;
import com.kickstarter.ui.viewholders.EmptyViewHolder;
import com.kickstarter.ui.viewholders.FriendBackingViewHolder;
import com.kickstarter.ui.viewholders.FriendFollowViewHolder;
import com.kickstarter.ui.viewholders.KsrViewHolder;
import com.kickstarter.ui.viewholders.ProjectStateChangedPositiveViewHolder;
import com.kickstarter.ui.viewholders.ProjectStateChangedViewHolder;
import com.kickstarter.ui.viewholders.ProjectUpdateViewHolder;

import java.util.List;

public class ActivityFeedAdapter extends KsrAdapter {

  public ActivityFeedAdapter(final List<Activity> activities) {
    data().add(activities);
  }

  @Override
  protected int layout(final SectionRow sectionRow) {
    final Activity activity = (Activity) objectFromSectionRow(sectionRow);

    switch (activity.category()) {
      case BACKING:
        return R.layout.activity_friend_backing_view;
      case FOLLOW:
        return R.layout.activity_friend_follow_view;
      case FAILURE:
      case CANCELLATION:
      case SUSPENSION:
      case RESUME:
        return R.layout.activity_project_state_changed_view;
      case LAUNCH:
      case SUCCESS:
        return R.layout.activity_project_state_changed_positive_view;
      case UPDATE:
        return R.layout.activity_project_update_view;
      default:
        return R.layout.empty_view;
    }
  }

  @Override
  protected KsrViewHolder viewHolder(final int layout, final View view) {
    switch (layout) {
      case R.layout.activity_friend_backing_view:
        return new FriendBackingViewHolder(view);
      case R.layout.activity_friend_follow_view:
        return new FriendFollowViewHolder(view);
      case R.layout.activity_project_state_changed_view:
        return new ProjectStateChangedViewHolder(view);
      case R.layout.activity_project_state_changed_positive_view:
        return new ProjectStateChangedPositiveViewHolder(view);
      case R.layout.activity_project_update_view:
        return new ProjectUpdateViewHolder(view);
      default:
        return new EmptyViewHolder(view);
    }
  }
}
