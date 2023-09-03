package com.dr.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dr.bean.Document;
import com.dr.bean.PageResponse;
import com.dr.bean.Response;
import com.dr.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 人员档案controller
 * @author: whq
 * @date 2023-2-9 20:30:46
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * @description: 分页查询人员档案信息
     * @param: page 页码
     * @param: limit 页大小
     * @param: keyWord 关键字
     */
    @GetMapping
    public PageResponse getPageList(@RequestParam(required = false, defaultValue = "1") long page,
                                @RequestParam(required = false, defaultValue = "10") long size,
                                String keyWord) {
        // 分页查询
        Page<Document> pageList = documentService.getPageList(new Page<>(page, size), keyWord);
        return PageResponse.ok(pageList.getRecords(), pageList.getTotal());
    }

    /**
     * @description: 新增或编辑人员档案
     * @param: document 人员档案信息
     */
    @PostMapping
    public Response saveOrUpdateData(@RequestBody Document document) {
        // 参数校验
        if (BeanUtil.isEmpty(document)) {
            return Response.error("参数丢失");
        }
        documentService.saveOrUpdateData(document);
        return Response.ok();
    }

    /**
     * @description: 删除人员档案
     * @param: id 人员档案
     */
    @DeleteMapping("/{id}")
    public Response deleteData(@PathVariable Long id) {
        // 参数校验
        if (id == null) {
            return Response.error("参数丢失");
        }
        // 执行删除
        documentService.deleteData(id);
        return Response.ok();
    }
}
