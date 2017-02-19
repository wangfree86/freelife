package w.com.wk.freelife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MViewOne extends View {
    private Paint mArcPaint, mCirclePaint, mTextPaint, mPaint;

    private float length;

    private float mRadius;

    private float mCircleXY;

    private float mSweepValue = 0;

    private String mShowText = "0";

    private RectF mRectF,mRectF1;

    public MViewOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public MViewOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MViewOne(Context context) {
        super(context);
        initView();
    }

    private void initView() {

        //圆形颜色
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.parseColor("#E2E2E2"));
        mCirclePaint.setAntiAlias(true);

        //字体颜色
        mTextPaint = new Paint();
        mTextPaint.setTextSize(40);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.parseColor("#2F2F2F"));
        mTextPaint.setStrokeWidth(0);


        //画弧线1FCFCFC
        mPaint = new Paint();
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#ffffff"));
        mPaint.setStyle(Paint.Style.STROKE);
//画弧线2
        mArcPaint = new Paint();
        mArcPaint.setStrokeWidth(20);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(Color.parseColor("#00AAFE"));
        mArcPaint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        length = w;
        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画圆
        mRectF = new RectF((float) (length * 0.2), (float) (length * 0.2),
                (float) (length * 0.8), (float) (length * 0.8));

        //x,y位置,mRadius半径
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
//		// 画弧线oval :指定圆弧的外轮廓矩形区域。
//		startAngle: 圆弧起始角度，单位为度。
//		sweepAngle: 圆弧扫过的角度，顺时针方向，单位为度。
//		useCenter: 如果为True时，在绘制圆弧时将圆心包括在内，通常用来绘制扇形。
//		paint: 绘制圆弧的画板属性，如颜色，是否填充等。
        canvas.drawArc(mRectF, 0, 360, false, mPaint);

//
        canvas.drawArc(mRectF, 270, mSweepValue, false, mArcPaint);
//
//		// 绘制文字
        float textWidth = mTextPaint.measureText(mShowText);   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间

        canvas.drawText(mShowText, (int) (length / 2 - textWidth / 2), (int) (length / 2 + textWidth / 2), mTextPaint);

    }

    public void setProgress(float mSweepValue,int n) {
        float a = (float) mSweepValue;
        if (a != 0) {
            this.mSweepValue = (float) (360.0 * a);
            mShowText=getTime(n);
//            mShowText = String.valueOf((int) (mSweepValue * 100)) + "%"+getTime(n);
//            Log.e("this.mSweepValue:", this.mSweepValue + "");
        } else {
            this.mSweepValue = 0;
            mShowText = 0 +"";
        }

        invalidate();
    }
        public String getTime(int time) {
        if (time <= 0) {
            return "0:00";
        }

        int minute = time / 60 % 60;
        int second = time % 60;

        return minute + ":" + second;

    }

}