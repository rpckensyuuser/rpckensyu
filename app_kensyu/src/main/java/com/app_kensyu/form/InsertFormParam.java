package com.app_kensyu.form;

import java.util.List;

import javax.validation.Valid;

import lombok.Data;

/**
 * 不要なクラスです。
 * @author lovel
 *
 */

@Data
public class InsertFormParam {

    @Valid
    private List<InsertForm> formDataList;

}
