webpackJsonp([0], {
    ZYmg: function (e, t, n) {
        "use strict";
        var o = n("p+dL"), d = {
            GET_LIST: "/blog",
            GET_DETAIL: "/blog/:blogId",
            CREATE: "/blog",
            UPDATE: "/blog/:blogId",
            DELETE: "/blog/:blogId"
        };
        t.a = {
            getBlogs: function () {
                var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {page: 1}, t = e.page,
                    n = void 0 === t ? 1 : t, g = e.userId, a = e.atIndex;
                return Object(o.a)(d.GET_LIST, "GET", {page: n, userId: g, atIndex: a})
            }, getIndexBlogs: function () {
                var e = (arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {page: 1}).page,
                    t = void 0 === e ? 1 : e;
                return this.getBlogs({page: t, atIndex: !0})
            }, getBlogsByUserId: function (e) {
                var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {page: 1}, n = t.page,
                    o = void 0 === n ? 1 : n, d = t.atIndex;
                return this.getBlogs({userId: e, page: o, atIndex: d})
            }, getDetail: function (e) {
                var t = e.blogId;
                return Object(o.a)(d.GET_DETAIL.replace(":blogId", t))
            }, updateBlog: function (e, t) {
                var n = e.blogId, g = t.title, a = t.content, i = t.description, l = t.atIndex;
                return Object(o.a)(d.UPDATE.replace(":blogId", n), "PATCH", {
                    title: g,
                    content: a,
                    description: i,
                    atIndex: l
                })
            }, deleteBlog: function (e) {
                var t = e.blogId;
                return Object(o.a)(d.DELETE.replace(":blogId", t), "DELETE")
            }, createBlog: function () {
                var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {
                        title: "",
                        content: "",
                        description: "",
                        atIndex: !1
                    }, t = e.title, n = void 0 === t ? "" : t, g = e.content, a = void 0 === g ? "" : g, i = e.description,
                    l = void 0 === i ? "" : i, r = e.atIndex, c = void 0 !== r && r;
                return Object(o.a)(d.CREATE, "POST", {title: n, content: a, description: l, atIndex: c})
            }
        }
    }
});
//# sourceMappingURL=0.be8904e1f6d035384bb5.js.map