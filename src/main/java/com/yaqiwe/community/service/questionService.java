package com.yaqiwe.community.service;

import com.yaqiwe.community.dto.QuestionDto;
import com.yaqiwe.community.entity.question;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/17 10:09
 * @description：问题相关操作
 */
@Validated
public interface questionService {

    /**
     * 发布问题
     * @param title 问题标题
     * @param problemDescribe   问题描述
     * @param Tag 问题标签
     * @param creator 发起问题人的ID
     * @return
     */
    question createQuestion(@NotEmpty(message = "标题不能为空") String title,
                            @NotEmpty(message = "问题描述不能为空") String problemDescribe,
                            @NotEmpty(message = "标签不能为空") String Tag,
                            @NotNull(message = "发起人ID不能为空") Integer creator);

    /**
     * 查询所有的
     * @param page 查询第几页
     * @param limit 每一页的记录数目
     * @return
     */
    List<QuestionDto> questionList(@NotNull(message = "页数不能为空") Integer page,
                                   @NotNull(message = "每页条数不能为空") Integer limit);
}
