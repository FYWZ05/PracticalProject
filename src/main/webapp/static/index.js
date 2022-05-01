let app = new Vue({
    el: "#app",
    data: function () {
        return {
            products: {},
            reqPuPuUrl: {
                url: ""
            },
            selectParams: {
                menu: "",
                pn: 1,
                size: 10,
            },
            reqPanel: {
                isShow: false,
                isSave: false
            },
            menuItem: {},
            isMenu: false,
            disMenu: false,
            showTips: true,
            tips: {
                title: "信息",
                body: ""
            }
        }
    },
    computed: {},
    methods: {

        deleteProduct(id, index) {
            if (id !== "") {
                if (window.confirm("确定删除？")) {
                    $.ajax({
                        url: "/delete",
                        data: {
                            id: id
                        },
                        complete: function () {
                            $("#tips").toast('show');
                        },
                        dataType: "json",
                        method: "GET",
                        success: function (data) {
                            console.log(data);
                            if (data.code !== "1") {
                                app.$data.tips.body = data.error;
                            } else {
                                app.$data.tips.body = "删除了" + data.count + "条记录";
                                // 页面删除
                                app.$delete(app.$data.products, index)
                            }
                        }
                    })
                }
            } else {
                app.$data.tips.body = "id不能为空";
                app.$data.tips.show();
            }
        },
        reqPuPu() {
            if (app.$data.reqPuPuUrl.url !== "") {
                $.ajax({
                    url: "/custom",
                    data: {
                        url: app.$data.reqPuPuUrl.url
                    },
                    dataType: "json",
                    method: "POST",
                    success: function (data) {
                        if (data.code !== "1") {
                            console.log(data)
                            app.$data.tips.body = data.error;
                            $("#tips").toast('show');
                        } else {
                            app.$data.tips.title = "查询到" + data.products.length + "条记录";
                            app.$data.products = data.products;
                        }
                    }
                })
            } else {
                app.$data.tips.body = "地址不能为空";
                $("#tips").toast('show');
            }
        },
        selectProducts() {
            if ($("#fromDb").is(":checked")) {
                $.ajax({
                    url: "/products",
                    method: "GET",
                    dataType: "json",
                    data: {
                        pn: app.$data.selectParams.pn,
                        size: app.$data.selectParams.size,
                    },
                    complete: function () {
                        $("#tips").toast('show');
                    },
                    success: function (data) {
                        if (data.code !== "1") {
                            app.$data.tips = data.err
                        } else {
                            app.$data.products = data.products;
                            const len = app.$data.products === undefined ? 0 : app.$data.products.length;
                            app.$data.tips.body = "查询到" + len + "条记录";
                        }
                    }
                })
                return;
            }
            if ($("#pushData").is(":checked")) {
                if (app.$data.selectParams.menu === "") {
                    app.$data.tips.body = "选择分类";
                    $("#tips").toast('show');
                } else {
                    $.ajax({
                        url: "/pupu",
                        method: "GET",
                        dataType: "json",
                        data: {
                            page: app.$data.selectParams.pn,
                            size: app.$data.selectParams.size,
                            menu: app.$data.selectParams.menu
                        },
                        complete: function () {
                            $("#tips").toast('show');
                        },
                        success: function (data) {
                            if (data.code !== "1") {
                                app.$data.tips.body = data.err;
                            } else {
                                app.$data.products = data.products;
                                app.$data.tips.body = "查询到" + data.products.length + "条记录";
                            }
                        }
                    })
                }
                return;
            }
            app.$data.tips.body = "请选择数据源";
            $("#tips").toast('show');
        },
        showPanel() {
            app.$data.reqPanel.isShow = !app.$data.reqPanel.isShow;
        },
        getMenu() {
            if (!app.$data.isMenu) {
                $.ajax({
                    url: "/menu",
                    method: "GET",
                    dataType: "json",
                    success: function (data) {
                        if (data.length < 1) {
                            app.$data.tips.body = "请求菜单列表异常";
                            $("#tips").toast('show');
                        } else {
                            app.$data.menuItem = data;
                        }
                    },
                });
            }
        },
        disableMenu: function (e) {
            app.$data.disMenu = e.target.id === "fromDb";
        },
    }
});