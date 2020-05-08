package com.sky.file.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.common.entity.BaseEntity;

@TableName(value = "t_file")
public class FileEntity extends BaseEntity {
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件前缀
     */
    private String pathHead;
    /**
     * 文件路径
     * 值示例：house/2018/123abc.jpg
     * 所以，要去文件的后缀可以从filePath取
     */
    private String filePath;
    /**
     * 所属文件夹编码
     * 默认顶层文件夹不设置为0
     */
    private Long parentId = 0L;
    /**
     * 此文件是否是共享的
     */
    private Boolean isShare;


}
