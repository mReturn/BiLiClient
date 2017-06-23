package com.mreturn.bilibili.widget.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mreturn.bilibili.R;
import com.mreturn.bilibili.utils.ThemeHelper;

/**
 * Created by mReturn
 * on 2017/6/21.
 * 主题选择对话框
 */

public class ThemePickDialog extends DialogFragment implements View.OnClickListener{

    ImageView[] mCards = new ImageView[8];

    Button btnConfirm ,btnCancle;

    private int mCurrentTheme;

    private onConfirmListener confirmListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.ThemeDialogStyle);
        mCurrentTheme = ThemeHelper.getTheme(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_theme_pick,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnConfirm = (Button) view.findViewById(R.id.btn_confirm);
        btnCancle = (Button) view.findViewById(R.id.btn_cancle);
        mCards[0] = (ImageView) view.findViewById(R.id.theme_pink);
        mCards[1] = (ImageView) view.findViewById(R.id.theme_purple);
        mCards[2] = (ImageView) view.findViewById(R.id.theme_blue);
        mCards[3] = (ImageView) view.findViewById(R.id.theme_green);
        mCards[4] = (ImageView) view.findViewById(R.id.theme_green_light);
        mCards[5] = (ImageView) view.findViewById(R.id.theme_yellow);
        mCards[6] = (ImageView) view.findViewById(R.id.theme_orange);
        mCards[7] = (ImageView) view.findViewById(R.id.theme_red);
        setImageButtons(mCurrentTheme);
        for (ImageView iv : mCards){
            iv.setOnClickListener(this);
        }
        btnConfirm.setOnClickListener(this);
        btnCancle.setOnClickListener(this);
    }

    private void setImageButtons(int currentTheme) {
        mCards[0].setSelected(currentTheme == ThemeHelper.CARD_PINK);
        mCards[1].setSelected(currentTheme == ThemeHelper.CARD_PURPLE);
        mCards[2].setSelected(currentTheme == ThemeHelper.CARD_BLUE);
        mCards[3].setSelected(currentTheme == ThemeHelper.CARD_GREEN);
        mCards[4].setSelected(currentTheme == ThemeHelper.CARD_GREEN_LIGHT);
        mCards[5].setSelected(currentTheme == ThemeHelper.CARD_YELLOW);
        mCards[6].setSelected(currentTheme == ThemeHelper.CARD_ORANGE);
        mCards[7].setSelected(currentTheme == ThemeHelper.CARD_RED);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirm:
                if(confirmListener != null)
                    confirmListener.onConfirm(mCurrentTheme);
                break;
            case R.id.btn_cancle:
                dismiss();
                break;
            case R.id.theme_pink:
                mCurrentTheme = ThemeHelper.CARD_PINK;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_purple:
                mCurrentTheme = ThemeHelper.CARD_PURPLE;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_blue:
                mCurrentTheme = ThemeHelper.CARD_BLUE;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_green:
                mCurrentTheme = ThemeHelper.CARD_GREEN;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_green_light:
                mCurrentTheme = ThemeHelper.CARD_GREEN_LIGHT;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_yellow:
                mCurrentTheme = ThemeHelper.CARD_YELLOW;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_orange:
                mCurrentTheme = ThemeHelper.CARD_ORANGE;
                setImageButtons(mCurrentTheme);
                break;
            case R.id.theme_red:
                mCurrentTheme = ThemeHelper.CARD_RED;
                setImageButtons(mCurrentTheme);
                break;
            default:
                break;
        }
    }


    public interface onConfirmListener {
        void onConfirm(int currentTheme);
    }
}
