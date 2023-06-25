package com.xiong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiong.dao.TicketMapper;
import com.xiong.pojo.Ticket;
import com.xiong.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket> implements TicketService {
    @Autowired
    private TicketMapper ticketMapper;

    //查询所有，连表
    @Override
    public List<Ticket> getAll(Integer currentPage, Integer pageSize) {
        return ticketMapper.getAll((currentPage - 1) * pageSize, pageSize);
    }

    //查询记录数
    @Override
    public long getCount() {
        return ticketMapper.selectCount(null);
    }

    //查询所有，连表，没有分页
    @Override
    public List<Ticket> getAll1() {
        return ticketMapper.getAll1();
    }

    //根据ID查询，连表
    @Override
    public Ticket getTicketById(Integer id) {
        return ticketMapper.getTicketById(id);
    }

    //根据用户ID查询
    @Override
    public List<Ticket> getTicketByUser(Integer id) {
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t_user", id);
        return ticketMapper.selectList(queryWrapper);
    }

    //根据用户ID删除
    @Override
    public int deleteTicketByUser(Integer id) {
        QueryWrapper<Ticket> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t_user", id);
        return ticketMapper.delete(queryWrapper);
    }
}
