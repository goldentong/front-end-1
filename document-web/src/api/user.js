import request from '@/utils/request'

// 登录
export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data: data
  })
}

// 分页查询用户信息
export function getPageList(params) {
  return request({
    url: '/user',
    method: 'get',
    params: params
  })
}

// 新增或编辑用户
export function saveOrUpdateData(data) {
  return request({
    url: '/user',
    method: 'post',
    data: data
  })
}

// 删除用户
export function deleteData(id) {
  return request({
    url: '/user/' + id,
    method: 'delete'
  })
}
