package com.deer.wms.workflow.flowable.image;

import com.deer.wms.workflow.flowable.CustomFlowableProperties;
import com.deer.wms.workflow.flowable.FlowableUtil;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.AssociationDirection;
import org.flowable.image.exception.FlowableImageException;
import org.flowable.image.impl.DefaultProcessDiagramCanvas;
import org.flowable.image.util.ReflectUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * MYProcessDiagramCanvas
 * 可以修改图片信息
 *
 * @author luxin.yan
 * @date 2019/1/17
 **/
public class MyProcessDiagramCanvas extends DefaultProcessDiagramCanvas {
    protected String activityFontName = "宋体";
    protected String labelFontName = "宋体";
    protected String annotationFontName = "宋体";
    /**
     * 活动节点高亮颜色
     **/
    protected static Color HIGHLIGHT_COLOR = new Color(67, 255, 252);
    /**
     * 连接线高亮
     **/
    protected static Color HIGHLIGHT_CONNECTION_COLOR = Color.black;

    public MyProcessDiagramCanvas(int width, int height, int minX, int minY, String imageType, String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader) {
        super(width, height, minX, minY, imageType, activityFontName, labelFontName, annotationFontName, customClassLoader);
    }

    private void init() {
        CustomFlowableProperties customFlowableProperties = FlowableUtil.getCustomFlowableProperties();
        if (StringUtils.isNotEmpty(customFlowableProperties.getActivityFontName())) {
            activityFontName = customFlowableProperties.getActivityFontName();
        }
        if (StringUtils.isNotEmpty(customFlowableProperties.getLabelFontName())) {
            labelFontName = customFlowableProperties.getLabelFontName();
        }
        if (StringUtils.isNotEmpty(customFlowableProperties.getAnnotationFontName())) {
            annotationFontName = customFlowableProperties.getAnnotationFontName();
        }
        if (StringUtils.isNotEmpty(customFlowableProperties.getHighlightColor())) {
            String[] rgb = customFlowableProperties.getHighlightColor().split(",");
            try {
                HIGHLIGHT_COLOR = new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                LOGGER.warn("颜色配置非规范RGB格式");
            }
        }
        if (StringUtils.isNotEmpty(customFlowableProperties.getHighlightConnectionColor())) {
            String[] rgb = customFlowableProperties.getHighlightConnectionColor().split(",");
            try {
                HIGHLIGHT_CONNECTION_COLOR = new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
                LOGGER.warn("颜色配置非规范RGB格式");
            }
        }
    }

    @Override
    public void initialize(String imageType) {
        //初始化配置参数
        init();
        if ("png".equalsIgnoreCase(imageType)) {
            this.processDiagram = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        }
        else {
            this.processDiagram = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_RGB);
        }

        this.g = processDiagram.createGraphics();
        if (!"png".equalsIgnoreCase(imageType)) {
            this.g.setBackground(new Color(255, 255, 255, 0));
            this.g.clearRect(0, 0, canvasWidth, canvasHeight);
        }

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(Color.black);

        Font font = new Font(activityFontName, Font.BOLD, FONT_SIZE);
        g.setFont(font);
        this.fontMetrics = g.getFontMetrics();

        LABEL_FONT = new Font(labelFontName, Font.ITALIC, 10);
        ANNOTATION_FONT = new Font(annotationFontName, Font.PLAIN, FONT_SIZE);

        try {
            USERTASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/userTask.png", customClassLoader));
            SCRIPTTASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/scriptTask.png", customClassLoader));
            SERVICETASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/serviceTask.png", customClassLoader));
            RECEIVETASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/receiveTask.png", customClassLoader));
            SENDTASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/sendTask.png", customClassLoader));
            MANUALTASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/manualTask.png", customClassLoader));
            BUSINESS_RULE_TASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/businessRuleTask.png", customClassLoader));
            SHELL_TASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/shellTask.png", customClassLoader));
            DMN_TASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/dmnTask.png", customClassLoader));
            CAMEL_TASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/camelTask.png", customClassLoader));
            MULE_TASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/muleTask.png", customClassLoader));
            HTTP_TASK_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/httpTask.png", customClassLoader));

            TIMER_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/timer.png", customClassLoader));
            COMPENSATE_THROW_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/compensate-throw.png", customClassLoader));
            COMPENSATE_CATCH_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/compensate.png", customClassLoader));
            ERROR_THROW_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/error-throw.png", customClassLoader));
            ERROR_CATCH_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/error.png", customClassLoader));
            MESSAGE_THROW_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/message-throw.png", customClassLoader));
            MESSAGE_CATCH_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/message.png", customClassLoader));
            SIGNAL_THROW_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/signal-throw.png", customClassLoader));
            SIGNAL_CATCH_IMAGE = ImageIO.read(ReflectUtil.getResource("org/flowable/icons/signal.png", customClassLoader));
        } catch (IOException e) {
            LOGGER.warn("Could not load image for process diagram creation: {}", e.getMessage());
        }
    }

    @Override
    public void drawHighLight(int x, int y, int width, int height) {
        Paint originalPaint = g.getPaint();
        Stroke originalStroke = g.getStroke();

        g.setPaint(HIGHLIGHT_COLOR);
        g.setStroke(THICK_TASK_BORDER_STROKE);

        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, width, height, 20, 20);
        g.draw(rect);

        g.setPaint(originalPaint);
        g.setStroke(originalStroke);
    }

    /**
     * 修改连线图形
     */
    @Override
    public void drawConnection(int[] xPoints, int[] yPoints, boolean conditional, boolean isDefault, String connectionType,
                               AssociationDirection associationDirection, boolean highLighted, double scaleFactor) {

        Paint originalPaint = g.getPaint();
        Stroke originalStroke = g.getStroke();

        g.setPaint(CONNECTION_COLOR);
        if (connectionType.equals("association")) {
            g.setStroke(ASSOCIATION_STROKE);
        }
        else if (highLighted) {
            //连线高亮颜色
            g.setPaint(HIGHLIGHT_CONNECTION_COLOR);
            g.setStroke(HIGHLIGHT_FLOW_STROKE);
        }

        for (int i = 1; i < xPoints.length; i++) {
            Integer sourceX = xPoints[i - 1];
            Integer sourceY = yPoints[i - 1];
            Integer targetX = xPoints[i];
            Integer targetY = yPoints[i];
            Line2D.Double line = new Line2D.Double(sourceX, sourceY, targetX, targetY);
            g.draw(line);
        }

        if (isDefault) {
            Line2D.Double line = new Line2D.Double(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
            drawDefaultSequenceFlowIndicator(line, scaleFactor);
        }

        if (conditional) {
            Line2D.Double line = new Line2D.Double(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
            drawConditionalSequenceFlowIndicator(line, scaleFactor);
        }

        if (associationDirection == AssociationDirection.ONE || associationDirection == AssociationDirection.BOTH) {
            Line2D.Double line = new Line2D.Double(xPoints[xPoints.length - 2], yPoints[xPoints.length - 2], xPoints[xPoints.length - 1], yPoints[xPoints.length - 1]);
            drawArrowHead(line, scaleFactor);
        }
        if (associationDirection == AssociationDirection.BOTH) {
            Line2D.Double line = new Line2D.Double(xPoints[1], yPoints[1], xPoints[0], yPoints[0]);
            drawArrowHead(line, scaleFactor);
        }
        g.setPaint(originalPaint);
        g.setStroke(originalStroke);
    }

    @Override
    public InputStream generateImage(String imageType) {
        if (closed) {
            throw new FlowableImageException("ProcessDiagramGenerator already closed");
        }
        minX = (minX <= 5) ? 5 : minX;
        minY = (minY <= 5) ? 5 : minY;
        BufferedImage imageToSerialize = processDiagram;
        if (minX >= 0 && minY >= 0) {
            imageToSerialize = processDiagram.getSubimage(minX - 5, minY - 5, canvasWidth - minX + 5, canvasHeight - minY + 5);
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(imageToSerialize, imageType, out);

        } catch (IOException e) {
            throw new FlowableImageException("Error while generating process image", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ignore) {
                // Exception is silently ignored
            }
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
