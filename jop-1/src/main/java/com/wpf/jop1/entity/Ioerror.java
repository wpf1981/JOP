package com.wpf.jop1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @outhor wpf
 * @date 2018/12/27 - 15:54
 */
@Entity
@Table(name = "WMS_IO_ERROR")
@Data
public class Ioerror {

    @Id
    private String bill_no;
    private String err_title;
    private String first_time;
    private String last_time;
    private String err_times;
    private String err_info;
    private String status;
    private String bill_type;

}
