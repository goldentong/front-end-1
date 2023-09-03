import request from '@/utils/request'

// 获取所有角色信息
export function getAllRoles() {
  return request({
    url: '/role/all',
    method: 'get'
  })
}

// 分页查询角色信息
export function getPageList(params) {
  return request({
    url: '/role',
    method: 'get',
    params: params
  })
}

// 新增或编辑角色
export function saveOrUpdateData(data) {
  return request({
    url: '/role',
    method: 'post',
    data: data
  })
}

// 删除角色
export function deleteData(id) {
  return request({
    url: '/role/' + id,
    method: 'delete'
  })
}
