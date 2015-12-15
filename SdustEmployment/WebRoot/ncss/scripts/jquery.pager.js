jQuery.pagefoot =
{
    //生成分页脚
    create: function(_this, s) {
        var pageCount = 0;
        pageCount = (s.count / s.pagesize <= 0) ? 1 : (parseInt(s.count / s.pagesize) + ((s.count % s.pagesize > 0) ? 1 : 0));
        s.current = (s.current > pageCount) ? pageCount : s.current
        var strPage = "<label>每页" + s.pagesize + "条/总" + s.count + "条</label>";
        if (s.current <= 1) {
            strPage += "<span class=\"disabled\">" + s.previous + "</span>";
        } else {
            strPage += "<a href=\"" + (s.current - 1) + "\">" + s.previous + "</a>";
        }
        var startP = 1;
        startP = 1
        var anyMore;
        anyMore = parseInt(s.displaynum / 2)
        var endP = (s.current + anyMore) > pageCount ? pageCount : s.current + anyMore;

        var pCount = s.pagesize - s.displaylastNum;
        if (s.current > s.displaynum) {
            startP = s.current - anyMore;
            for (i = 1; i <= s.displaylastNum; i++) {
                strPage += "<a href=\"" + i + "\">" + i + "</a>";
            }
            strPage += "...";
        }
        if (s.current + s.displaynum <= pageCount) {
            endP = s.current + anyMore;
        } else {
            endP = pageCount;
        }
        for (i = startP; i <= endP; i++) {
            if (s.current == i) {
                strPage += "<span class=\"current\">" + i + "</span>";
            } else {
                strPage += "<a href=\"./" + i + "\">" + i + "</a>";
            }
        }
        if (s.current + s.displaynum <= pageCount) {
            strPage += "...";
            for (i = pageCount - s.displaylastNum + 1; i <= pageCount; i++) {
                strPage += "<a href=\"" + i + "\">" + i + "</a>";
            }
        }
        if (s.current >= pageCount) {
            strPage += "<span class=\"disabled\">" + s.next + "</span>";
        } else {
            strPage += "<a href=\"" + (s.current + 1) + "\">" + s.next + "</a>";
        }
        $(_this).empty().append(strPage).find("a").click(function() {
            var ln = this.href.lastIndexOf("/");
            var href = this.href;
            var page = parseInt(href.substring(ln + 1, href.length));
            s.current = page;
            if (!$.pagefoot.paging(page, s.paging))
                return false;

            $.pagefoot.create(_this, s);
            return false;
        });
        return this;
    },
    paging: function(page, callback) {
        if (callback) {
            if (callback(page) == false)
                return false;
        }
        return true;
    }
}

jQuery.fn.pagefoot = function(opt) {
    var setting = { pagesize: 10  //每页显示的页码数
        , count: 0                //数据条数
        , css: "mj_pagefoot"      //分页脚css样式类
        , current: 1              //当前页码
		, displaynum: 5			//中间显示页码数
		, displaylastNum: 5		//最后显示的页码数
        , previous: "上一页"      //上一页显示样式
        , next: "下一页"          //下一页显示样式
        , paging: null            //分页事件触发时callback函数
    };
    opt = opt || {}
    $.extend(setting, opt);
    return this.each(function() {
        $(this).addClass(setting.css);
        $.pagefoot.create(this, setting);
    });
}