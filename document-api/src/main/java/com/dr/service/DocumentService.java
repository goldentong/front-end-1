package com.dr.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dr.bean.Document;

/**
 * @description: 人员档案service
 * @author: whq
 * @date 2023-2-9 20:31:04
 */
public interface DocumentService extends IService<Document> {

    /**
     * @description: 分页查询人员档案
     * @param: page 分页数据
     * @param: keyWord 关键字
     */
    Page<Document> getPageList(Page page, String keyWord);

    /**
     * @description: 新增或编辑人员档案
     * @param: document 人员档案信息
     */
    void saveOrUpdateData(Document document);

    /**
     * @description: 删除人员档案
     * @param: id 人员档案id
     */
    void deleteData(Long id);
}
