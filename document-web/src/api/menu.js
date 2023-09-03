import request from '@/utils/request'

// 获取所有菜单信息
export function getAllMenus() {
  return request({
    url: '/menu/all',
    method: 'get'
  })
}

// 查询菜单信息
export function getMenus() {
  return request({
    url: '/menu',
    method: 'get'
  })
}

// 查询菜单信息 - 带权限
export function getPermissionMenus(params) {
  return request({
    url: '/menu/permission',
    method: 'get',
    params: params
  })
}

// 编辑菜单
export function updateData(data) {
  return request({
    url: '/menu',
    method: 'put',
    data: data
  })
}
