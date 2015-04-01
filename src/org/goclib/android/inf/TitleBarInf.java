package org.goclib.android.inf;

import org.goclib.android.entity.GoclTitleBarButtonEntity;
import org.goclib.android.ui.GoclTitleBarButton;


public interface TitleBarInf {
	GoclTitleBarButton getLeftButton();

	GoclTitleBarButton getRightButton();

	GoclTitleBarButton getTitle();

	void setRightButton();

	void setRightButton(int resId);

	void setRightButton(String value);

	void setRightButton(GoclTitleBarButtonEntity entity);

	void setTitleButton();

	void setTitleButton(int resId);

	void setTitleButton(String value);

	void setTitleButton(GoclTitleBarButtonEntity entity);

	void setLeftButton();

	void setLeftButton(int resId);

	void setLeftButton(String value);

	void setLeftButton(GoclTitleBarButtonEntity entity);
}
