/*! jQuery UI - v1.10.3 - 2013-09-17
 * http://jqueryui.com
 * Includes: jquery.ui.core.js, jquery.ui.widget.js
 * Copyright 2013 jQuery Foundation and other contributors; Licensed MIT */
(function (e, t) {
    function i(t, n) {
        var r, i, o, u = t.nodeName.toLowerCase();
        return "area" === u ? (r = t.parentNode, i = r.name, !t.href || !i || r.nodeName.toLowerCase() !== "map" ? !1 : (o = e("img[usemap=#" + i + "]")[0], !!o && s(o))) : (/input|select|textarea|button|object/.test(u) ? !t.disabled : "a" === u ? t.href || n : n) && s(t)
    }

    function s(t) {
        return e.expr.filters.visible(t) && !e(t).parents().addBack().filter(function () {
                return e.css(this, "visibility") === "hidden"
            }).length
    }

    var n = 0, r = /^ui-id-\d+$/;
    e.ui = e.ui || {}, e.extend(e.ui, {
        version: "1.10.3",
        keyCode: {
            BACKSPACE: 8,
            COMMA: 188,
            DELETE: 46,
            DOWN: 40,
            END: 35,
            ENTER: 13,
            ESCAPE: 27,
            HOME: 36,
            LEFT: 37,
            NUMPAD_ADD: 107,
            NUMPAD_DECIMAL: 110,
            NUMPAD_DIVIDE: 111,
            NUMPAD_ENTER: 108,
            NUMPAD_MULTIPLY: 106,
            NUMPAD_SUBTRACT: 109,
            PAGE_DOWN: 34,
            PAGE_UP: 33,
            PERIOD: 190,
            RIGHT: 39,
            SPACE: 32,
            TAB: 9,
            UP: 38
        }
    }), e.fn.extend({
        focus: function (t) {
            return function (n, r) {
                return typeof n == "number" ? this.each(function () {
                    var t = this;
                    setTimeout(function () {
                        e(t).focus(), r && r.call(t)
                    }, n)
                }) : t.apply(this, arguments)
            }
        }(e.fn.focus), scrollParent: function () {
            var t;
            return e.ui.ie && /(static|relative)/.test(this.css("position")) || /absolute/.test(this.css("position")) ? t = this.parents().filter(function () {
                return /(relative|absolute|fixed)/.test(e.css(this, "position")) && /(auto|scroll)/.test(e.css(this, "overflow") + e.css(this, "overflow-y") + e.css(this, "overflow-x"))
            }).eq(0) : t = this.parents().filter(function () {
                return /(auto|scroll)/.test(e.css(this, "overflow") + e.css(this, "overflow-y") + e.css(this, "overflow-x"))
            }).eq(0), /fixed/.test(this.css("position")) || !t.length ? e(document) : t
        }, zIndex: function (n) {
            if (n !== t)return this.css("zIndex", n);
            if (this.length) {
                var r = e(this[0]), i, s;
                while (r.length && r[0] !== document) {
                    i = r.css("position");
                    if (i === "absolute" || i === "relative" || i === "fixed") {
                        s = parseInt(r.css("zIndex"), 10);
                        if (!isNaN(s) && s !== 0)return s
                    }
                    r = r.parent()
                }
            }
            return 0
        }, uniqueId: function () {
            return this.each(function () {
                this.id || (this.id = "ui-id-" + ++n)
            })
        }, removeUniqueId: function () {
            return this.each(function () {
                r.test(this.id) && e(this).removeAttr("id")
            })
        }
    }), e.extend(e.expr[":"], {
        data: e.expr.createPseudo ? e.expr.createPseudo(function (t) {
            return function (n) {
                return !!e.data(n, t)
            }
        }) : function (t, n, r) {
            return !!e.data(t, r[3])
        }, focusable: function (t) {
            return i(t, !isNaN(e.attr(t, "tabindex")))
        }, tabbable: function (t) {
            var n = e.attr(t, "tabindex"), r = isNaN(n);
            return (r || n >= 0) && i(t, !r)
        }
    }), e("<a>").outerWidth(1).jquery || e.each(["Width", "Height"], function (n, r) {
        function u(t, n, r, s) {
            return e.each(i, function () {
                n -= parseFloat(e.css(t, "padding" + this)) || 0, r && (n -= parseFloat(e.css(t, "border" + this + "Width")) || 0), s && (n -= parseFloat(e.css(t, "margin" + this)) || 0)
            }), n
        }

        var i = r === "Width" ? ["Left", "Right"] : ["Top", "Bottom"], s = r.toLowerCase(), o = {
            innerWidth: e.fn.innerWidth,
            innerHeight: e.fn.innerHeight,
            outerWidth: e.fn.outerWidth,
            outerHeight: e.fn.outerHeight
        };
        e.fn["inner" + r] = function (n) {
            return n === t ? o["inner" + r].call(this) : this.each(function () {
                e(this).css(s, u(this, n) + "px")
            })
        }, e.fn["outer" + r] = function (t, n) {
            return typeof t != "number" ? o["outer" + r].call(this, t) : this.each(function () {
                e(this).css(s, u(this, t, !0, n) + "px")
            })
        }
    }), e.fn.addBack || (e.fn.addBack = function (e) {
        return this.add(e == null ? this.prevObject : this.prevObject.filter(e))
    }), e("<a>").data("a-b", "a").removeData("a-b").data("a-b") && (e.fn.removeData = function (t) {
        return function (n) {
            return arguments.length ? t.call(this, e.camelCase(n)) : t.call(this)
        }
    }(e.fn.removeData)), e.ui.ie = !!/msie [\w.]+/.exec(navigator.userAgent.toLowerCase()), e.support.selectstart = "onselectstart" in document.createElement("div"), e.fn.extend({
        disableSelection: function () {
            return this.bind((e.support.selectstart ? "selectstart" : "mousedown") + ".ui-disableSelection", function (e) {
                e.preventDefault()
            })
        }, enableSelection: function () {
            return this.unbind(".ui-disableSelection")
        }
    }), e.extend(e.ui, {
        plugin: {
            add: function (t, n, r) {
                var i, s = e.ui[t].prototype;
                for (i in r)s.plugins[i] = s.plugins[i] || [], s.plugins[i].push([n, r[i]])
            }, call: function (e, t, n) {
                var r, i = e.plugins[t];
                if (!i || !e.element[0].parentNode || e.element[0].parentNode.nodeType === 11)return;
                for (r = 0; r < i.length; r++)e.options[i[r][0]] && i[r][1].apply(e.element, n)
            }
        }, hasScroll: function (t, n) {
            if (e(t).css("overflow") === "hidden")return !1;
            var r = n && n === "left" ? "scrollLeft" : "scrollTop", i = !1;
            return t[r] > 0 ? !0 : (t[r] = 1, i = t[r] > 0, t[r] = 0, i)
        }
    })
})(jQuery), function (e, t) {
    var n = 0, r = Array.prototype.slice, i = e.cleanData;
    e.cleanData = function (t) {
        for (var n = 0, r; (r = t[n]) != null; n++)try {
            e(r).triggerHandler("remove")
        } catch (s) {
        }
        i(t)
    }, e.widget = function (t, n, r) {
        var i, s, o, u, a = {}, f = t.split(".")[0];
        t = t.split(".")[1], i = f + "-" + t, r || (r = n, n = e.Widget), e.expr[":"][i.toLowerCase()] = function (t) {
            return !!e.data(t, i)
        }, e[f] = e[f] || {}, s = e[f][t], o = e[f][t] = function (e, t) {
            if (!this._createWidget)return new o(e, t);
            arguments.length && this._createWidget(e, t)
        }, e.extend(o, s, {
            version: r.version,
            _proto: e.extend({}, r),
            _childConstructors: []
        }), u = new n, u.options = e.widget.extend({}, u.options), e.each(r, function (t, r) {
            if (!e.isFunction(r)) {
                a[t] = r;
                return
            }
            a[t] = function () {
                var e = function () {
                    return n.prototype[t].apply(this, arguments)
                }, i = function (e) {
                    return n.prototype[t].apply(this, e)
                };
                return function () {
                    var t = this._super, n = this._superApply, s;
                    return this._super = e, this._superApply = i, s = r.apply(this, arguments), this._super = t, this._superApply = n, s
                }
            }()
        }), o.prototype = e.widget.extend(u, {widgetEventPrefix: s ? u.widgetEventPrefix : t}, a, {
            constructor: o,
            namespace: f,
            widgetName: t,
            widgetFullName: i
        }), s ? (e.each(s._childConstructors, function (t, n) {
            var r = n.prototype;
            e.widget(r.namespace + "." + r.widgetName, o, n._proto)
        }), delete s._childConstructors) : n._childConstructors.push(o), e.widget.bridge(t, o)
    }, e.widget.extend = function (n) {
        var i = r.call(arguments, 1), s = 0, o = i.length, u, a;
        for (; s < o; s++)for (u in i[s])a = i[s][u], i[s].hasOwnProperty(u) && a !== t && (e.isPlainObject(a) ? n[u] = e.isPlainObject(n[u]) ? e.widget.extend({}, n[u], a) : e.widget.extend({}, a) : n[u] = a);
        return n
    }, e.widget.bridge = function (n, i) {
        var s = i.prototype.widgetFullName || n;
        e.fn[n] = function (o) {
            var u = typeof o == "string", a = r.call(arguments, 1), f = this;
            return o = !u && a.length ? e.widget.extend.apply(null, [o].concat(a)) : o, u ? this.each(function () {
                var r, i = e.data(this, s);
                if (!i)return e.error("cannot call methods on " + n + " prior to initialization; " + "attempted to call method '" + o + "'");
                if (!e.isFunction(i[o]) || o.charAt(0) === "_")return e.error("no such method '" + o + "' for " + n + " widget instance");
                r = i[o].apply(i, a);
                if (r !== i && r !== t)return f = r && r.jquery ? f.pushStack(r.get()) : r, !1
            }) : this.each(function () {
                var t = e.data(this, s);
                t ? t.option(o || {})._init() : e.data(this, s, new i(o, this))
            }), f
        }
    }, e.Widget = function () {
    }, e.Widget._childConstructors = [], e.Widget.prototype = {
        widgetName: "widget",
        widgetEventPrefix: "",
        defaultElement: "<div>",
        options: {disabled: !1, create: null},
        _createWidget: function (t, r) {
            r = e(r || this.defaultElement || this)[0], this.element = e(r), this.uuid = n++, this.eventNamespace = "." + this.widgetName + this.uuid, this.options = e.widget.extend({}, this.options, this._getCreateOptions(), t), this.bindings = e(), this.hoverable = e(), this.focusable = e(), r !== this && (e.data(r, this.widgetFullName, this), this._on(!0, this.element, {
                remove: function (e) {
                    e.target === r && this.destroy()
                }
            }), this.document = e(r.style ? r.ownerDocument : r.document || r), this.window = e(this.document[0].defaultView || this.document[0].parentWindow)), this._create(), this._trigger("create", null, this._getCreateEventData()), this._init()
        },
        _getCreateOptions: e.noop,
        _getCreateEventData: e.noop,
        _create: e.noop,
        _init: e.noop,
        destroy: function () {
            this._destroy(), this.element.unbind(this.eventNamespace).removeData(this.widgetName).removeData(this.widgetFullName).removeData(e.camelCase(this.widgetFullName)), this.widget().unbind(this.eventNamespace).removeAttr("aria-disabled").removeClass(this.widgetFullName + "-disabled " + "ui-state-disabled"), this.bindings.unbind(this.eventNamespace), this.hoverable.removeClass("ui-state-hover"), this.focusable.removeClass("ui-state-focus")
        },
        _destroy: e.noop,
        widget: function () {
            return this.element
        },
        option: function (n, r) {
            var i = n, s, o, u;
            if (arguments.length === 0)return e.widget.extend({}, this.options);
            if (typeof n == "string") {
                i = {}, s = n.split("."), n = s.shift();
                if (s.length) {
                    o = i[n] = e.widget.extend({}, this.options[n]);
                    for (u = 0; u < s.length - 1; u++)o[s[u]] = o[s[u]] || {}, o = o[s[u]];
                    n = s.pop();
                    if (r === t)return o[n] === t ? null : o[n];
                    o[n] = r
                } else {
                    if (r === t)return this.options[n] === t ? null : this.options[n];
                    i[n] = r
                }
            }
            return this._setOptions(i), this
        },
        _setOptions: function (e) {
            var t;
            for (t in e)this._setOption(t, e[t]);
            return this
        },
        _setOption: function (e, t) {
            return this.options[e] = t, e === "disabled" && (this.widget().toggleClass(this.widgetFullName + "-disabled ui-state-disabled", !!t).attr("aria-disabled", t), this.hoverable.removeClass("ui-state-hover"), this.focusable.removeClass("ui-state-focus")), this
        },
        enable: function () {
            return this._setOption("disabled", !1)
        },
        disable: function () {
            return this._setOption("disabled", !0)
        },
        _on: function (t, n, r) {
            var i, s = this;
            typeof t != "boolean" && (r = n, n = t, t = !1), r ? (n = i = e(n), this.bindings = this.bindings.add(n)) : (r = n, n = this.element, i = this.widget()), e.each(r, function (r, o) {
                function u() {
                    if (!t && (s.options.disabled === !0 || e(this).hasClass("ui-state-disabled")))return;
                    return (typeof o == "string" ? s[o] : o).apply(s, arguments)
                }

                typeof o != "string" && (u.guid = o.guid = o.guid || u.guid || e.guid++);
                var a = r.match(/^(\w+)\s*(.*)$/), f = a[1] + s.eventNamespace, l = a[2];
                l ? i.delegate(l, f, u) : n.bind(f, u)
            })
        },
        _off: function (e, t) {
            t = (t || "").split(" ").join(this.eventNamespace + " ") + this.eventNamespace, e.unbind(t).undelegate(t)
        },
        _delay: function (e, t) {
            function n() {
                return (typeof e == "string" ? r[e] : e).apply(r, arguments)
            }

            var r = this;
            return setTimeout(n, t || 0)
        },
        _hoverable: function (t) {
            this.hoverable = this.hoverable.add(t), this._on(t, {
                mouseenter: function (t) {
                    e(t.currentTarget).addClass("ui-state-hover")
                }, mouseleave: function (t) {
                    e(t.currentTarget).removeClass("ui-state-hover")
                }
            })
        },
        _focusable: function (t) {
            this.focusable = this.focusable.add(t), this._on(t, {
                focusin: function (t) {
                    e(t.currentTarget).addClass("ui-state-focus")
                }, focusout: function (t) {
                    e(t.currentTarget).removeClass("ui-state-focus")
                }
            })
        },
        _trigger: function (t, n, r) {
            var i, s, o = this.options[t];
            r = r || {}, n = e.Event(n), n.type = (t === this.widgetEventPrefix ? t : this.widgetEventPrefix + t).toLowerCase(), n.target = this.element[0], s = n.originalEvent;
            if (s)for (i in s)i in n || (n[i] = s[i]);
            return this.element.trigger(n, r), !(e.isFunction(o) && o.apply(this.element[0], [n].concat(r)) === !1 || n.isDefaultPrevented())
        }
    }, e.each({show: "fadeIn", hide: "fadeOut"}, function (t, n) {
        e.Widget.prototype["_" + t] = function (r, i, s) {
            typeof i == "string" && (i = {effect: i});
            var o, u = i ? i === !0 || typeof i == "number" ? n : i.effect || n : t;
            i = i || {}, typeof i == "number" && (i = {duration: i}), o = !e.isEmptyObject(i), i.complete = s, i.delay && r.delay(i.delay), o && e.effects && e.effects.effect[u] ? r[t](i) : u !== t && r[u] ? r[u](i.duration, i.easing, s) : r.queue(function (n) {
                e(this)[t](), s && s.call(r[0]), n()
            })
        }
    })
}(jQuery);
window.OB.RiLi.msg_config = {
    type: {
        fhv: "fake-has-value",
        fsv: "fake-set-value",
        ftc: "fake-trigger-change",
        fgv: "fake-get-value",
        fin: "fake-init",
        dch: "date-change",
        ctc: "clendar-trigger-change",
        hin: "hd-init",
        hgt: "hd-get-tpl",
        actiondefault: "action-default",
        actionquery: "action-query",
        actionfestival: "action-festival",
        actiongoupiao: "action-goupiao"
    }, returnValue: ""
};
/*
 * ! Mediator.js Library v0.9.5 https://github.com/ajacksified/Mediator.js
 * 
 * Copyright 2013, Jack Lawson MIT Licensed
 * (http://www.opensource.org/licenses/mit-license.php)
 * 
 * For more information:
 * http://thejacklawson.com/2011/06/mediators-for-modularized-asynchronous-programming-in-javascript/index.html
 * Project on GitHub: https://github.com/ajacksified/Mediator.js
 * 
 * Last update: June 13 2013
 */
(function (e, t) {
    "use strict";
    typeof exports != "undefined" ? exports.Mediator = t() : typeof define == "function" && define.amd ? define("mediator-js", [], function () {
        return e.Mediator = t(), e.Mediator()
    }) : e.Mediator = t()
})(this, function () {
    "use strict";
    function e() {
        var e = function () {
            return ((1 + Math.random()) * 65536 | 0).toString(16).substring(1)
        };
        return e() + e() + "-" + e() + "-" + e() + "-" + e() + "-" + e() + e() + e()
    }

    function t(n, r, i) {
        if (!(this instanceof t))return new t(n, r, i);
        this.id = e(), this.fn = n, this.options = r, this.context = i, this.channel = null
    }

    function n(e, t) {
        if (!(this instanceof n))return new n(e);
        this.namespace = e || "", this._subscribers = [], this._channels = [], this._parent = t, this.stopped = !1
    }

    function r() {
        if (!(this instanceof r))return new r;
        this._channels = new n("")
    }

    t.prototype = {
        update: function (e) {
            e && (this.fn = e.fn || this.fn, this.context = e.context || this.context, this.options = e.options || this.options, this.channel && this.options && this.options.priority !== undefined && this.channel.setPriority(this.id, this.options.priority))
        }
    }, n.prototype = {
        addSubscriber: function (e, n, r) {
            var i = new t(e, n, r);
            return n && n.priority !== undefined ? (n.priority = n.priority >> 0, n.priority < 0 && (n.priority = 0), n.priority >= this._subscribers.length && (n.priority = this._subscribers.length - 1), this._subscribers.splice(n.priority, 0, i)) : this._subscribers.push(i), i.channel = this, i
        }, stopPropagation: function () {
            this.stopped = !0
        }, getSubscriber: function (e) {
            var t = 0, n = this._subscribers.length;
            for (t, n; t < n; t++)if (this._subscribers[t].id === e || this._subscribers[t].fn === e)return this._subscribers[t]
        }, setPriority: function (e, t) {
            var n = 0, r = 0, i, s, o, u;
            for (r = 0, u = this._subscribers.length; r < u; r++) {
                if (this._subscribers[r].id === e || this._subscribers[r].fn === e)break;
                n++
            }
            i = this._subscribers[n], s = this._subscribers.slice(0, n), o = this._subscribers.slice(n + 1), this._subscribers = s.concat(o), this._subscribers.splice(t, 0, i)
        }, addChannel: function (e) {
            this._channels[e] = new n((this.namespace ? this.namespace + ":" : "") + e, this)
        }, hasChannel: function (e) {
            return this._channels.hasOwnProperty(e)
        }, returnChannel: function (e) {
            return this._channels[e]
        }, removeSubscriber: function (e) {
            var t = this._subscribers.length - 1;
            if (!e) {
                this._subscribers = [];
                return
            }
            for (t; t >= 0; t--)if (this._subscribers[t].fn === e || this._subscribers[t].id === e)this._subscribers[t].channel = null, this._subscribers.splice(t, 1)
        }, publish: function (e) {
            var t = 0, n = this._subscribers.length, r = !1, i, s, o, u;
            for (t, n; t < n; t++)this.stopped || (i = this._subscribers[t], i.options !== undefined && typeof i.options.predicate == "function" ? i.options.predicate.apply(i.context, e) && (i.fn.apply(i.context, e), r = !0) : (o = this._subscribers.length, i.fn.apply(i.context, e), u = this._subscribers.length, n = u, u === o - 1 && t--, r = !0)), r && i.options && i.options !== undefined && (i.options.calls--, i.options.calls < 1 && (this.removeSubscriber(i.id), n--, t--));
            this._parent && this._parent.publish(e), this.stopped = !1
        }
    }, r.prototype = {
        getChannel: function (e) {
            var t = this._channels, n = e.split(":"), r = 0, i = n.length;
            if (e === "")return t;
            if (n.length > 0)for (r, i; r < i; r++)t.hasChannel(n[r]) || t.addChannel(n[r]), t = t.returnChannel(n[r]);
            return t
        }, subscribe: function (e, t, n, r) {
            var i = this.getChannel(e);
            return n = n || {}, r = r || {}, i.addSubscriber(t, n, r)
        }, once: function (e, t, n, r) {
            return n = n || {}, n.calls = 1, this.subscribe(e, t, n, r)
        }, getSubscriber: function (e, t) {
            return this.getChannel(t || "").getSubscriber(e)
        }, remove: function (e, t) {
            this.getChannel(e).removeSubscriber(t)
        }, publish: function (e) {
            var t = Array.prototype.slice.call(arguments, 1), n = this.getChannel(e);
            t.push(n), this.getChannel(e).publish(t)
        }
    }, r.prototype.on = r.prototype.subscribe, r.prototype.bind = r.prototype.subscribe, r.prototype.emit = r.prototype.publish, r.prototype.trigger = r.prototype.publish, r.prototype.off = r.prototype.remove, r.Channel = n, r.Subscriber = t, r.version = "0.9.5", window.OB.RiLi.mediator = new r
});
(function () {
    function r(e) {
        this.date = e ? new Date(+e) : G.currDate || new Date
    }

    var e, t;
    $.route = function (t, n) {
        t = t || {};
        var r;
        (e || (e = /([\d\w_]+)/g)).lastIndex = 0;
        while ((r = e.exec(n)) !== null) {
            t = t[r[0]];
            if (t == undefined)break
        }
        return t
    }, $.format = function () {
        var e = $.makeArray(arguments), n = String(e.shift() || ""), r = [], i = e[0];
        return e = $.isArray(i) ? i : typeof i == "object" ? e : [e], $.each(e, function (e, i) {
            r.push(n.replace(t || (t = /\{([\d\w\.]+)\}/g), function (t, n, r) {
                return r = n === "INDEX" ? e : n.indexOf(".") < 0 ? i[n] : $.route(i, n), r === undefined ? t : $.isFunction(r) ? r.call(i, n) : r
            }))
        }), r.join("")
    };
    var n;
    $.padWithZero = function (e) {
        return e.replace(n || (n = /(^|\D)(\d)(?=$|\D)/g), "$10$2")
    }, r.prototype = {
        getMonthFirstDate: function () {
            var e = new Date(+this.date);
            return e.setDate(1), e
        }, getCalendarFirstDate: function () {
            var e = this.getMonthFirstDate(), t = e.getDay();
            return e.setDate(e.getDate() - (t == 0 ? 6 : t - 1)), e
        }
    }, window.OB.RiLi.Calendar = r
})();
(function () {
    function t(e) {
        var t = new Date(e);
        return +t < -0x94e9b950e00 ? null : new n(t)
    }

    function n(t) {
        this.oDate = t, this.julianDay = s.fromDate(this.oDate), this.cnDay = this.oDate.getDay() ? e.digitCN[this.oDate.getDay()] : "\u65e5";
        var n = this.julianDay - s.JD2000, o = i.getTerms(n), u = r.getNewMoons(o);
        t.getFullYear() == "1957" && (u[2].days = 30, u[3].days = 29, u[4].days = 30);
        for (var a = Math.round(n - u[0].JD), f = 0, l; f < u.length; f++) {
            l = u[f];
            if (a < l.days) {
                this.isBigMonth = l.days == 30, this.isLeap = l.isLeap, this.lMonth = l.name, this.lNextMonth = l.nextName, this.lDate = e.dateCn[a], this.dateIndex = a;
                break
            }
            a -= l.days
        }
        n = Math.round(n), this.lYear = Math.floor((o[3].JD + (n < o[3].JD ? -365 : 0) + 5844 - 35) / 365.2422 + .5);
        var c = u[u.zyIndex].JD;
        c -= n < c ? 365 : 0, c += 5810, this.sYear = Math.floor(c / 365.2422 + .5), this.hYear = this.sYear + 1984 + 2698;
        var c = o.hash[n];
        this.term = c ? c.name : "";
        var c = this.lYear + 6e3;
        this.animal = e.chineseZodiac[c % 12], this.db = e, this.gzYear = e.heavenlyStems[c % 10] + e.earthlyBranches[c % 12];
        var c = Math.floor((n - o[0].JD) / 30.43685);
        c < 12 && n >= o[2 * c + 1].JD && c++, c += Math.floor((o[12].JD + 390) / 365.2422) * 12 + 9e5, this.gzMonth = e.heavenlyStems[c % 10] + e.earthlyBranches[c % 12];
        var c = n - 6 + 9e6;
        this.gzDate = e.heavenlyStems[c % 10] + e.earthlyBranches[c % 12], this.gzChrono = e.earthlyBranches[Math.floor((this.oDate.getHours() + 1) / 2)] || "\u5b50"
    }

    function h(e) {
        var t = -0.043126 + 628.301955 * e - 2732e-9 * e * e, n = .016708634 - 42037e-9 * e - 1.267e-7 * e * e;
        return -20.49552 * (1 + n * Math.cos(t)) / f
    }

    function p(e) {
        return -0.0000034
    }

    function d(e) {
        var t, n, r = e * e, i = 0, s = c;
        for (t = 0; t < s.length; t += 5)t == 0 ? n = -1.742 * e : n = 0, i += (s[t + 3] + n) * Math.sin(s[t] + s[t + 1] * e + s[t + 2] * r);
        return i / 100 / f
    }

    function v(e) {
        return g(e / 365.2425 + 2e3) / 86400
    }

    function m(e, t) {
        var n = (e - 1820) / 100;
        return -20 + t * n * n
    }

    function g(e) {
        var t = l[l.length - 2], n = l[l.length - 1];
        if (e >= t) {
            var r = 31;
            if (e > t + 100)return m(e, r);
            var i = m(e, r), s = m(t, r) - n;
            return i - s * (t + 100 - e) / 100
        }
        var o, u = l;
        for (o = 0; o < u.length; o += 5)if (e < u[o + 5])break;
        var a = (e - u[o]) / (u[o + 5] - u[o]) * 10, f = a * a, c = f * a;
        return u[o + 1] + u[o + 2] * a + u[o + 3] * f + u[o + 4] * c
    }

    function y(e, t, n, r) {
        n /= 10;
        var i, s, a = 0, l = 1, c, h = u[e], p, d, v, m, g = t * 6 + 1, y = h[g + 1] - h[g];
        for (i = 0; i < 6; i++, l *= n) {
            p = h[g + i], d = h[g + 1 + i], m = d - p;
            if (!m)continue;
            r < 0 ? v = d : (v = Math.floor(3 * r * m / y + .5) + p, i && (v += 3), v > d && (v = d));
            for (s = p, c = 0; s < v; s += 3)c += h[s] * Math.cos(h[s + 1] + n * h[s + 2]);
            a += c * l
        }
        a /= h[0];
        if (e == 0) {
            var b = n * n, w = b * n;
            t == 0 && (a += (-0.0728 - 2.7702 * n - 1.1019 * b - .0996 * w) / f), t == 1 && (a += (0 + 4e-4 * n + 4e-4 * b - .0026 * w) / f), t == 2 && (a += (-0.002 + .0044 * n + .0213 * b - .025 * w) / 1e6)
        } else {
            var E = o[(e - 1) * 3 + t];
            t == 0 && (a += -3 * n / f), t == 2 ? a += E / 1e6 : a += E / f
        }
        return a
    }

    function b(e, t, n) {
        var r = a[e], i, s, o, u, l = 0, c = 1, h, p = t * t, d = p * t, v = d * t, m = v * t, g = t - 10;
        e == 0 && (l += (3.81034409 + 8399.684730072 * t - 3319e-8 * p + 3.11e-8 * d - 2.033e-10 * v) * f, l += 5028.792262 * t + 1.1124406 * p + 7699e-8 * d - 23479e-9 * v - 1.78e-8 * m, g > 0 && (l += -0.866 + 1.43 * g + .054 * g * g)), p /= 1e4, d /= 1e8, v /= 1e8, n *= 6, n < 0 && (n = r[0].length);
        for (i = 0; i < r.length; i++, c *= t) {
            o = r[i], u = Math.floor(n * o.length / r[0].length + .5), i && (u += 6), u >= o.length && (u = o.length);
            for (s = 0, h = 0; s < u; s += 6)h += o[s] * Math.cos(o[s + 1] + t * o[s + 2] + p * o[s + 3] + d * o[s + 4] + v * o[s + 5]);
            l += h * c
        }
        return e != 2 && (l /= f), l
    }

    function E(e) {
        var t = "0000000000", n = t + t, r = {
            J: "00",
            I: "000",
            H: "0000",
            G: "00000",
            t: "01",
            s: "001",
            r: "0001",
            q: "00001",
            p: "000001",
            o: "0000001",
            n: "00000001",
            m: "000000001",
            l: "0000000001",
            k: "03",
            j: "0303",
            i: "003",
            h: "003003",
            g: "0003",
            f: "00003",
            e: "000003",
            d: "0000003",
            c: "00000003",
            b: "000000003",
            a: "0000000003",
            A: n + n + n,
            B: n + n + t,
            C: n + n,
            D: n + t,
            E: n,
            F: t
        };
        return e.replace(/\D/g, function (e) {
            return r[e]
        })
    }

    function T(e) {
        return (e < 10 ? "0" : "") + e
    }

    var e = {
        digitCN: ["\u96f6", "\u4e00", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d", "\u5341"],
        heavenlyStems: ["\u7532", "\u4e59", "\u4e19", "\u4e01", "\u620a", "\u5df1", "\u5e9a", "\u8f9b", "\u58ec", "\u7678"],
        earthlyBranches: ["\u5b50", "\u4e11", "\u5bc5", "\u536f", "\u8fb0", "\u5df3", "\u5348", "\u672a", "\u7533", "\u9149", "\u620c", "\u4ea5"],
        chineseZodiac: ["\u9f20", "\u725b", "\u864e", "\u5154", "\u9f99", "\u86c7", "\u9a6c", "\u7f8a", "\u7334", "\u9e21", "\u72d7", "\u732a"],
        term: ["\u51ac\u81f3", "\u5c0f\u5bd2", "\u5927\u5bd2", "\u7acb\u6625", "\u96e8\u6c34", "\u60ca\u86f0", "\u6625\u5206", "\u6e05\u660e", "\u8c37\u96e8", "\u7acb\u590f", "\u5c0f\u6ee1", "\u8292\u79cd", "\u590f\u81f3", "\u5c0f\u6691", "\u5927\u6691", "\u7acb\u79cb", "\u5904\u6691", "\u767d\u9732", "\u79cb\u5206", "\u5bd2\u9732", "\u971c\u964d", "\u7acb\u51ac", "\u5c0f\u96ea", "\u5927\u96ea"],
        monthCn: ["\u5341\u4e00", "\u5341\u4e8c", "\u6b63", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d", "\u5341"],
        dateCn: ["\u521d\u4e00", "\u521d\u4e8c", "\u521d\u4e09", "\u521d\u56db", "\u521d\u4e94", "\u521d\u516d", "\u521d\u4e03", "\u521d\u516b", "\u521d\u4e5d", "\u521d\u5341", "\u5341\u4e00", "\u5341\u4e8c", "\u5341\u4e09", "\u5341\u56db", "\u5341\u4e94", "\u5341\u516d", "\u5341\u4e03", "\u5341\u516b", "\u5341\u4e5d", "\u4e8c\u5341", "\u5eff\u4e00", "\u5eff\u4e8c", "\u5eff\u4e09", "\u5eff\u56db", "\u5eff\u4e94", "\u5eff\u516d", "\u5eff\u4e03", "\u5eff\u516b", "\u5eff\u4e5d", "\u4e09\u5341", "\u5345\u4e00"]
    }, r = {
        correction: E("EqoFscDcrFpmEsF1DfFideFelFpFfFfFiaipqti3ksttikptikqckstekqttgkqttgkqteksttikptikq1fjstgjqttjkqttgkqtekstfkptikq1tijstgjiFkirFsAeACoFsiDaDiADc3AFbBfgdfikijFifegF3FhaikgFag3E1btaieeibggiffdeigFfqDfaiBkF3kEaikhkigeidhhdiegcFfakF3ggkidbiaedksaFffckekidhhdhdikcikiakicjF3deedFhFccgicdekgiFbiaikcfi3kbFibefgEgFdcFkFeFkdcfkF3kfkcickEiFkDacFiEfbiaejcFfffkhkdgkaiei3ehigikhdFikfckF3dhhdikcfgjikhfjicjicgiehdikcikggcifgiejF3jkieFhegikggcikFegiegkfjebhigikggcikdgkaFkijcfkcikfkcifikiggkaeeigefkcdfcfkhkdgkegieidhijcFfakhfgeidieidiegikhfkfckfcjbdehdikggikgkfkicjicjF3dbidikFiggcifgiejkiegkigcdiegfggcikdbgfgefjF3kfegikggcikdgFkeeijcfkcikfkekcikdgkabhkFikaffcfkhkdgkegbiaekfkiakicjhfgqdq1fkiakgkfkhfkfcjiekgFebicggbedF3jikejbbbiakgbgkacgiejkijjgigfiakggfggcibFifjefjF3kfekdgjcibFeFkijcfkfhkfkeaieigekgbhkfikidfcjeaibgekgdkiffiffkiakF3jhbakgdki3dj3ikfkicjicjieeFkgdkicggkighdF3jfgkgfgbdkicggfggkidFkiekgijkeigfiskiggfaidheigF3jekijcikickiggkidhhdbgcfkFikikhkigeidieFikggikhkffaffijhidhhakgdkhkijF3kiakF3kfheakgdkifiggkigicjiejkieedikgdfcggkigieeiejfgkgkigbgikicggkiaideeijkefjeijikhkiggkiaidheigcikaikffikijgkiahi3hhdikgjfifaakekighie3hiaikggikhkffakicjhiahaikggikhkijF3kfejfeFhidikggiffiggkigicjiekgieeigikggiffiggkidheigkgfjkeigiegikifiggkidhedeijcfkFikikhkiggkidhh3ehigcikaffkhkiggkidhh3hhigikekfiFkFikcidhh3hitcikggikhkfkicjicghiediaikggikhkijbjfejfeFhaikggifikiggkigiejkikgkgieeigikggiffiggkigieeigekijcijikggifikiggkideedeijkefkfckikhkiggkidhh3ehijcikaffkhkiggkidhh3hhigikhkikFikfckcidhh3hiaikgjikhfjicjicgiehdikcikggifikigiejfejkieFhegikggifikiggfghigkfjeijkhigikggifikiggkigieeijcijcikfksikifikiggkidehdeijcfdckikhkiggkhghh3ehijikifffffkhsFngErD3pAfBoDd3BlEtFqA1AqoEpDqElAEsEeB1BmADlDkqBtC3FnEpDqnEmFsFsAFnllBbFmDsDiCtDmAB1BmtCgpEplCpAEiBiEoFqFtEqsDcCnFtADnFlEgdkEgmEtEsCtDmADqFtAFrAtEcCqAE3BoFqC3F3DrFtBmFtAC1ACnFaoCgADcADcCcFfoFtDlAFgmFqBq1bpEoAEmkqnEeCtAE3bAEqgDfFfCrgEcBrACfAAABqAAB3AAClEnFeCtCgAADqDoBmtAAACbFiAAADsEtBqAB1FsDqpFqEmFsCeDtFlCeDtoEpClEqAAFrAFoCgFmFsFqEnAEcCqFeCtFtEnAEeFtAAEkFnErAABbFkADnAAeCtFeAfBoAEpFtAABtFqAApDcCGJ"),
        calcForLow: function (e) {
            var t = 7771.37714500204, n = (e + 1.08472) / t, r;
            return n -= (-0.0000331 * n * n + .10976 * Math.cos(.785 + 8328.6914 * n) + .02224 * Math.cos(.187 + 7214.0629 * n) - .03342 * Math.cos(4.669 + 628.3076 * n)) / t + (32 * (n + 1.8) * (n + 1.8) - 20) / 86400 / 36525, n * 36525 + 8 / 24
        },
        calcForHigh: function (e) {
            var t = w.MS_aLon_t2(e) * 36525;
            t = t - v(t) + 8 / 24;
            var n = (t + .5) % 1 * 86400;
            if (n < 1800 || n > 84600)t = w.MS_aLon_t(e) * 36525 - v(t) + 8 / 24;
            return t
        },
        cache: {},
        getNewMoons: function (t) {
            var n = t[0].JD, i = r.calc(n), s = [];
            i > n && (i -= 29.53);
            if (r.cache[i])s = r.cache[i]; else {
                for (var o = 0; o < 15; o++)s.push({
                    JD: r.calc(i + 29.5306 * o),
                    index: o
                }), o && (s[o - 1].days = s[o].JD - s[o - 1].JD);
                if (s[13].JD <= t[24].JD) {
                    for (o = 1; s[o + 1].JD > t[2 * o].JD && o < 13; o++);
                    s[o].isLeap = !0;
                    for (; o < 14; o++)s[o].index--
                }
                for (o = 0; o < 14; o++)s[o].name = (s[o].isLeap ? "\u95f0" : "") + e.monthCn[s[o].index % 12], s[o].nextName = (s[o + 1].isLeap ? "\u95f0" : "") + e.monthCn[s[o + 1].index % 12], s[o].index == 2 && (s.zyIndex = o);
                r.cache[i] = s
            }
            return s
        },
        calc: function (e) {
            e += s.JD2000;
            var t, n, r = 14, i = 1947168, o = 2436935;
            if (e >= o)return Math.floor(this.calcForHigh(Math.floor((e + r - 2451551) / 29.5306) * Math.PI * 2) + .5);
            if (e >= i && e < o)return t = Math.floor(this.calcForLow(Math.floor((e + r - 2451551) / 29.5306) * Math.PI * 2) + .5), n = this.correction.substr(Math.floor((e - i) / 29.5306), 1) - 0, t + (n ? n - 2 : n)
        }
    }, i = {
        correction: E("FrcFs11AFsckF1tsDtFqEtF3posFdFgiFseFtmelpsEfhkF1anmelpFlF3ikrotcnEqEq1FfqmcDsrFor11FgFrcgDscFs11FgEeFtE1sfFs11sCoEsaF1tsD3FpeE1eFsssEciFsFnmelpFcFhkF1tcnEqEpFgkrotcnEqrEtFermcDsrE111FgBmcmr11DaEfnaF111sD3FpeForeF1tssEfiFpEoeFssD3iFstEqFppDgFstcnEqEpFg33FscnEqrAoAF1ClAEsDmDtCtBaDlAFbAEpAAAAAD1FgBiBqoBbnBaBoAAAAAAAEgDqAdBqAFrBaBoACdAAf3AACgAAAeBbCamDgEifAE1AABa3C3BgFdiAAACoCeE3ADiEifDaAEqAAFe3AcFbcAAAAAF3iFaAAACpACmFmAAAAAAAACrDaAAADG0"),
        calcForLow: function (e) {
            var t, n, r = 628.3319653318;
            return t = (e - 4.895062166) / r, t -= (53 * t * t + 334116 * Math.cos(4.67 + 628.307585 * t) + 2061 * Math.cos(2.678 + 628.3076 * t) * t) / r / 1e7, n = 48950621.66 + 6283319653.318 * t + 53 * t * t + 334166 * Math.cos(4.669257 + 628.307585 * t) + 3489 * Math.cos(4.6261 + 1256.61517 * t) + 2060.6 * Math.cos(2.67823 + 628.307585 * t) * t - 994 - 834 * Math.sin(2.1824 - 33.75705 * t), t -= (n / 1e7 - e) / 628.332 + (32 * (t + 1.8) * (t + 1.8) - 20) / 86400 / 36525, t * 36525 + 8 / 24
        },
        getNearestWinter: function (e) {
            var t = Math.floor((e - 355 + 183) / 365.2422) * 365.2422 + 355;
            return i.calc(t) > e && (t -= 365.2422), t
        },
        cache: {},
        getTerms: function (t) {
            var n = i.getNearestWinter(t), r = [];
            if (i.cache[n])r = i.cache[n]; else {
                r.hash = {};
                for (var s = 0, o; s < 25; s++)o = {
                    JD: i.calc(n + 15.2184 * s),
                    name: e.term[s % 24]
                }, r.push(o), r.hash[o.JD] = o;
                i.cache[n] = r
            }
            return r
        },
        calcForHigh: function (e) {
            var t = w.S_aLon_t2(e) * 36525;
            t = t - v(t) + 8 / 24;
            var n = (t + .5) % 1 * 86400;
            if (n < 1200 || n > 85200)t = w.S_aLon_t(e) * 36525 - v(t) + 8 / 24;
            return t
        },
        calc: function (e) {
            e += s.JD2000;
            var t, n, r, i = 7, o = 2322147.76, u = 2436935;
            if (e >= u)return Math.floor(this.calcForHigh(Math.floor((e + i - 2451259) / 365.2422 * 24) * Math.PI / 12) + .5);
            if (e >= o && e < u)return n = Math.floor(this.calcForLow(Math.floor((e + i - 2451259) / 365.2422 * 24) * Math.PI / 12) + .5), r = this.correction.substr(Math.floor((e - o) / 365.2422 * 24), 1) - 0, n + (r ? r - 2 : r)
        }
    }, s = {
        JD2000: 2451545, fromDate: function (e) {
            var t = e.getFullYear(), n = e.getMonth() + 1, r = e.getDate() + ((e.getSeconds() / 60 + e.getMinutes()) / 60 + e.getHours()) / 24, i = t * 372 + n * 31 + Math.floor(r) >= 588829, s = 0;
            return n <= 2 && (n += 12, t -= 1), i && (s = Math.floor(t / 100), s = 2 - s + Math.floor(s / 4)), Math.floor(365.25 * (t + 4716)) + Math.floor(30.6001 * (n + 1)) + r + s - 1524.5
        }
    }, o = [-0.08631, 39e-5, -0.00008, -0.07447, 6e-5, 17e-5, -0.07135, -0.00026, -0.00176, -0.20239, .00273, -0.00347, -0.25486, .00276, .42926, .24588, .00345, -14.46266, -0.95116, .02481, 58.30651], u = new Array(new Array(1e10, 20, 578, 920, 1100, 1124, 1136, 1148, 1217, 1226, 1229, 1229, 1229, 1229, 1937, 2363, 2618, 2633, 2660, 2666, 17534704567, 0, 0, 334165646, 4.669256804, 6283.075849991, 3489428, 4.6261024, 12566.1517, 349706, 2.744118, 5753.384885, 341757, 2.828866, 3.523118, 313590, 3.62767, 77713.771468, 267622, 4.418084, 7860.419392, 234269, 6.135162, 3930.209696, 132429, .742464, 11506.76977, 127317, 2.037097, 529.690965, 119917, 1.109629, 1577.343542, 99025, 5.23268, 5884.92685, 90186, 2.04505, 26.29832, 85722, 3.50849, 398.149, 77979, 1.17883, 5223.69392, 75314, 2.53339, 5507.55324, 50526, 4.58293, 18849.22755, 49238, 4.20507, 775.52261, 35666, 2.91954, .06731, 31709, 5.84902, 11790.62909, 28413, 1.89869, 796.29801, 27104, .31489, 10977.0788, 24281, .34481, 5486.77784, 20616, 4.80647, 2544.31442, 20539, 1.86948, 5573.1428, 20226, 2.45768, 6069.77675, 15552, .83306, 213.2991, 13221, 3.41118, 2942.46342, 12618, 1.08303, 20.7754, 11513, .64545, .98032, 10285, .636, 4694.00295, 10190, .97569, 15720.83878, 10172, 4.2668, 7.11355, 9921, 6.2099, 2146.1654, 9761, .681, 155.4204, 8580, 5.9832, 161000.6857, 8513, 1.2987, 6275.9623, 8471, 3.6708, 71430.6956, 7964, 1.8079, 17260.1547, 7876, 3.037, 12036.4607, 7465, 1.7551, 5088.6288, 7387, 3.5032, 3154.6871, 7355, 4.6793, 801.8209, 6963, .833, 9437.7629, 6245, 3.9776, 8827.3903, 6115, 1.8184, 7084.8968, 5696, 2.7843, 6286.599, 5612, 4.3869, 14143.4952, 5558, 3.4701, 6279.5527, 5199, .1891, 12139.5535, 5161, 1.3328, 1748.0164, 5115, .2831, 5856.4777, 4900, .4874, 1194.447, 4104, 5.3682, 8429.2413, 4094, 2.3985, 19651.0485, 3920, 6.1683, 10447.3878, 3677, 6.0413, 10213.2855, 3660, 2.5696, 1059.3819, 3595, 1.7088, 2352.8662, 3557, 1.776, 6812.7668, 3329, .5931, 17789.8456, 3041, .4429, 83996.8473, 3005, 2.7398, 1349.8674, 2535, 3.1647, 4690.4798, 2474, .2148, 3.5904, 2366, .4847, 8031.0923, 2357, 2.0653, 3340.6124, 2282, 5.222, 4705.7323, 2189, 5.5559, 553.5694, 2142, 1.4256, 16730.4637, 2109, 4.1483, 951.7184, 2030, .3713, 283.8593, 1992, 5.2221, 12168.0027, 1986, 5.7747, 6309.3742, 1912, 3.8222, 23581.2582, 1889, 5.3863, 149854.4001, 1790, 2.2149, 13367.9726, 1748, 4.5605, 135.0651, 1622, 5.9884, 11769.8537, 1508, 4.1957, 6256.7775, 1442, 4.1932, 242.7286, 1435, 3.7236, 38.0277, 1397, 4.4014, 6681.2249, 1362, 1.8893, 7632.9433, 1250, 1.1305, 5.5229, 1205, 2.6223, 955.5997, 1200, 1.0035, 632.7837, 1129, .1774, 4164.312, 1083, .3273, 103.0928, 1052, .9387, 11926.2544, 1050, 5.3591, 1592.596, 1033, 6.1998, 6438.4962, 1001, 6.0291, 5746.2713, 980, .999, 11371.705, 980, 5.244, 27511.468, 938, 2.624, 5760.498, 923, .483, 522.577, 922, 4.571, 4292.331, 905, 5.337, 6386.169, 862, 4.165, 7058.598, 841, 3.299, 7234.794, 836, 4.539, 25132.303, 813, 6.112, 4732.031, 812, 6.271, 426.598, 801, 5.821, 28.449, 787, .996, 5643.179, 776, 2.957, 23013.54, 769, 3.121, 7238.676, 758, 3.974, 11499.656, 735, 4.386, 316.392, 731, .607, 11513.883, 719, 3.998, 74.782, 706, .323, 263.084, 676, 5.911, 90955.552, 663, 3.665, 17298.182, 653, 5.791, 18073.705, 630, 4.717, 6836.645, 615, 1.458, 233141.314, 612, 1.075, 19804.827, 596, 3.321, 6283.009, 596, 2.876, 6283.143, 555, 2.452, 12352.853, 541, 5.392, 419.485, 531, .382, 31441.678, 519, 4.065, 6208.294, 513, 2.361, 10973.556, 494, 5.737, 9917.697, 450, 3.272, 11015.106, 449, 3.653, 206.186, 447, 2.064, 7079.374, 435, 4.423, 5216.58, 421, 1.906, 245.832, 413, .921, 3738.761, 402, .84, 20.355, 387, 1.826, 11856.219, 379, 2.344, 3.881, 374, 2.954, 3128.389, 370, 5.031, 536.805, 365, 1.018, 16200.773, 365, 1.083, 88860.057, 352, 5.978, 3894.182, 352, 2.056, 244287.6, 351, 3.713, 6290.189, 340, 1.106, 14712.317, 339, .978, 8635.942, 339, 3.202, 5120.601, 333, .837, 6496.375, 325, 3.479, 6133.513, 316, 5.089, 21228.392, 316, 1.328, 10873.986, 309, 3.646, 10.637, 303, 1.802, 35371.887, 296, 3.397, 9225.539, 288, 6.026, 154717.61, 281, 2.585, 14314.168, 262, 3.856, 266.607, 262, 2.579, 22483.849, 257, 1.561, 23543.231, 255, 3.949, 1990.745, 251, 3.744, 10575.407, 240, 1.161, 10984.192, 238, .106, 7.046, 236, 4.272, 6040.347, 234, 3.577, 10969.965, 211, 3.714, 65147.62, 210, .754, 13521.751, 207, 4.228, 5650.292, 202, .814, 170.673, 201, 4.629, 6037.244, 200, .381, 6172.87, 199, 3.933, 6206.81, 199, 5.197, 6262.3, 197, 1.046, 18209.33, 195, 1.07, 5230.807, 195, 4.869, 36.028, 194, 4.313, 6244.943, 192, 1.229, 709.933, 192, 5.595, 6282.096, 192, .602, 6284.056, 189, 3.744, 23.878, 188, 1.904, 15.252, 188, .867, 22003.915, 182, 3.681, 15110.466, 181, .491, 1.484, 179, 3.222, 39302.097, 179, 1.259, 12559.038, 62833196674749, 0, 0, 20605886, 2.67823456, 6283.07584999, 430343, 2.635127, 12566.1517, 42526, 1.59047, 3.52312, 11926, 5.79557, 26.29832, 10898, 2.96618, 1577.34354, 9348, 2.5921, 18849.2275, 7212, 1.1385, 529.691, 6777, 1.8747, 398.149, 6733, 4.4092, 5507.5532, 5903, 2.888, 5223.6939, 5598, 2.1747, 155.4204, 4541, .398, 796.298, 3637, .4662, 775.5226, 2896, 2.6471, 7.1135, 2084, 5.3414, .9803, 1910, 1.8463, 5486.7778, 1851, 4.9686, 213.2991, 1729, 2.9912, 6275.9623, 1623, .0322, 2544.3144, 1583, 1.4305, 2146.1654, 1462, 1.2053, 10977.0788, 1246, 2.8343, 1748.0164, 1188, 3.258, 5088.6288, 1181, 5.2738, 1194.447, 1151, 2.075, 4694.003, 1064, .7661, 553.5694, 997, 1.303, 6286.599, 972, 4.239, 1349.867, 945, 2.7, 242.729, 858, 5.645, 951.718, 758, 5.301, 2352.866, 639, 2.65, 9437.763, 610, 4.666, 4690.48, 583, 1.766, 1059.382, 531, .909, 3154.687, 522, 5.661, 71430.696, 520, 1.854, 801.821, 504, 1.425, 6438.496, 433, .241, 6812.767, 426, .774, 10447.388, 413, 5.24, 7084.897, 374, 2.001, 8031.092, 356, 2.429, 14143.495, 350, 4.8, 6279.553, 337, .888, 12036.461, 337, 3.862, 1592.596, 325, 3.4, 7632.943, 322, .616, 8429.241, 318, 3.188, 4705.732, 297, 6.07, 4292.331, 295, 1.431, 5746.271, 290, 2.325, 20.355, 275, .935, 5760.498, 270, 4.804, 7234.794, 253, 6.223, 6836.645, 228, 5.003, 17789.846, 225, 5.672, 11499.656, 215, 5.202, 11513.883, 208, 3.955, 10213.286, 208, 2.268, 522.577, 206, 2.224, 5856.478, 206, 2.55, 25132.303, 203, .91, 6256.778, 189, .532, 3340.612, 188, 4.735, 83996.847, 179, 1.474, 4164.312, 178, 3.025, 5.523, 177, 3.026, 5753.385, 159, 4.637, 3.286, 157, 6.124, 5216.58, 155, 3.077, 6681.225, 154, 4.2, 13367.973, 143, 1.191, 3894.182, 138, 3.093, 135.065, 136, 4.245, 426.598, 134, 5.765, 6040.347, 128, 3.085, 5643.179, 127, 2.092, 6290.189, 125, 3.077, 11926.254, 125, 3.445, 536.805, 114, 3.244, 12168.003, 112, 2.318, 16730.464, 111, 3.901, 11506.77, 111, 5.32, 23.878, 105, 3.75, 7860.419, 103, 2.447, 1990.745, 96, .82, 3.88, 96, 4.08, 6127.66, 91, 5.42, 206.19, 91, .42, 7079.37, 88, 5.17, 11790.63, 81, .34, 9917.7, 80, 3.89, 10973.56, 78, 2.4, 1589.07, 78, 2.58, 11371.7, 77, 3.98, 955.6, 77, 3.36, 36.03, 76, 1.3, 103.09, 75, 5.18, 10969.97, 75, 4.96, 6496.37, 73, 5.21, 38.03, 72, 2.65, 6309.37, 70, 5.61, 3738.76, 69, 2.6, 3496.03, 69, .39, 15.25, 69, 2.78, 20.78, 65, 1.13, 7058.6, 64, 4.28, 28.45, 61, 5.63, 10984.19, 60, .73, 419.48, 60, 5.28, 10575.41, 58, 5.55, 17298.18, 58, 3.19, 4732.03, 5291887, 0, 0, 871984, 1.072097, 6283.07585, 30913, .86729, 12566.1517, 2734, .053, 3.5231, 1633, 5.1883, 26.2983, 1575, 3.6846, 155.4204, 954, .757, 18849.228, 894, 2.057, 77713.771, 695, .827, 775.523, 506, 4.663, 1577.344, 406, 1.031, 7.114, 381, 3.441, 5573.143, 346, 5.141, 796.298, 317, 6.053, 5507.553, 302, 1.192, 242.729, 289, 6.117, 529.691, 271, .306, 398.149, 254, 2.28, 553.569, 237, 4.381, 5223.694, 208, 3.754, .98, 168, .902, 951.718, 153, 5.759, 1349.867, 145, 4.364, 1748.016, 134, 3.721, 1194.447, 125, 2.948, 6438.496, 122, 2.973, 2146.165, 110, 1.271, 161000.686, 104, .604, 3154.687, 100, 5.986, 6286.599, 92, 4.8, 5088.63, 89, 5.23, 7084.9, 83, 3.31, 213.3, 76, 3.42, 5486.78, 71, 6.19, 4690.48, 68, 3.43, 4694, 65, 1.6, 2544.31, 64, 1.98, 801.82, 61, 2.48, 10977.08, 50, 1.44, 6836.65, 49, 2.34, 1592.6, 46, 1.31, 4292.33, 46, 3.81, 149854.4, 43, .04, 7234.79, 40, 4.94, 7632.94, 39, 1.57, 71430.7, 38, 3.17, 6309.37, 35, .99, 6040.35, 35, .67, 1059.38, 31, 3.18, 2352.87, 31, 3.55, 8031.09, 30, 1.92, 10447.39, 30, 2.52, 6127.66, 28, 4.42, 9437.76, 28, 2.71, 3894.18, 27, .67, 25132.3, 26, 5.27, 6812.77, 25, .55, 6279.55, 23, 1.38, 4705.73, 22, .64, 6256.78, 20, 6.07, 640.88, 28923, 5.84384, 6283.07585, 3496, 0, 0, 1682, 5.4877, 12566.1517, 296, 5.196, 155.42, 129, 4.722, 3.523, 71, 5.3, 18849.23, 64, 5.97, 242.73, 40, 3.79, 553.57, 11408, 3.14159, 0, 772, 4.134, 6283.076, 77, 3.84, 12566.15, 42, .42, 155.42, 88, 3.14, 0, 17, 2.77, 6283.08, 5, 2.01, 155.42, 3, 2.21, 12566.15, 27962, 3.1987, 84334.66158, 10164, 5.42249, 5507.55324, 8045, 3.8801, 5223.6939, 4381, 3.7044, 2352.8662, 3193, 4.0003, 1577.3435, 2272, 3.9847, 1047.7473, 1814, 4.9837, 6283.0758, 1639, 3.5646, 5856.4777, 1444, 3.7028, 9437.7629, 1430, 3.4112, 10213.2855, 1125, 4.8282, 14143.4952, 1090, 2.0857, 6812.7668, 1037, 4.0566, 71092.8814, 971, 3.473, 4694.003, 915, 1.142, 6620.89, 878, 4.44, 5753.385, 837, 4.993, 7084.897, 770, 5.554, 167621.576, 719, 3.602, 529.691, 692, 4.326, 6275.962, 558, 4.41, 7860.419, 529, 2.484, 4705.732, 521, 6.25, 18073.705, 903, 3.897, 5507.553, 618, 1.73, 5223.694, 380, 5.244, 2352.866, 166, 1.627, 84334.662, 10001398880, 0, 0, 167069963, 3.098463508, 6283.075849991, 1395602, 3.0552461, 12566.1517, 308372, 5.198467, 77713.771468, 162846, 1.173877, 5753.384885, 157557, 2.846852, 7860.419392, 92480, 5.45292, 11506.76977, 54244, 4.56409, 3930.2097, 47211, 3.661, 5884.92685, 34598, .96369, 5507.55324, 32878, 5.89984, 5223.69392, 30678, .29867, 5573.1428, 24319, 4.2735, 11790.62909, 21183, 5.84715, 1577.34354, 18575, 5.02194, 10977.0788, 17484, 3.01194, 18849.22755, 10984, 5.05511, 5486.77784, 9832, .8868, 6069.7768, 8650, 5.6896, 15720.8388, 8583, 1.2708, 161000.6857, 6490, .2725, 17260.1547, 6292, .9218, 529.691, 5706, 2.0137, 83996.8473, 5574, 5.2416, 71430.6956, 4938, 3.245, 2544.3144, 4696, 2.5781, 775.5226, 4466, 5.5372, 9437.7629, 4252, 6.0111, 6275.9623, 3897, 5.3607, 4694.003, 3825, 2.3926, 8827.3903, 3749, .8295, 19651.0485, 3696, 4.9011, 12139.5535, 3566, 1.6747, 12036.4607, 3454, 1.8427, 2942.4634, 3319, .2437, 7084.8968, 3192, .1837, 5088.6288, 3185, 1.7778, 398.149, 2846, 1.2134, 6286.599, 2779, 1.8993, 6279.5527, 2628, 4.589, 10447.3878, 2460, 3.7866, 8429.2413, 2393, 4.996, 5856.4777, 2359, .2687, 796.298, 2329, 2.8078, 14143.4952, 2210, 1.95, 3154.6871, 2035, 4.6527, 2146.1654, 1951, 5.3823, 2352.8662, 1883, .6731, 149854.4001, 1833, 2.2535, 23581.2582, 1796, .1987, 6812.7668, 1731, 6.152, 16730.4637, 1717, 4.4332, 10213.2855, 1619, 5.2316, 17789.8456, 1381, 5.1896, 8031.0923, 1364, 3.6852, 4705.7323, 1314, .6529, 13367.9726, 1041, 4.3329, 11769.8537, 1017, 1.5939, 4690.4798, 998, 4.201, 6309.374, 966, 3.676, 27511.468, 874, 6.064, 1748.016, 779, 3.674, 12168.003, 771, .312, 7632.943, 756, 2.626, 6256.778, 746, 5.648, 11926.254, 693, 2.924, 6681.225, 680, 1.423, 23013.54, 674, .563, 3340.612, 663, 5.661, 11371.705, 659, 3.136, 801.821, 648, 2.65, 19804.827, 615, 3.029, 233141.314, 612, 5.134, 1194.447, 563, 4.341, 90955.552, 552, 2.091, 17298.182, 534, 5.1, 31441.678, 531, 2.407, 11499.656, 523, 4.624, 6438.496, 513, 5.324, 11513.883, 477, .256, 11856.219, 461, 1.722, 7234.794, 458, 3.766, 6386.169, 458, 4.466, 5746.271, 423, 1.055, 5760.498, 422, 1.557, 7238.676, 415, 2.599, 7058.598, 401, 3.03, 1059.382, 397, 1.201, 1349.867, 379, 4.907, 4164.312, 360, 5.707, 5643.179, 352, 3.626, 244287.6, 348, .761, 10973.556, 342, 3.001, 4292.331, 336, 4.546, 4732.031, 334, 3.138, 6836.645, 324, 4.164, 9917.697, 316, 1.691, 11015.106, 307, .238, 35371.887, 298, 1.306, 6283.143, 298, 1.75, 6283.009, 293, 5.738, 16200.773, 286, 5.928, 14712.317, 281, 3.515, 21228.392, 280, 5.663, 8635.942, 277, .513, 26.298, 268, 4.207, 18073.705, 266, .9, 12352.853, 260, 2.962, 25132.303, 255, 2.477, 6208.294, 242, 2.8, 709.933, 231, 1.054, 22483.849, 229, 1.07, 14314.168, 216, 1.314, 154717.61, 215, 6.038, 10873.986, 200, .561, 7079.374, 198, 2.614, 951.718, 197, 4.369, 167283.762, 186, 2.861, 5216.58, 183, 1.66, 39302.097, 183, 5.912, 3738.761, 175, 2.145, 6290.189, 173, 2.168, 10575.407, 171, 3.702, 1592.596, 171, 1.343, 3128.389, 164, 5.55, 6496.375, 164, 5.856, 10984.192, 161, 1.998, 10969.965, 161, 1.909, 6133.513, 157, 4.955, 25158.602, 154, 6.216, 23543.231, 153, 5.357, 13521.751, 150, 5.77, 18209.33, 150, 5.439, 155.42, 139, 1.778, 9225.539, 139, 1.626, 5120.601, 128, 2.46, 13916.019, 123, .717, 143571.324, 122, 2.654, 88860.057, 121, 4.414, 3894.182, 121, 1.192, 3.523, 120, 4.03, 553.569, 119, 1.513, 17654.781, 117, 3.117, 14945.316, 113, 2.698, 6040.347, 110, 3.085, 43232.307, 109, .998, 955.6, 108, 2.939, 17256.632, 107, 5.285, 65147.62, 103, .139, 11712.955, 103, 5.85, 213.299, 102, 3.046, 6037.244, 101, 2.842, 8662.24, 100, 3.626, 6262.3, 98, 2.36, 6206.81, 98, 5.11, 6172.87, 98, 2, 15110.47, 97, 2.67, 5650.29, 97, 2.75, 6244.94, 96, 4.02, 6282.1, 96, 5.31, 6284.06, 92, .1, 29088.81, 85, 3.26, 20426.57, 84, 2.6, 28766.92, 81, 3.58, 10177.26, 80, 5.81, 5230.81, 78, 2.53, 16496.36, 77, 4.06, 6127.66, 73, .04, 5481.25, 72, 5.96, 12559.04, 72, 5.92, 4136.91, 71, 5.49, 22003.91, 70, 3.41, 7.11, 69, .62, 11403.68, 69, 3.9, 1589.07, 69, 1.96, 12416.59, 69, 4.51, 426.6, 67, 1.61, 11087.29, 66, 4.5, 47162.52, 66, 5.08, 283.86, 66, 4.32, 16858.48, 65, 1.04, 6062.66, 64, 1.59, 18319.54, 63, 5.7, 45892.73, 63, 4.6, 66567.49, 63, 3.82, 13517.87, 62, 2.62, 11190.38, 61, 1.54, 33019.02, 60, 5.58, 10344.3, 60, 5.38, 316428.23, 60, 5.78, 632.78, 59, 6.12, 9623.69, 57, .16, 17267.27, 57, 3.86, 6076.89, 57, 1.98, 7668.64, 56, 4.78, 20199.09, 55, 4.56, 18875.53, 55, 3.51, 17253.04, 54, 3.07, 226858.24, 54, 4.83, 18422.63, 53, 5.02, 12132.44, 52, 3.63, 5333.9, 52, .97, 155427.54, 51, 3.36, 20597.24, 50, .99, 11609.86, 50, 2.21, 1990.75, 48, 1.62, 12146.67, 48, 1.17, 12569.67, 47, 4.62, 5436.99, 47, 1.81, 12562.63, 47, .59, 21954.16, 47, .76, 7342.46, 46, .27, 4590.91, 46, 3.77, 156137.48, 45, 5.66, 10454.5, 44, 5.84, 3496.03, 43, .24, 17996.03, 41, 5.93, 51092.73, 41, 4.21, 12592.45, 40, 5.14, 1551.05, 40, 5.28, 15671.08, 39, 3.69, 18052.93, 39, 4.94, 24356.78, 38, 2.72, 11933.37, 38, 5.23, 7477.52, 38, 4.99, 9779.11, 37, 3.7, 9388.01, 37, 4.44, 4535.06, 36, 2.16, 28237.23, 36, 2.54, 242.73, 36, .22, 5429.88, 35, 6.15, 19800.95, 35, 2.92, 36949.23, 34, 5.63, 2379.16, 34, 5.73, 16460.33, 34, 5.11, 5849.36, 33, 6.19, 6268.85, 10301861, 1.1074897, 6283.07584999, 172124, 1.064423, 12566.1517, 70222, 3.14159, 0, 3235, 1.0217, 18849.2275, 3080, 2.8435, 5507.5532, 2497, 1.3191, 5223.6939, 1849, 1.4243, 1577.3435, 1008, 5.9138, 10977.0788, 865, 1.42, 6275.962, 863, .271, 5486.778, 507, 1.686, 5088.629, 499, 6.014, 6286.599, 467, 5.987, 529.691, 440, .518, 4694.003, 410, 1.084, 9437.763, 387, 4.75, 2544.314, 375, 5.071, 796.298, 352, .023, 83996.847, 344, .949, 71430.696, 341, 5.412, 775.523, 322, 6.156, 2146.165, 286, 5.484, 10447.388, 284, 3.42, 2352.866, 255, 6.132, 6438.496, 252, .243, 398.149, 243, 3.092, 4690.48, 225, 3.689, 7084.897, 220, 4.952, 6812.767, 219, .42, 8031.092, 209, 1.282, 1748.016, 193, 5.314, 8429.241, 185, 1.82, 7632.943, 175, 3.229, 6279.553, 173, 1.537, 4705.732, 158, 4.097, 11499.656, 158, 5.539, 3154.687, 150, 3.633, 11513.883, 148, 3.222, 7234.794, 147, 3.653, 1194.447, 144, .817, 14143.495, 135, 6.151, 5746.271, 134, 4.644, 6836.645, 128, 2.693, 1349.867, 123, 5.65, 5760.498, 118, 2.577, 13367.973, 113, 3.357, 17789.846, 110, 4.497, 4292.331, 108, 5.828, 12036.461, 102, 5.621, 6256.778, 99, 1.14, 1059.38, 98, .66, 5856.48, 93, 2.32, 10213.29, 92, .77, 16730.46, 88, 1.5, 11926.25, 86, 1.42, 5753.38, 85, .66, 155.42, 81, 1.64, 6681.22, 80, 4.11, 951.72, 66, 4.55, 5216.58, 65, .98, 25132.3, 64, 4.19, 6040.35, 64, .52, 6290.19, 63, 1.51, 5643.18, 59, 6.18, 4164.31, 57, 2.3, 10973.56, 55, 2.32, 11506.77, 55, 2.2, 1592.6, 55, 5.27, 3340.61, 54, 5.54, 553.57, 53, 5.04, 9917.7, 53, .92, 11371.7, 52, 3.98, 17298.18, 52, 3.6, 10969.97, 49, 5.91, 3894.18, 49, 2.51, 6127.66, 48, 1.67, 12168, 46, .31, 801.82, 42, 3.7, 10575.41, 42, 4.05, 10984.19, 40, 2.17, 7860.42, 40, 4.17, 26.3, 38, 5.82, 7058.6, 37, 3.39, 6496.37, 36, 1.08, 6309.37, 36, 5.34, 7079.37, 34, 3.62, 11790.63, 32, .32, 16200.77, 31, 4.24, 3738.76, 29, 4.55, 11856.22, 29, 1.26, 8635.94, 27, 3.45, 5884.93, 26, 5.08, 10177.26, 26, 5.38, 21228.39, 24, 2.26, 11712.96, 24, 1.05, 242.73, 24, 5.59, 6069.78, 23, 3.63, 6284.06, 23, 1.64, 4732.03, 22, 3.46, 213.3, 21, 1.05, 3496.03, 21, 3.92, 13916.02, 21, 4.01, 5230.81, 20, 5.16, 12352.85, 20, .69, 1990.75, 19, 2.73, 6062.66, 19, 5.01, 11015.11, 18, 6.04, 6283.01, 18, 2.85, 7238.68, 18, 5.6, 6283.14, 18, 5.16, 17253.04, 18, 2.54, 14314.17, 17, 1.58, 7.11, 17, .98, 3930.21, 17, 4.75, 17267.27, 16, 2.19, 6076.89, 16, 2.19, 18073.7, 16, 6.12, 3.52, 16, 4.61, 9623.69, 16, 3.4, 16496.36, 15, .19, 9779.11, 15, 5.3, 13517.87, 15, 4.26, 3128.39, 15, .81, 709.93, 14, .5, 25158.6, 14, 4.38, 4136.91, 13, .98, 65147.62, 13, 3.31, 154717.61, 13, 2.11, 1589.07, 13, 1.92, 22483.85, 12, 6.03, 9225.54, 12, 1.53, 12559.04, 12, 5.82, 6282.1, 12, 5.61, 5642.2, 12, 2.38, 167283.76, 12, .39, 12132.44, 12, 3.98, 4686.89, 12, 5.81, 12569.67, 12, .56, 5849.36, 11, .45, 6172.87, 11, 5.8, 16858.48, 11, 6.22, 12146.67, 11, 2.27, 5429.88, 435939, 5.784551, 6283.07585, 12363, 5.57935, 12566.1517, 1234, 3.1416, 0, 879, 3.628, 77713.771, 569, 1.87, 5573.143, 330, 5.47, 18849.228, 147, 4.48, 5507.553, 110, 2.842, 161000.686, 101, 2.815, 5223.694, 85, 3.11, 1577.34, 65, 5.47, 775.52, 61, 1.38, 6438.5, 50, 4.42, 6286.6, 47, 3.66, 7084.9, 46, 5.39, 149854.4, 42, .9, 10977.08, 40, 3.2, 5088.63, 35, 1.81, 5486.78, 32, 5.35, 3154.69, 30, 3.52, 796.3, 29, 4.62, 4690.48, 28, 1.84, 4694, 27, 3.14, 71430.7, 27, 6.17, 6836.65, 26, 1.42, 2146.17, 25, 2.81, 1748.02, 24, 2.18, 155.42, 23, 4.76, 7234.79, 21, 3.38, 7632.94, 21, .22, 4705.73, 20, 4.22, 1349.87, 20, 2.01, 1194.45, 20, 4.58, 529.69, 19, 1.59, 6309.37, 18, 5.7, 6040.35, 18, 6.03, 4292.33, 17, 2.9, 9437.76, 17, 2, 8031.09, 17, 5.78, 83996.85, 16, .05, 2544.31, 15, .95, 6127.66, 14, .36, 10447.39, 14, 1.48, 2352.87, 13, .77, 553.57, 13, 5.48, 951.72, 13, 5.27, 6279.55, 13, 3.76, 6812.77, 11, 5.41, 6256.78, 10, .68, 1592.6, 10, 4.95, 398.15, 10, 1.15, 3894.18, 10, 5.2, 244287.6, 10, 1.94, 11856.22, 9, 5.39, 25132.3, 8, 6.18, 1059.38, 8, .69, 8429.24, 8, 5.85, 242.73, 7, 5.26, 14143.5, 7, .52, 801.82, 6, 2.24, 8635.94, 6, 4, 13367.97, 6, 2.77, 90955.55, 6, 5.17, 7058.6, 5, 1.46, 233141.31, 5, 4.13, 7860.42, 5, 3.91, 26.3, 5, 3.89, 12036.46, 5, 5.58, 6290.19, 5, 5.54, 1990.75, 5, .83, 11506.77, 5, 6.22, 6681.22, 4, 5.26, 10575.41, 4, 1.91, 7477.52, 4, .43, 10213.29, 4, 1.09, 709.93, 4, 5.09, 11015.11, 4, 4.22, 88860.06, 4, 3.57, 7079.37, 4, 1.98, 6284.06, 4, 3.93, 10973.56, 4, 6.18, 9917.7, 4, .36, 10177.26, 4, 2.75, 3738.76, 4, 3.33, 5643.18, 4, 5.36, 25158.6, 14459, 4.27319, 6283.07585, 673, 3.917, 12566.152, 77, 0, 0, 25, 3.73, 18849.23, 4, 2.8, 6286.6, 386, 2.564, 6283.076, 31, 2.27, 12566.15, 5, 3.44, 5573.14, 2, 2.05, 18849.23, 1, 2.06, 77713.77, 1, 4.41, 161000.69, 1, 3.82, 149854.4, 1, 4.08, 6127.66, 1, 5.26, 6438.5, 9, 1.22, 6283.08, 1, .66, 12566.15)), a = [[[22639.586, .78475822, 8328.691424623, 1.5229241, 25.0719, -0.123598, 4586.438, .1873974, 7214.06286536, -2.184756, -18.86, .0828, 2369.914, 2.542952, 15542.75428998, -0.661832, 6.212, -0.0408, 769.026, 3.140313, 16657.38284925, 3.04585, 50.144, -0.2472, 666.418, 1.527671, 628.30195521, -0.02664, .062, -0.0054, 411.596, 4.826607, 16866.932315, -1.28012, -1.07, -0.0059, 211.656, 4.115028, -1114.6285593, -3.70768, -43.93, .2064, 205.436, .230523, 6585.7609101, -2.15812, -18.92, .0882, 191.956, 4.898507, 23871.4457146, .86109, 31.28, -0.164, 164.729, 2.586078, 14914.4523348, -0.6352, 6.15, -0.035, 147.321, 5.4553, -7700.3894694, -1.5496, -25.01, .118, 124.988, .48608, 7771.377145, -0.3309, 3.11, -0.02, 109.38, 3.88323, 8956.9933798, 1.4963, 25.13, -0.129, 55.177, 5.57033, -1324.178025, .6183, 7.3, -0.035, 45.1, .89898, 25195.62374, .2428, 24, -0.129, 39.533, 3.81213, -8538.24089, 2.803, 26.1, -0.118, 38.43, 4.30115, 22756.817155, -2.8466, -12.6, .042, 36.124, 5.49587, 24986.074274, 4.5688, 75.2, -0.371, 30.773, 1.94559, 14428.125731, -4.3695, -37.7, .166, 28.397, 3.28586, 7842.364821, -2.2114, -18.8, .077, 24.358, 5.64142, 16171.056245, -0.6885, 6.3, -0.046, 18.585, 4.41371, -557.31428, -1.8538, -22, .1, 17.954, 3.58454, 8399.6791, -0.3576, 3.2, -0.03, 14.53, 4.9416, 23243.143759, .888, 31.2, -0.16, 14.38, .9709, 32200.137139, 2.384, 56.4, -0.29, 14.251, 5.7641, -2.3012, 1.523, 25.1, -0.12, 13.899, .3735, 31085.50858, -1.324, 12.4, -0.08, 13.194, 1.7595, -9443.319984, -5.231, -69, .33, 9.679, 3.0997, -16029.080894, -3.072, -50.1, .24, 9.366, .3016, 24080.99518, -3.465, -19.9, .08, 8.606, 4.1582, -1742.930514, -3.681, -44, .21, 8.453, 2.8416, 16100.06857, 1.192, 28.2, -0.14, 8.05, 2.6292, 14286.15038, -0.609, 6.1, -0.03, 7.63, 6.2388, 17285.684804, 3.019, 50.2, -0.25, 7.447, 1.4845, 1256.60391, -0.053, .1, -0.01, 7.371, .2736, 5957.458955, -2.131, -19, .09, 7.063, 5.6715, 33.757047, -0.308, -3.6, .02, 6.383, 4.7843, 7004.5134, 2.141, 32.4, -0.16, 5.742, 2.6572, 32409.686605, -1.942, 5, -0.05, 4.374, 4.3443, 22128.5152, -2.82, -13, .05, 3.998, 3.2545, 33524.31516, 1.766, 49, -0.25, 3.21, 2.2443, 14985.44001, -2.516, -16, .06, 2.915, 1.7138, 24499.74767, .834, 31, -0.17, 2.732, 1.9887, 13799.82378, -4.343, -38, .17, 2.568, 5.4122, -7072.08751, -1.576, -25, .11, 2.521, 3.2427, 8470.66678, -2.238, -19, .07, 2.489, 4.0719, -486.3266, -3.734, -44, .2, 2.146, 5.6135, -1952.47998, .645, 7, -0.03, 1.978, 2.7291, 39414.2, .199, 37, -0.21, 1.934, 1.5682, 33314.7657, 6.092, 100, -0.5, 1.871, .4166, 30457.20662, -1.297, 12, -0.1, 1.753, 2.0582, -8886.0057, -3.38, -47, .2, 1.437, 2.386, -695.87607, .59, 7, 0, 1.373, 3.026, -209.54947, 4.33, 51, -0.2, 1.262, 5.94, 16728.37052, 1.17, 28, -0.1, 1.224, 6.172, 6656.74859, -4.04, -41, .2, 1.187, 5.873, 6099.43431, -5.89, -63, .3, 1.177, 1.014, 31571.83518, 2.41, 56, -0.3, 1.162, 3.84, 9585.29534, 1.47, 25, -0.1, 1.143, 5.639, 8364.73984, -2.18, -19, .1, 1.078, 1.229, 70.98768, -1.88, -22, .1, 1.059, 3.326, 40528.82856, 3.91, 81, -0.4, .99, 5.013, 40738.37803, -0.42, 30, -0.2, .948, 5.687, -17772.01141, -6.75, -94, .5, .876, .298, -0.35232, 0, 0, 0, .822, 2.994, 393.02097, 0, 0, 0, .788, 1.836, 8326.39022, 3.05, 50, -0.2, .752, 4.985, 22614.8418, .91, 31, -0.2, .74, 2.875, 8330.99262, 0, 0, 0, .669, .744, -24357.77232, -4.6, -75, .4, .644, 1.314, 8393.12577, -2.18, -19, .1, .639, 5.888, 575.33849, 0, 0, 0, .635, 1.116, 23385.11911, -2.87, -13, 0, .584, 5.197, 24428.75999, 2.71, 53, -0.3, .583, 3.513, -9095.55517, .95, 4, 0, .572, 6.059, 29970.88002, -5.03, -32, .1, .565, 2.96, .32863, 1.52, 25, -0.1, .561, 4.001, -17981.56087, -2.43, -43, .2, .557, .529, 7143.07519, -0.3, 3, 0, .546, 2.311, 25614.37623, 4.54, 75, -0.4, .536, 4.229, 15752.30376, -4.99, -45, .2, .493, 3.316, -8294.9344, -1.83, -29, .1, .491, 1.744, 8362.4485, 1.21, 21, -0.1, .478, 1.803, -10071.6219, -5.2, -69, .3, .454, .857, 15333.2048, 3.66, 57, -0.3, .445, 2.071, 8311.7707, -2.18, -19, .1, .426, .345, 23452.6932, -3.44, -20, .1, .42, 4.941, 33733.8646, -2.56, -2, 0, .413, 1.642, 17495.2343, -1.31, -1, 0, .404, 1.458, 23314.1314, -0.99, 9, -0.1, .395, 2.132, 38299.5714, -3.51, -6, 0, .382, 2.7, 31781.3846, -1.92, 5, 0, .375, 4.827, 6376.2114, 2.17, 32, -0.2, .361, 3.867, 16833.1753, -0.97, 3, 0, .358, 5.044, 15056.4277, -4.4, -38, .2, .35, 5.157, -8257.7037, -3.4, -47, .2, .344, 4.233, 157.7344, 0, 0, 0, .34, 2.672, 13657.8484, -0.58, 6, 0, .329, 5.61, 41853.0066, 3.29, 74, -0.4, .325, 5.895, -39.8149, 0, 0, 0, .309, 4.387, 21500.2132, -2.79, -13, .1, .302, 1.278, 786.0419, 0, 0, 0, .302, 5.341, -24567.3218, -0.27, -24, .1, .301, 1.045, 5889.8848, -1.57, -12, 0, .294, 4.201, -2371.2325, -3.65, -44, .2, .293, 3.704, 21642.1886, -6.55, -57, .2, .29, 4.069, 32828.4391, 2.36, 56, -0.3, .289, 3.472, 31713.8105, -1.35, 12, -0.1, .285, 5.407, -33.7814, .31, 4, 0, .283, 5.998, -16.9207, -3.71, -44, .2, .283, 2.772, 38785.898, .23, 37, -0.2, .274, 5.343, 15613.742, -2.54, -16, .1, .263, 3.997, 25823.9257, .22, 24, -0.1, .254, .6, 24638.3095, -1.61, 2, 0, .253, 1.344, 6447.1991, .29, 10, -0.1, .25, .887, 141.9754, -3.76, -44, .2, .247, .317, 5329.157, -2.1, -19, .1, .245, .141, 36.0484, -3.71, -44, .2, .231, 2.287, 14357.1381, -2.49, -16, .1, .227, 5.158, 2.6298, 0, 0, 0, .219, 5.085, 47742.8914, 1.72, 63, -0.3, .211, 2.145, 6638.7244, -2.18, -19, .1, .201, 4.415, 39623.7495, -4.13, -14, 0, .194, 2.091, 588.4927, 0, 0, 0, .193, 3.057, -15400.7789, -3.1, -50, 0, .186, 5.598, 16799.3582, -0.72, 6, 0, .185, 3.886, 1150.677, 0, 0, 0, .183, 1.619, 7178.0144, 1.52, 25, 0, .181, 2.635, 8328.3391, 1.52, 25, 0, .181, 2.077, 8329.0437, 1.52, 25, 0, .179, 3.215, -9652.8694, -0.9, -18, 0, .176, 1.716, -8815.018, -5.26, -69, 0, .175, 5.673, 550.7553, 0, 0, 0, .17, 2.06, 31295.058, -5.6, -39, 0, .167, 1.239, 7211.7617, -0.7, 6, 0, .165, 4.499, 14967.4158, -0.7, 6, 0, .164, 3.595, 15540.4531, .9, 31, 0, .164, 4.237, 522.3694, 0, 0, 0, .163, 4.633, 15545.0555, -2.2, -19, 0, .161, .478, 6428.0209, -2.2, -19, 0, .158, 2.03, 13171.5218, -4.3, -38, 0, .157, 2.28, 7216.3641, -3.7, -44, 0, .154, 5.65, 7935.6705, 1.5, 25, 0, .152, .46, 29828.9047, -1.3, 12, 0, .151, 1.19, -0.7113, 0, 0, 0, .15, 1.42, 23942.4334, -1, 9, 0, .144, 2.75, 7753.3529, 1.5, 25, 0, .137, 2.08, 7213.7105, -2.2, -19, 0, .137, 1.44, 7214.4152, -2.2, -19, 0, .136, 4.46, -1185.6162, -1.8, -22, 0, .136, 3.03, 8000.1048, -2.2, -19, 0, .134, 2.83, 14756.7124, -0.7, 6, 0, .131, 5.05, 6821.0419, -2.2, -19, 0, .128, 5.99, -17214.6971, -4.9, -72, 0, .127, 5.35, 8721.7124, 1.5, 25, 0, .126, 4.49, 46628.2629, -2, 19, 0, .125, 5.94, 7149.6285, 1.5, 25, 0, .124, 1.09, 49067.0695, 1.1, 55, 0, .121, 2.88, 15471.7666, 1.2, 28, 0, .111, 3.92, 41643.4571, 7.6, 125, -1, .11, 1.96, 8904.0299, 1.5, 25, 0, .106, 3.3, -18.0489, -2.2, -19, 0, .105, 2.3, -4.931, 1.5, 25, 0, .104, 2.22, -6.559, -1.9, -22, 0, .101, 1.44, 1884.9059, -0.1, 0, 0, .1, 5.92, 5471.1324, -5.9, -63, 0, .099, 1.12, 15149.7333, -0.7, 6, 0, .096, 4.73, 15508.9972, -0.4, 10, 0, .095, 5.18, 7230.9835, 1.5, 25, 0, .093, 3.37, 39900.5266
        , 3.9, 81, 0, .092, 2.01, 25057.0619, 2.7, 53, 0, .092, 1.21, -79.6298, 0, 0, 0, .092, 1.65, -26310.2523, -4, -68, 0, .091, 1.01, 42062.5561, -1, 23, 0, .09, 6.1, 29342.5781, -5, -32, 0, .09, 4.43, 15542.402, -0.7, 6, 0, .09, 3.8, 15543.1066, -0.7, 6, 0, .089, 4.15, 6063.3859, -2.2, -19, 0, .086, 4.03, 52.9691, 0, 0, 0, .085, .49, 47952.4409, -2.6, 11, 0, .085, 1.6, 7632.8154, 2.1, 32, 0, .084, .22, 14392.0773, -0.7, 6, 0, .083, 6.22, 6028.4466, -4, -41, 0, .083, .63, -7909.9389, 2.8, 26, 0, .083, 5.2, -77.5523, 0, 0, 0, .082, 2.74, 8786.1467, -2.2, -19, 0, .08, 2.43, 9166.5428, -2.8, -26, 0, .08, 3.7, -25405.1732, 4.1, 27, 0, .078, 5.68, 48857.52, 5.4, 106, -1, .077, 1.85, 8315.5735, -2.2, -19, 0, .075, 5.46, -18191.1103, 1.9, 8, 0, .075, 1.41, -16238.6304, 1.3, 1, 0, .074, 5.06, 40110.0761, -0.4, 30, 0, .072, 2.1, 64.4343, -3.7, -44, 0, .071, 2.17, 37671.2695, -3.5, -6, 0, .069, 1.71, 16693.4313, -0.7, 6, 0, .069, 3.33, -26100.7028, -8.3, -119, 1, .068, 1.09, 8329.4028, 1.5, 25, 0, .068, 3.62, 8327.9801, 1.5, 25, 0, .068, 2.41, 16833.1509, -1, 3, 0, .067, 3.4, 24709.2971, -3.5, -20, 0, .067, 1.65, 8346.7156, -0.3, 3, 0, .066, 2.61, 22547.2677, 1.5, 39, 0, .066, 3.5, 15576.5113, -1, 3, 0, .065, 5.76, 33037.9886, -2, 5, 0, .065, 4.58, 8322.1325, -0.3, 3, 0, .065, 6.2, 17913.9868, 3, 50, 0, .065, 1.5, 22685.8295, -1, 9, 0, .065, 2.37, 7180.3058, -1.9, -15, 0, .064, 1.06, 30943.5332, 2.4, 56, 0, .064, 1.89, 8288.8765, 1.5, 25, 0, .064, 4.7, 6.0335, .3, 4, 0, .063, 2.83, 8368.5063, 1.5, 25, 0, .063, 5.66, -2580.7819, .7, 7, 0, .062, 3.78, 7056.3285, -2.2, -19, 0, .061, 1.49, 8294.91, 1.8, 29, 0, .061, .12, -10281.1714, -0.9, -18, 0, .061, 3.06, -8362.4729, -1.2, -21, 0, .061, 4.43, 8170.9571, 1.5, 25, 0, .059, 5.78, -13.1179, -3.7, -44, 0, .059, 5.97, 6625.5702, -2.2, -19, 0, .058, 5.01, -0.508, -0.3, 0, 0, .058, 2.73, 7161.0938, -2.2, -19, 0, .057, .19, 7214.0629, -2.2, -19, 0, .057, 4, 22199.5029, -4.7, -35, 0, .057, 5.38, 8119.142, 5.8, 76, 0, .056, 1.07, 7542.6495, 1.5, 25, 0, .056, .28, 8486.4258, 1.5, 25, 0, .054, 4.19, 16655.0816, 4.6, 75, 0, .053, .72, 7267.032, -2.2, -19, 0, .053, 3.12, 12.6192, .6, 7, 0, .052, 2.99, -32896.013, -1.8, -49, 0, .052, 3.46, 1097.708, 0, 0, 0, .051, 5.37, -6443.786, -1.6, -25, 0, .051, 1.35, 7789.401, -2.2, -19, 0, .051, 5.83, 40042.502, .2, 38, 0, .051, 3.63, 9114.733, 1.5, 25, 0, .05, 1.51, 8504.484, -2.5, -22, 0, .05, 5.23, 16659.684, 1.5, 25, 0, .05, 1.15, 7247.82, -2.5, -23, 0, .047, .25, -1290.421, .3, 0, 0, .047, 4.67, -32686.464, -6.1, -100, 0, .047, 3.49, 548.678, 0, 0, 0, .047, 2.37, 6663.308, -2.2, -19, 0, .046, .98, 1572.084, 0, 0, 0, .046, 2.04, 14954.262, -0.7, 6, 0, .046, 3.72, 6691.693, -2.2, -19, 0, .045, 6.19, -235.287, 0, 0, 0, .044, 2.96, 32967.001, -0.1, 27, 0, .044, 3.82, -1671.943, -5.6, -66, 0, .043, 5.82, 1179.063, 0, 0, 0, .043, .07, 34152.617, 1.7, 49, 0, .043, 3.71, 6514.773, -0.3, 0, 0, .043, 5.62, 15.732, -2.5, -23, 0, .043, 5.8, 8351.233, -2.2, -19, 0, .042, .27, 7740.199, 1.5, 25, 0, .042, 6.14, 15385.02, -0.7, 6, 0, .042, 6.13, 7285.051, -4.1, -41, 0, .041, 1.27, 32757.451, 4.2, 78, 0, .041, 4.46, 8275.722, 1.5, 25, 0, .04, .23, 8381.661, 1.5, 25, 0, .04, 5.87, -766.864, 2.5, 29, 0, .04, 1.66, 254.431, 0, 0, 0, .04, .4, 9027.981, -0.4, 0, 0, .04, 2.96, 7777.936, 1.5, 25, 0, .039, 4.67, 33943.068, 6.1, 100, 0, .039, 3.52, 8326.062, 1.5, 25, 0, .039, 3.75, 21013.887, -6.5, -57, 0, .039, 5.6, 606.978, 0, 0, 0, .039, 1.19, 8331.321, 1.5, 25, 0, .039, 2.84, 7211.433, -2.2, -19, 0, .038, .67, 7216.693, -2.2, -19, 0, .038, 6.22, 25161.867, .6, 28, 0, .038, 4.4, 7806.322, 1.5, 25, 0, .038, 4.16, 9179.168, -2.2, -19, 0, .037, 4.73, 14991.999, -0.7, 6, 0, .036, .35, 67.514, -0.6, -7, 0, .036, 3.7, 25266.611, -1.6, 0, 0, .036, 5.39, 16328.796, -0.7, 6, 0, .035, 1.44, 7174.248, -2.2, -19, 0, .035, 5, 15684.73, -4.4, -38, 0, .035, .39, -15.419, -2.2, -19, 0, .035, 6.07, 15020.385, -0.7, 6, 0, .034, 6.01, 7371.797, -2.2, -19, 0, .034, .96, -16623.626, -3.4, -54, 0, .033, 6.24, 9479.368, 1.5, 25, 0, .033, 3.21, 23661.896, 5.2, 82, 0, .033, 4.06, 8311.418, -2.2, -19, 0, .033, 2.4, 1965.105, 0, 0, 0, .033, 5.17, 15489.785, -0.7, 6, 0, .033, 5.03, 21986.54, .9, 31, 0, .033, 4.1, 16691.14, 2.7, 46, 0, .033, 5.13, 47114.589, 1.7, 63, 0, .033, 4.45, 8917.184, 1.5, 25, 0, .033, 4.23, 2.078, 0, 0, 0, .032, 2.33, 75.251, 1.5, 25, 0, .032, 2.1, 7253.878, -2.2, -19, 0, .032, 3.11, -0.224, 1.5, 25, 0, .032, 4.43, 16640.462, -0.7, 6, 0, .032, 5.68, 8328.363, 0, 0, 0, .031, 5.32, 8329.02, 3, 50, 0, .031, 3.7, 16118.093, -0.7, 6, 0, .03, 3.67, 16721.817, -0.7, 6, 0, .03, 5.27, -1881.492, -1.2, -15, 0, .03, 5.72, 8157.839, -2.2, -19, 0, .029, 5.73, -18400.313, -6.7, -94, 0, .029, 2.76, 16, -2.2, -19, 0, .029, 1.75, 8879.447, 1.5, 25, 0, .029, .32, 8851.061, 1.5, 25, 0, .029, .9, 14704.903, 3.7, 57, 0, .028, 2.9, 15595.723, -0.7, 6, 0, .028, 5.88, 16864.631, .2, 24, 0, .028, .63, 16869.234, -2.8, -26, 0, .028, 4.04, -18609.863, -2.4, -43, 0, .027, 5.83, 6727.736, -5.9, -63, 0, .027, 6.12, 418.752, 4.3, 51, 0, .027, .14, 41157.131, 3.9, 81, 0, .026, 3.8, 15.542, 0, 0, 0, .026, 1.68, 50181.698, 4.8, 99, -1, .026, .32, 315.469, 0, 0, 0, .025, 5.67, 19.188, .3, 0, 0, .025, 3.16, 62.133, -2.2, -19, 0, .025, 3.76, 15502.939, -0.7, 6, 0, .025, 4.53, 45999.961, -2, 19, 0, .024, 3.21, 837.851, -4.4, -51, 0, .024, 2.82, 38157.596, .3, 37, 0, .024, 5.21, 15540.124, -0.7, 6, 0, .024, .26, 14218.576, 0, 13, 0, .024, 3.01, 15545.384, -0.7, 6, 0, .024, 1.16, -17424.247, -0.6, -21, 0, .023, 2.34, -67.574, .6, 7, 0, .023, 2.44, 18.024, -1.9, -22, 0, .023, 3.7, 469.4, 0, 0, 0, .023, .72, 7136.511, -2.2, -19, 0, .023, 4.5, 15582.569, -0.7, 6, 0, .023, 2.8, -16586.395, -4.9, -72, 0, .023, 1.51, 80.182, 0, 0, 0, .023, 1.09, 5261.583, -1.5, -12, 0, .023, .56, 54956.954, -0.5, 44, 0, .023, 4.01, 8550.86, -2.2, -19, 0, .023, 4.46, 38995.448, -4.1, -14, 0, .023, 3.82, 2358.126, 0, 0, 0, .022, 3.77, 32271.125, .5, 34, 0, .022, .82, 15935.775, -0.7, 6, 0, .022, 1.07, 24013.421, -2.9, -13, 0, .022, .4, 8940.078, -2.2, -19, 0, .022, 2.06, 15700.489, -0.7, 6, 0, .022, 4.27, 15124.002, -5, -45, 0, .021, 1.16, 56071.583, 3.2, 88, 0, .021, 5.58, 9572.189, -2.2, -19, 0, .02, 1.7, -17.273, -3.7, -44, 0, .02, 3.05, 214.617, 0, 0, 0, .02, 4.41, 8391.048, -2.2, -19, 0, .02, 5.95, 23869.145, 2.4, 56, 0, .02, .42, 40947.927, -4.7, -21, 0, .019, 1.39, 5818.897, .3, 10, 0, .019, .71, 23873.747, -0.7, 6, 0, .019, 2.81, 7291.615, -2.2, -19, 0, .019, 5.09, 8428.018, -2.2, -19, 0, .019, 4.14, 6518.187, -1.6, -12, 0, .019, 3.85, 21.33, 0, 0, 0, .018, .66, 14445.046, -0.7, 6, 0, .018, 1.65, .966, -4, -48, 0, .018, 5.64, -17143.709, -6.8, -94, 0, .018, 6.01, 7736.432, -2.2, -19, 0, .018, 2.74, 31153.083, -1.9, 5, 0, .018, 4.58, 6116.355, -2.2, -19, 0, .018, 2.28, 46.401, .3, 0, 0, .018, 3.8, 10213.597, 1.4, 25, 0, .018, 2.84, 56281.132, -1.1, 36, 0, .018, 3.53, 8249.062, 1.5, 25, 0, .017, 4.43, 20871.911, -3, -13, 0, .017, 4.44, 627.596, 0, 0, 0, .017, 1.85, 628.308, 0, 0, 0, .017, 1.19, 8408.321, 2, 25, 0, .017, 1.95, 7214.056, -2, -19, 0, .017, 1.57, 7214.07, -2, -19, 0, .017, 1.65, 13870.811, -6, -60, 0, .017, .3, 22.542, -4, -44, 0, .017, 2.62, -119.445, 0, 0, 0, .016, 4.87, 5747.909, 2, 32, 0, .016, 4.45, 14339.108, -1, 6, 0, .016, 1.83, 41366.68, 0, 30, 0, .016, 4.53, 16309.618, -3, -23, 0, .016, 2.54, 15542.754, -1, 6, 0, .016, 6.05, 1203.646, 0, 0, 0, .015, 5.2, 2751.147, 0, 0, 0, .015, 1.8, -10699.924, -5, -69, 0, .015, .4, 22824.391, -3, -20, 0, .015, 2.1, 30666.756, -6, -39, 0, .015, 2.1, 6010.417, -2, -19, 0, .015, .7, -23729.47, -5, -75, 0, .015, 1.4, 14363.691, -1, 6, 0, .015, 5.8, 16900.689, -2, 0, 0, .015, 5.2, 23800.458, 3, 53, 0, .015, 5.3, 6035, -2, -19, 0, .015, 1.2, 8251.139, 2, 25, 0, .015, 3.6, -8.86, 0, 0, 0, .015, .8, 882.739, 0, 0, 0, .015, 3, 1021.329, 0, 0, 0, .015, .6, 23296.107, 1, 31, 0, .014, 5.4, 7227.181, 2, 25, 0, .014, .1, 7213.352, -2, -19, 0, .014, 4, 15506.706, 3, 50, 0, .014, 3.4, 7214.774, -2, -19, 0, .014, 4.6, 6665.385, -2, -19, 0, .014, .1, -8.636, -2, -22, 0, .014, 3.1, 15465.202, -1, 6, 0, .014, 4.9, 508.863, 0, 0, 0, .014, 3.5, 8406.244, 2, 25, 0, .014, 1.3, 13313.497, -8, -82, 0, .014, 2.8, 49276.619, -3, 0, 0, .014, .1, 30528.194, -3, -10, 0, .013, 1.7, 25128.05, 1, 31, 0, .013, 2.9, 14128.405, -1, 6, 0, .013, 3.4, 57395.761, 3, 80, 0, .013, 2.7, 13029.546, -1, 6, 0, .013, 3.9, 7802.556, -2, -19, 0, .013, 1.6, 8258.802, -2, -19, 0, .013, 2.2, 8417.709, -2, -19, 0, .013, .7, 9965.21, -2, -19, 0, .013, 3.4, 50391.247, 0, 48, 0, .013, 3, 7134.433, -2, -19, 0, .013, 2.9, 30599.182, -5, -31, 0, .013, 3.6, -9723.857, 1, 0, 0, .013, 4.8, 7607.084, -2, -19, 0, .012, .8, 23837.689, 1, 35, 0, .012, 3.6, 4.409, -4, -44, 0, .012, 5, 16657.031, 3, 50, 0, .012, 4.4, 16657.735, 3, 50, 0, .012, 1.1, 15578.803, -4, -38, 0, .012, 6, -11.49, 0, 0, 0, .012, 1.9, 8164.398, 0, 0, 0, .012, 2.4, 31852.372, -4, -17, 0, .012, 2.4, 6607.085, -2, -19, 0, .012, 4.2, 8359.87, 0, 0, 0, .012, .5, 5799.713, -2, -19, 0, .012, 2.7, 7220.622, 0, 0, 0, .012, 4.3, -139.72, 0, 0, 0, .012, 2.3, 13728.836, -2, -16, 0, .011, 3.6, 14912.146, 1, 31, 0, .011, 4.7, 14916.748, -2, -19, 0], [1.6768, 4.66926, 628.301955, -0.0266, .1, -0.005, .51642, 3.3721, 6585.76091, -2.158, -18.9, .09, .41383, 5.7277, 14914.452335, -0.635, 6.2, -0.04, .37115, 3.9695, 7700.389469, 1.55, 25, -0.12, .2756, .7416, 8956.99338, 1.496, 25.1, -0.13, .24599, 4.2253, -2.3012, 1.523, 25.1, -0.12, .07118, .1443, 7842.36482, -2.211, -19, .08, .06128, 2.4998, 16171.05625, -0.688, 6, 0, .04516, .443, 8399.6791, -0.36, 3, 0, .04048, 5.771, 14286.15038, -0.61, 6, 0, .03747, 4.626, 1256.60391, -0.05, 0, 0, .03707, 3.415, 5957.45895, -2.13, -19, .1, .03649, 1.8, 23243.14376, .89, 31, -0.2, .02438, .042, 16029.08089, 3.07, 50, -0.2, .02165, 1.017, -1742.93051, -3.68, -44, .2, .01923, 3.097, 17285.6848, 3.02, 50, -0.3, .01692, 1.28, .3286, 1.52, 25, -0.1, .01361, .298, 8326.3902, 3.05, 50, -0.2, .01293, 4.013, 7072.0875, 1.58, 25, -0.1, .01276, 4.413, 8330.9926, 0, 0, 0, .0127, .101, 8470.6668, -2.24, -19, .1, .01097, 1.203, 22128.5152, -2.82, -13, 0, .01088, 2.545, 15542.7543, -0.66, 6, 0, .00835, .19, 7214.0629, -2.18, -19, .1, .00734, 4.855, 24499.7477, .83, 31, -0.2, .00686, 5.13, 13799.8238, -4.34, -38, .2, .00631, .93, -486.3266, -3.73, -44, 0, .00585, .699, 9585.2953, 1.5, 25, 0, .00566, 4.073, 8328.3391, 1.5, 25, 0, .00566, .638, 8329.0437, 1.5, 25, 0, .00539, 2.472, -1952.48, .6, 7, 0, .00509, 2.88, -0.7113, 0, 0, 0, .00469, 3.56, 30457.2066, -1.3, 12, 0, .00387, .78, -0.3523, 0, 0, 0, .00378, 1.84, 22614.8418, .9, 31, 0, .00362, 5.53, -695.8761, .6, 7, 0, .00317, 2.8, 16728.3705, 1.2, 28, 0, .00303, 6.07, 157.7344, 0, 0, 0, .003, 2.53, 33.757, -0.3, -4, 0, .00295, 4.16, 31571.8352, 2.4, 56, 0, .00289, 5.98, 7211.7617, -0.7, 6, 0, .00285, 2.06, 15540.4531, .9, 31, 0, .00283, 2.65, 2.6298, 0, 0, 0, .00282, 6.17, 15545.0555, -2.2, -19, 0, .00278, 1.23, -39.8149, 0, 0, 0, .00272, 3.82, 7216.3641, -3.7, -44, 0, .0027, 4.37, 70.9877, -1.9, -22, 0, .00256, 5.81, 13657.8484, -0.6, 6, 0, .00244, 5.64, -0.2237, 1.5, 25, 0, .0024, 2.96, 8311.7707, -2.2, -19, 0, .00239, .87, -33.7814, .3, 4, 0, .00216, 2.31, 15.9995, -2.2, -19, 0, .00186, 3.46, 5329.157, -2.1, -19, 0, .00169, 2.4, 24357.772, 4.6, 75, 0, .00161, 5.8, 8329.403, 1.5, 25, 0, .00161, 5.2, 8327.98, 1.5, 25, 0, .0016, 4.26, 23385.119, -2.9, -13, 0, .00156, 1.26, 550.755, 0, 0, 0, .00155, 1.25, 21500.213, -2.8, -13, 0, .00152, .6, -16.921, -3.7, -44, 0, .0015, 2.71, -79.63, 0, 0, 0, .0015, 5.29, 15.542, 0, 0, 0, .00148, 1.06, -2371.232, -3.7, -44, 0, .00141, .77, 8328.691, 1.5, 25, 0, .00141, 3.67, 7143.075, -0.3, 0, 0, .00138, 5.45, 25614.376, 4.5, 75, 0, .00129, 4.9, 23871.446, .9, 31, 0, .00126, 4.03, 141.975, -3.8, -44, 0, .00124, 6.01, 522.369, 0, 0, 0, .0012, 4.94, -10071.622, -5.2, -69, 0, .00118, 5.07, -15.419, -2.2, -19, 0, .00107, 3.49, 23452.693, -3.4, -20, 0, .00104, 4.78, 17495.234, -1.3, 0, 0, .00103, 1.44, -18.049, -2.2, -19, 0, .00102, 5.63, 15542.402, -0.7, 6, 0, .00102, 2.59, 15543.107, -0.7, 6, 0, .001, 4.11, -6.559, -1.9, -22, 0, 97e-5, .08, 15400.779, 3.1, 50, 0, 96e-5, 5.84, 31781.385, -1.9, 5, 0, 94e-5, 1.08, 8328.363, 0, 0, 0, 94e-5, 2.46, 16799.358, -0.7, 6, 0, 94e-5, 1.69, 6376.211, 2.2, 32, 0, 93e-5, 3.64, 8329.02, 3, 50, 0, 93e-5, 2.65, 16655.082, 4.6, 75, 0, 9e-4, 1.9, 15056.428, -4.4, -38, 0, 89e-5, 1.59, 52.969, 0, 0, 0, 88e-5, 2.02, -8257.704, -3.4, -47, 0, 88e-5, 3.02, 7213.711, -2.2, -19, 0, 87e-5, .5, 7214.415, -2.2, -19, 0, 87e-5, .49, 16659.684, 1.5, 25, 0, 82e-5, 5.64, -4.931, 1.5, 25, 0, 79e-5, 5.17, 13171.522, -4.3, -38, 0, 76e-5, 3.6, 29828.905, -1.3, 12, 0, 76e-5, 4.08, 24567.322, .3, 24, 0, 76e-5, 4.58, 1884.906, -0.1, 0, 0, 73e-5, .33, 31713.811, -1.4, 12, 0, 73e-5, .93, 32828.439, 2.4, 56, 0, 71e-5, 5.91, 38785.898, .2, 37, 0, 69e-5, 2.2, 15613.742, -2.5, -16, 0, 66e-5, 3.87, 15.732, -2.5, -23, 0, 66e-5, .86, 25823.926, .2, 24, 0, 65e-5, 2.52, 8170.957, 1.5, 25, 0, 63e-5, .18, 8322.132, -0.3, 0, 0, 6e-4, 5.84, 8326.062, 1.5, 25, 0, 6e-4, 5.15, 8331.321, 1.5, 25, 0, 6e-4, 2.18, 8486.426, 1.5, 25, 0, 58e-5, 2.3, -1.731, -4, -44, 0, 58e-5, 5.43, 14357.138, -2, -16, 0, 57e-5, 3.09, 8294.91, 2, 29, 0, 57e-5, 4.67, -8362.473, -1, -21, 0, 56e-5, 4.15, 16833.151, -1, 0, 0, 54e-5, 1.93, 7056.329, -2, -19, 0, 54e-5, 5.27, 8315.574, -2, -19, 0, 52e-5, 5.6, 8311.418, -2, -19, 0, 52e-5, 2.7, -77.552, 0, 0, 0, 51e-5, 4.3, 7230.984, 2, 25, 0, 5e-4, .4, -0.508, 0, 0, 0, 49e-5, 5.4, 7211.433, -2, -19, 0, 49e-5, 4.4, 7216.693, -2, -19, 0, 49e-5, 4.3, 16864.631, 0, 24, 0, 49e-5, 2.2, 16869.234, -3, -26, 0, 47e-5, 6.1, 627.596, 0, 0, 0, 47e-5, 5, 12.619, 1, 7, 0, 45e-5, 4.9, -8815.018, -5, -69, 0, 44e-5, 1.6, 62.133, -2, -19, 0, 42e-5, 2.9, -13.118, -4, -44, 0, 42e-5, 4.1, -119.445, 0, 0, 0, 41e-5, 4.3, 22756.817, -3, -13, 0, 41e-5, 3.6, 8288.877, 2, 25, 0, 4e-4, .5, 6663.308, -2, -19, 0, 4e-4, 1.1, 8368.506, 2, 25, 0, 39e-5, 4.1, 6443.786, 2, 25, 0, 39e-5, 3.1, 16657.383, 3, 50, 0, 38e-5, .1, 16657.031, 3, 50, 0, 38e-5, 3, 16657.735, 3, 50, 0, 38e-5, 4.6, 23942.433, -1, 9, 0, 37e-5, 4.3, 15385.02, -1, 6, 0, 37e-5, 5, 548.678, 0, 0, 0, 36e-5, 1.8, 7213.352, -2, -19, 0, 36e-5, 1.7, 7214.774, -2, -19, 0, 35e-5, 1.1, 7777.936, 2, 25, 0, 35e-5, 1.6, -8.86, 0, 0, 0, 35e-5, 4.4, 23869.145, 2, 56, 0, 35e-5, 2, 6691.693, -2, -19, 0, 34e-5, 1.3, -1185.616, -2, -22, 0, 34e-5, 2.2, 23873.747, -1, 6, 0, 33e-5, 2, -235.287, 0, 0, 0, 33e-5, 3.1, 17913.987, 3, 50, 0, 33e-5, 1, 8351.233, -2, -19, 0], [.00487, 4.6693, 628.30196, -0.027, 0, -0.01, .00228, 2.6746, -2.3012, 1.523, 25, -0.12, .0015, 3.372, 6585.76091, -2.16, -19, .1, .0012, 5.728, 14914.45233, -0.64, 6, 0, .00108, 3.969, 7700.38947, 1.55, 25, -0.1, 8e-4, .742, 8956.99338, 1.5, 25, -0.1, 254e-6, 6.002, .3286, 1.52, 25, -0.1, 21e-5, .144, 7842.3648, -2.21, -19, 0, 18e-5, 2.5, 16171.0562, -0.7, 6, 0, 13e-5, .44, 8399.6791, -0.4, 3, 0, 126e-6, 5.03, 8326.3902, 3, 50, 0, 12e-5, 5.77, 14286.1504, -0.6, 6, 0, 118e-6, 5.96, 8330.9926, 0, 0, 0, 11e-5, 1.8, 23243.1438, .9, 31, 0, 11e-5, 3.42, 5957.459, -2.1, -19, 0, 11e-5, 4.63, 1256.6039, -0.1, 0, 0, 99e-6, 4.7, -0.7113, 0, 0, 0, 7e-5, .04, 16029.0809, 3.1, 50, 0, 7e-5, 5.14, 8328.3391, 1.5, 25, 0, 7e-5, 5.85, 8329.0437, 1.5, 25, 0, 6e-5, 1.02, -1742.9305, -3.7, -44, 0, 6e-5, 3.1, 17285.6848, 3, 50, 0, 54e-6, 5.69, -0.352, 0, 0, 0, 43e-6, .52, 15.542, 0, 0, 0, 41e-6, 2.03, 2.63, 0, 0, 0, 4e-5, .1, 8470.667, -2.2, -19, 0, 4e-5, 4.01, 7072.088, 1.6, 25, 0, 36e-6, 2.93, -8.86, -0.3, 0, 0, 3e-5, 1.2, 22128.515, -2.8, -13, 0, 3e-5, 2.54, 15542.754, -0.7, 6, 0, 27e-6, 4.43, 7211.762, -0.7, 6, 0, 26e-6, .51, 15540.453, .9, 31, 0, 26e-6, 1.44, 15545.055, -2.2, -19, 0, 25e-6, 5.37, 7216.364, -3.7, -44, 0], [12e-6, 1.041, -2.3012, 1.52, 25, -0.1, 17e-7, .31, -0.711, 0, 0, 0]]], f = 648e3 / Math.PI, l = new Array(-4e3, 108371.7, -13036.8, 392, 0, -500, 17201, -627.82, 16.17, -0.3413, -150, 12200.6, -346.41, 5.403, -0.1593, 150, 9113.8, -328.13, -1.647, .0377, 500, 5707.5, -391.41, .915, .3145, 900, 2203.4, -283.45, 13.034, -0.1778, 1300, 490.1, -57.35, 2.085, -0.0072, 1600, 120, -9.81, -1.532, .1403, 1700, 10.2, -0.91, .51, -0.037, 1800, 13.4, -0.72, .202, -0.0193, 1830, 7.8, -1.81, .416, -0.0247, 1860, 8.3, -0.13, -0.406, .0292, 1880, -5.4, .32, -0.183, .0173, 1900, -2.3, 2.06, .169, -0.0135, 1920, 21.2, 1.69, -0.304, .0167, 1940, 24.2, 1.22, -0.064, .0031, 1960, 33.2, .51, .231, -0.0109, 1980, 51, 1.29, -0.026, .0032, 2e3, 63.87, .1, 0, 0, 2005, 64.7, .4, 0, 0, 2015, 69), c = new Array(2.1824, -33.75705, 36e-6, -1720, 920, 3.5069, 1256.66393, 11e-6, -132, 57, 1.3375, 16799.4182, -0.000051, -23, 10, 4.3649, -67.5141, 72e-6, 21, -9, .04, -628.302, 0, -14, 0, 2.36, 8328.691, 0, 7, 0, 3.46, 1884.966, 0, -5, 2, 5.44, 16833.175, 0, -4, 2, 3.69, 25128.11, 0, -3, 0, 3.55, 628.362, 0, 2, 0), w = {
        E_Lon: function (e, t) {
            return y(0, 0, e, t)
        }, M_Lon: function (e, t) {
            return b(0, e, t)
        }, E_v: function (e) {
            var t = 628.307585 * e;
            return 628.332 + 21 * Math.sin(1.527 + t) + .44 * Math.sin(1.48 + t * 2) + .129 * Math.sin(5.82 + t) * e + 55e-5 * Math.sin(4.21 + t) * e * e
        }, M_v: function (e) {
            var t = 8399.71 - 914 * Math.sin(.7848 + 8328.691425 * e + 1523e-7 * e * e);
            return t -= 179 * Math.sin(2.543 + 15542.7543 * e) + 160 * Math.sin(.1874 + 7214.0629 * e) + 62 * Math.sin(3.14 + 16657.3828 * e) + 34 * Math.sin(4.827 + 16866.9323 * e) + 22 * Math.sin(4.9 + 23871.4457 * e) + 12 * Math.sin(2.59 + 14914.4523 * e) + 7 * Math.sin(.23 + 6585.7609 * e) + 5 * Math.sin(.9 + 25195.624 * e) + 5 * Math.sin(2.32 - 7700.3895 * e) + 5 * Math.sin(3.88 + 8956.9934 * e) + 5 * Math.sin(.49 + 7771.3771 * e), t
        }, MS_aLon: function (e, t, n) {
            return this.M_Lon(e, t) + p(e) - (this.E_Lon(e, n) + h(e) + Math.PI)
        }, S_aLon: function (e, t) {
            return this.E_Lon(e, t) + d(e) + h(e) + Math.PI
        }, MS_aLon_t: function (e) {
            var t, n = 7771.37714500204;
            return t = (e + 1.08472) / n, t += (e - this.MS_aLon(t, 3, 3)) / n, n = this.M_v(t) - this.E_v(t), t += (e - this.MS_aLon(t, 20, 10)) / n, t += (e - this.MS_aLon(t, -1, 60)) / n, t
        }, S_aLon_t: function (e) {
            var t, n = 628.3319653318;
            return t = (e - 1.75347 - Math.PI) / n, n = this.E_v(t), t += (e - this.S_aLon(t, 10)) / n, n = this.E_v(t), t += (e - this.S_aLon(t, -1)) / n, t
        }, MS_aLon_t2: function (e) {
            var t, n = 7771.37714500204;
            t = (e + 1.08472) / n;
            var r, i = t * t;
            return t -= (-0.00003309 * i + .10976 * Math.cos(.784758 + 8328.6914246 * t + 152292e-9 * i) + .02224 * Math.cos(.1874 + 7214.0628654 * t - 21848e-8 * i) - .03342 * Math.cos(4.669257 + 628.307585 * t)) / n, r = this.M_Lon(t, 20) - (4.8950632 + 628.3319653318 * t + 5297e-9 * t * t + .0334166 * Math.cos(4.669257 + 628.307585 * t) + 2061e-7 * Math.cos(2.67823 + 628.307585 * t) * t + 349e-6 * Math.cos(4.6261 + 1256.61517 * t) - 20.5 / f), n = 7771.38 - 914 * Math.sin(.7848 + 8328.691425 * t + 1523e-7 * t * t) - 179 * Math.sin(2.543 + 15542.7543 * t) - 160 * Math.sin(.1874 + 7214.0629 * t), t += (e - r) / n, t
        }, S_aLon_t2: function (e) {
            var t, n, r = 628.3319653318;
            return t = (e - 1.75347 - Math.PI) / r, t -= (5297e-9 * t * t + .0334166 * Math.cos(4.669257 + 628.307585 * t) + 2061e-7 * Math.cos(2.67823 + 628.307585 * t) * t) / r, t += (e - this.E_Lon(t, 8) - Math.PI + (20.5 + 17.2 * Math.sin(2.1824 - 33.75705 * t)) / f) / r, t
        }
    };
    window.OB.RiLi.Lunar = n, window.OB.RiLi.lunar = t;
    var S = window.OB.RiLi.dateAllFestival, x = {};
    x.w = {}, $.each(S, function (e, t) {
        var n = t.match(/^\w\:(.*)/);
        if (n !== null) {
            var r = n[1].split("|");
            key = r[0], value = r[1], x.w[key] = value
        } else {
            var r = t.split("|");
            key = r[0], value = r[1], x[key] = value
        }
    }), n.prototype.festival = function () {
        var e = this.oDate.getFullYear(), t = this.oDate.getMonth() + 1, n = this.oDate.getDate(), r = T(t) + T(n), i = this.oDate.getDay(), s = Math.ceil(n / 7), o = T(t) + s + i, u = this.lMonth, a = this.lDate, f = u + "\u6708" + a, l = [];
        this.lNextMonth == "\u6b63" && a == (this.isBigMonth ? "\u4e09\u5341" : "\u5eff\u4e5d") && l.push("v,\u9664\u5915"), x.w[o] && (l = l.concat(x.w[o].split("|"))), x[f] && (l = l.concat(x[f].split("|"))), x[r] && (l = l.concat(x[r].split("|")));
        for (var c, h = l.length - 1; h > -1; h--) {
            c = l[h].split(",");
            if (c[2] && e < c[2] - 0) {
                l.splice(h, 1);
                continue
            }
            l[h] = {type: c[0], desc: c[1]}
        }
        return l.sort(function (e, t) {
            return t.type.charCodeAt(0) - e.type.charCodeAt(0)
        })
    }
})(jQuery);
(function () {
    var JSON;
    JSON || (JSON = {}), function () {
        function f(e) {
            return e < 10 ? "0" + e : e
        }

        function quote(e) {
            return escapable.lastIndex = 0, escapable.test(e) ? '"' + e.replace(escapable, function (e) {
                var t = meta[e];
                return typeof t == "string" ? t : "\\u" + ("0000" + e.charCodeAt(0).toString(16)).slice(-4)
            }) + '"' : '"' + e + '"'
        }

        function str(e, t) {
            var n, r, i, s, o = gap, u, a = t[e];
            a && typeof a == "object" && typeof a.toJSON == "function" && (a = a.toJSON(e)), typeof rep == "function" && (a = rep.call(t, e, a));
            switch (typeof a) {
                case"string":
                    return quote(a);
                case"number":
                    return isFinite(a) ? String(a) : "null";
                case"boolean":
                case"null":
                    return String(a);
                case"object":
                    if (!a)return "null";
                    gap += indent, u = [];
                    if (Object.prototype.toString.apply(a) === "[object Array]") {
                        s = a.length;
                        for (n = 0; n < s; n += 1)u[n] = str(n, a) || "null";
                        return i = u.length === 0 ? "[]" : gap ? "[\n" + gap + u.join(",\n" + gap) + "\n" + o + "]" : "[" + u.join(",") + "]", gap = o, i
                    }
                    if (rep && typeof rep == "object") {
                        s = rep.length;
                        for (n = 0; n < s; n += 1)typeof rep[n] == "string" && (r = rep[n], i = str(r, a), i && u.push(quote(r) + (gap ? ": " : ":") + i))
                    } else for (r in a)Object.prototype.hasOwnProperty.call(a, r) && (i = str(r, a), i && u.push(quote(r) + (gap ? ": " : ":") + i));
                    return i = u.length === 0 ? "{}" : gap ? "{\n" + gap + u.join(",\n" + gap) + "\n" + o + "}" : "{" + u.join(",") + "}", gap = o, i
            }
        }

        "use strict", typeof Date.prototype.toJSON != "function" && (Date.prototype.toJSON = function (e) {
            return isFinite(this.valueOf()) ? this.getUTCFullYear() + "-" + f(this.getUTCMonth() + 1) + "-" + f(this.getUTCDate()) + "T" + f(this.getUTCHours()) + ":" + f(this.getUTCMinutes()) + ":" + f(this.getUTCSeconds()) + "Z" : null
        }, String.prototype.toJSON = Number.prototype.toJSON = Boolean.prototype.toJSON = function (e) {
            return this.valueOf()
        });
        var cx = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, escapable = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, gap, indent, meta = {
            "\b": "\\b",
            "	": "\\t",
            "\n": "\\n",
            "\f": "\\f",
            "\r": "\\r",
            '"': '\\"',
            "\\": "\\\\"
        }, rep;
        typeof JSON.stringify != "function" && (JSON.stringify = function (e, t, n) {
            var r;
            gap = "", indent = "";
            if (typeof n == "number")for (r = 0; r < n; r += 1)indent += " "; else typeof n == "string" && (indent = n);
            rep = t;
            if (!t || typeof t == "function" || typeof t == "object" && typeof t.length == "number")return str("", {"": e});
            throw new Error("JSON.stringify")
        }), typeof JSON.parse != "function" && (JSON.parse = function (text, reviver) {
            function walk(e, t) {
                var n, r, i = e[t];
                if (i && typeof i == "object")for (n in i)Object.prototype.hasOwnProperty.call(i, n) && (r = walk(i, n), r !== undefined ? i[n] = r : delete i[n]);
                return reviver.call(e, t, i)
            }

            var j;
            text = String(text), cx.lastIndex = 0, cx.test(text) && (text = text.replace(cx, function (e) {
                return "\\u" + ("0000" + e.charCodeAt(0).toString(16)).slice(-4)
            }));
            if (/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, "")))return j = eval("(" + text + ")"), typeof reviver == "function" ? walk({"": j}, "") : j;
            throw new SyntaxError("JSON.parse")
        })
    }(), function () {
        var e = {}, t = "ns";
        e.localStorage = {
            test: function () {
                try {
                    return window.localStorage ? !0 : !1
                } catch (e) {
                    return !1
                }
            }, methods: {
                init: function (e) {
                }, set: function (e, t, n) {
                    try {
                        localStorage.setItem(e + t, n)
                    } catch (r) {
                        throw r
                    }
                }, get: function (e, t) {
                    return localStorage.getItem(e + t)
                }, remove: function (e, t) {
                    localStorage.removeItem(e + t)
                }, clear: function (e) {
                    if (!e)localStorage.clear(); else for (var t = localStorage.length - 1, n; n = localStorage.key(t--);)n && n.indexOf(e) === 0 && localStorage.removeItem(n)
                }
            }
        }, e.userData = {
            test: function () {
                try {
                    return window.ActiveXObject && document.documentElement.addBehavior ? !0 : !1
                } catch (e) {
                    return !1
                }
            }, methods: {
                _owners: {}, init: function (e) {
                    if (!this._owners[e]) {
                        if (document.getElementById(e))this._owners[e] = document.getElementById(e); else {
                            var t = document.createElement("script"), n = document.head || document.getElementsByTagName("head")[0] || document.documentElement;
                            t.id = e, t.style.display = "none", t.addBehavior("#default#userdata"), n.insertBefore(t, n.firstChild), this._owners[e] = t
                        }
                        try {
                            this._owners[e].load(e)
                        } catch (r) {
                        }
                        var i = this;
                        window.attachEvent("onunload", function () {
                            i._owners[e] = null
                        })
                    }
                }, set: function (e, t, n) {
                    if (this._owners[e])try {
                        this._owners[e].setAttribute(t, n), this._owners[e].save(e)
                    } catch (r) {
                        throw r
                    }
                }, get: function (e, t) {
                    return this._owners[e] ? (this._owners[e].load(e), this._owners[e].getAttribute(t) || "") : ""
                }, remove: function (e, t) {
                    this._owners[e] && (this._owners[e].removeAttribute(t), this._owners[e].save(e))
                }, clear: function (e) {
                    if (this._owners[e]) {
                        var t = this._owners[e].XMLDocument.documentElement.attributes;
                        this._owners[e].load(e);
                        for (var n = 0, r; r = t[n]; n++)this._owners[e].removeAttribute(r.name);
                        this._owners[e].save(e)
                    }
                }
            }
        };
        var n = function () {
            return e.localStorage.test() ? e.localStorage.methods : e.userData.test() ? e.userData.methods : {
                init: function () {
                }, get: function () {
                }, set: function () {
                }, remove: function () {
                }, clear: function () {
                }
            }
        }(), r = {}, i = function (e, r) {
            this._ns = t + "_" + e + "_", this._inited = !1, this.storeSvc = r ? {
                init: function (e) {
                    r[e] = {}
                }, get: function (e, t) {
                    return r[e][t]
                }, set: function (e, t, n) {
                    r[e][t] = n
                }, remove: function (e, t) {
                    delete r[e][t]
                }, clear: function (e) {
                    delete r[e]
                }
            } : n, this._obj = r, this.storeSvc && !this._inited && this.storeSvc.init(this._ns)
        };
        i.serialize = function (e) {
            return JSON.stringify(e)
        }, i.unserialize = function (e) {
            return JSON.parse(e)
        }, i.prototype = {
            set: function (e, t) {
                try {
                    return this.storeSvc.set(this._ns, e, i.serialize(t)), !0
                } catch (n) {
                    return !1
                }
            }, get: function (e) {
                try {
                    return i.unserialize(this.storeSvc.get(this._ns, e))
                } catch (t) {
                }
            }, remove: function (e) {
                try {
                    this.storeSvc.remove(this._ns, e)
                } catch (t) {
                }
            }, clear: function () {
                try {
                    this.storeSvc.clear(this._ns)
                } catch (e) {
                }
            }
        }, i.ins = function (e, t) {
            if (!r[e] || r[e]._obj != t)r[e] = new i(e, t);
            return r[e]
        }, window.OB.RiLi.CacheSVC = i
    }()
})();
(function () {
    function t(t, n, r) {
        this.storage = e.ins(t, r), this.signature = n, this.lastUpdate = null, this.dataFormatter = {
            getter: null,
            setter: null
        }
    }

    var e = window.OB.RiLi.CacheSVC;
    t.clear = function (t) {
        e.ins(t).clear()
    }, t.prototype = {
        setFormatter: function (e, t) {
            this.dataFormatter = {setter: e, getter: t}
        }, set: function (e, t, n) {
            this.dataFormatter && this.dataFormatter.setter && (t = this.dataFormatter.setter(t)), this.lastUpdate = (new Date).getTime();
            var r = {value: t, signature: this.signature, lastUpdate: this.lastUpdate};
            n && (r.expires = n), this.storage.set(e, r)
        }, get: function (e, t) {
            var n = this.storage.get(e);
            if (n && n.signature === this.signature && (t || !n.expires || (new Date).getTime() < n.expires))return n = n.value, this.dataFormatter && this.dataFormatter.getter && (n = this.dataFormatter.getter(n)), n
        }, remove: function (e) {
            this.storage.remove(e)
        }, clear: function () {
            this.storage.clear()
        }, getUpdatedTime: function (e) {
            var t = this.storage.get(e);
            return t && t.lastUpdate - 0
        }, getExpires: function (e) {
            var t = this.storage.get(e);
            return t && t.expires
        }
    }, window.OB.RiLi.AppData = t
})();
(function () {
    function a(n) {
        o && clearInterval(o), u(e, function (e) {
            e || (e = (new Date).getTime()), r = (new Date(e)).getTime(), s = i = (new Date).getTime(), f(n), o = setInterval(function () {
                f(null)
            }, t)
        })
    }

    function f(e) {
        var o = (new Date).getTime();
        !s || Math.abs(o - s) > t * 3 ? a(e) : (s = o, Math.abs(r - i) > n && (o = r - i + o)), e && e(new Date(o))
    }

    $.ajaxSetup({cache: !0});
    var e = "http://hao.360.cn/time.php", t = 6e4, n = 3e5;
    location.protocol == "https:" && (e = "https://open.onebox.haosou.com/api/proxy?__url__=" + encodeURIComponent(e));
    var r = null, i = null, s = null, o = null, u = function (e, n) {
        window.callback = n, e = e + "?t=" + Math.floor(+(new Date) / t), $.getScript(e)
    }, l = {getTime: f};
    window.OB.RiLi.TimeSVC = l
})();
(function () {
    var e = window.OB.RiLi, t = e.useLunarTicketDay, n = e.lunar, r = e.dateHuochepiao, i = [], s = {}, o = function (e) {
        return e < 10 ? "0" + e + "" : e + ""
    }, u = "<span class='mh-ticket {cls}'>\u7968{monthday}</span>", a = "<span class='red'>\u53ef\u9884\u8ba2{month}\u6708{day}\u65e5\u8f66\u7968</span>", f = "<em class='mh-lunar-ticket'>\u519c\u5386{l}</em>", l = function (e, t) {
        var n = e.substr(0, 4), r = e.substr(4, 2), i = e.substr(6, 2), s = new Date([n, r, i].join("/"));
        t != 0 && (s = t < 0 ? new Date(+s - 864e5) : new Date(+s + 864e5));
        var u = o(s.getMonth() + 1), a = o(s.getDate());
        return [s.getFullYear(), u, a].join("/")
    };
    for (var c = 0; c < r.length; ++c) {
        var h = r[c];
        lineInfo = h.split("||");
        if (/^-\d{8}$/.test(lineInfo[0])) {
            i.push({date: l(lineInfo[0].substr(1, 8), -1), delta: lineInfo[1], cmd: "<"});
            continue
        }
        if (/^\d{8}$/.test(lineInfo[0])) {
            i.push({date: l(lineInfo[0], 0), delta: lineInfo[1], cmd: "="});
            continue
        }
        if (/^\+\d{8}$/.test(lineInfo[0])) {
            i.push({date: l(lineInfo[0].substr(1, 8), 1), delta: lineInfo[1], cmd: ">"});
            continue
        }
        if (/^c\d{8}-\d{8}$/.test(lineInfo[0])) {
            var p = lineInfo[0].replace("c", "").split("-");
            s.min = l(p[0], 0), s.max = l(p[1], 0), s.color = lineInfo[1]
        }
    }
    e.Huochepiao = {
        getHuochepiaoDay: function (e, t, n) {
            var r, u = {}, a = o(t), f = o(n), l = [e, a, f].join("/"), c;
            for (var h = 0; h < i.length; ++h) {
                r = i[h];
                if (r.cmd == "<" && l <= r.date || r.cmd == "=" && l == r.date || r.cmd == ">" && l >= r.date) {
                    c = +(new Date([e, t, n].join("/"))) + (r.delta - 1) * 864e5, u.piaodate = new Date(c);
                    break
                }
            }
            return s.min <= l && s.max >= l && (u.color = s.color), u
        }, getHuochepiaoDayHtml: function (n, r, i) {
            var s = this.getHuochepiaoDay(n, r, i), a = s["color"] == "red" ? "mh-hotticket" : "", f = o(s.piaodate.getMonth() + 1), l = o(s.piaodate.getDate()), c = [n, o(r), o(i)].join("/"), h = [e.today.getFullYear(), o(e.today.getMonth() + 1), o(e.today.getDate())].join("/"), p = s.piaodate.getFullYear();
            if (c >= h) {
                var d = [f, l].join(""), v = t[p] && t[p][d] ? " " + t[p][d] : f + "." + l;
                return $.format(u, {cls: a, monthday: v})
            }
            return ""
        }, getHuochepiaoDayGongli: function (e, t, n) {
            var r = this.getHuochepiaoDay(e, t, n);
            return $.format(a, {month: o(r.piaodate.getMonth() + 1), day: o(r.piaodate.getDate())})
        }, getHuochepiaoDayGongliProxy: function (e, t, n) {
            var r = this.getHuochepiaoDay(e, t, n), i = new Date(r.piaodate - 1728e5);
            return $.format(a, {month: o(i.getMonth() + 1), day: o(i.getDate())})
        }, getHuochepiaoDayNongli: function (e, t, r) {
            var i = this.getHuochepiaoDay(e, t, r), s = n(i.piaodate), o = s.lMonth.replace("\u5341\u4e8c", "\u814a") + "\u6708" + s.lDate;
            return $.format(f, {l: o})
        }, getHuochepiaoDayNongliProxy: function (e, t, r) {
            var i = this.getHuochepiaoDay(e, t, r), s = new Date(i.piaodate - 1728e5), o = n(s), u = o.lMonth + "\u6708" + o.lDate;
            return $.format(f, {l: u})
        }
    }
})();
(function () {
    $.widget("rili.fakeSelect", {
        options: {data: [], onchange: $.noop, value: "", circle: !1}, _create: function () {
            var e = this, t = $(this.element), n = this.options;
            this.name = n.name, this.prev = t.find(".mh-prev"), this.next = t.find(".mh-next"), this.cont = t.find("div.mh-control"), this.header = t.find(".mh-field"), this.list = t.find(".mh-list"), this.cont.find(".mh-holiday").length > 0 ? this.list.html($.format('<li val="{value}" is_sel={is_sel}>{text}</li>', n.data)) : this.list.html($.format('<li val="{value}">{text}</li>', n.data)), this.opts = this.list.find("li"), this.cont.click(function () {
                e.list.toggle();
                if (e.list.is(":visible")) {
                    var t = e.header.attr("val") || "", n = e.opts.removeClass("mh-on").filter('[val="' + t + '"]').addClass("mh-on");
                    n.size() && e.list.scrollTop(n.prop("offsetTop") - 42)
                }
            }), this.opts.mouseenter(function () {
                e.opts.removeClass("mh-on"), $(this).addClass("mh-on")
            }).click(function (t) {
                e.list.hide();
                var r = $(this).addClass("mh-on"), i = r.attr("val"), s = r.text(), o = e.header.attr("val");
                o != i && (e.header.html(s).attr("val", i), i && n.onchange.call(e, i, o))
            }), this.prev.size() && this.prev.add(this.next).click(function (t) {
                t.preventDefault();
                var n = $(this), r = e.header.attr("val") || "", i = e.opts.filter('[val="' + r + '"]');
                i.size() && (i = i[n.attr("action")](), !i.size() && $(this).siblings(".mh-control").find(".mh-field").hasClass("mh-month") && ("prev" == n.attr("action") ? (i = $(e.opts[e.opts.length - 1]), $(".mh-control .mh-year").parent(".mh-control").siblings(".mh-prev").triggerHandler("click")) : (i = $(e.opts[0]), $(".mh-control .mh-year").parent(".mh-control").siblings(".mh-next").triggerHandler("click"))), i.size() && i.triggerHandler("click"))
            });
            var r = e.opts.filter('[val="' + n.value + '"]');
            e.header.html(r.text()).attr("val", r.attr("val")), this.cont.find(".mh-holiday").length > 0 && (r = e.opts.filter('[is_sel="true"]'), r.length && e.header.html(r.text()).attr("val", r.attr("val"))), $("body").click(function (t) {
                e.cont.find(t.target).size() || e.list.hide()
            })
        }, hasValue: function (e) {
            var t = this, n = $(this.element), r = this.options, i = t.opts.filter('[val="' + e + '"]');
            return i.size() ? i : null
        }, setValue: function (e) {
            var t = this, n = $(this.element), r = this.options, i = this.hasValue(e);
            if (i)this.header.attr("val", e).text(i.text()); else {
                var s = window.OB.RiLi.rootSelector || "";
                this.header.attr("val", "").text($(s + "#mh-date-y").html() + "\u5e74\u5047\u65e5\u5b89\u6392")
            }
        }, getValue: function () {
            return this.header.attr("val")
        }, triggerChange: function () {
            this.options.onchange.call(this, this.header.attr("val"), "")
        }
    })
})();
(function () {
    $.widget("rili.speCalendar", {
        options: {}, _create: function () {
            var e = this.element;
            e.delegate("li.mh-spe-item", "mouseenter", function () {
                var e = $(this), t = e.find(".mh-spe-cover");
                t.show()
            }), e.delegate("li.mh-spe-item", "mouseleave", function () {
                var e = $(this), t = e.find(".mh-spe-cover");
                t.hide()
            })
        }, getTpl: function (e) {
            var t = this, n = e[0], r = e[1], i = e[2];
            return this.tpl = [], this.tpl.push('<li class="mh-spe-item {monthClass}" date="{date}"><span class="mh-border"></span>'), this.tpl.push('<div class="mh-solar">{solar}</div><span class="mh-lunar">{lunar}</span>'), this.tpl.push('<span class="mh-spe-des">{speDes}</span>'), this.tpl.push('<div class="mh-spe-cover"><a href="{speUrl}"><img src="{speImg}"/><span class="mh-spe-cover-des">{speDes}</span></a></div>'), this.tpl.push("</li>"), this.tpl = this.tpl.join(""), this.tpl = $.format(t.tpl, {
                speDes: n,
                speUrl: r,
                speImg: i
            }), this.tpl
        }
    })
})();
(function () {
    var e = window.OB.RiLi, t = e.msg_config, n = e.Huochepiao, r = e.mediator, i = e.lunar, s = e.Lunar, o = e.rootSelector || "", u = $.trim($(o + "#mh-date-y").html()), a = e.dateFestival, f = [], l, c, l, c;
    $.route = function (e, t) {
        e = e || {};
        var n;
        (l || (l = /([\d\w_]+)/g)).lastIndex = 0;
        while ((n = l.exec(t)) !== null) {
            e = e[n[0]];
            if (e == undefined)break
        }
        return e
    }, $.format = function () {
        var e = $.makeArray(arguments), t = String(e.shift() || ""), n = [], r = e[0];
        return e = $.isArray(r) ? r : typeof r == "object" ? e : [e], $.each(e, function (e, r) {
            n.push(t.replace(c || (c = /\{([\d\w\.]+)\}/g), function (t, n, i) {
                return i = n === "INDEX" ? e : n.indexOf(".") < 0 ? r[n] : $.route(r, n), i === undefined ? t : $.isFunction(i) ? i.call(r, n) : i
            }))
        }), n.join("")
    };
    var h;
    $.padWithZero = function (e) {
        return e.replace(h || (h = /(^|\D)(\d)(?=$|\D)/g), "$10$2")
    }, $.each(a, function (e, t) {
        var n = t.split("||");
        n[0] == "20140201" && (n[0] = "20140131"), f.push(n[0])
    }), $.widget("rili.webCalendar", {
        options: {onselect: $.noop}, _create: function () {
            var e = this, t = $(this.element);
            this.panel = t.find("ol.mh-dates-bd"), this.tmplDate = '<li class="{monthClass}" date="{date}" data-md=\'{"p":"day-box"}\'><span class="mh-border"></span><div class="mh-solar">{solar}</div><span class="mh-lunar" {lunarTitle} >{lunar}</span>{goupiao}</li>', this.initTime(this.options.time), this.handleClick(), this.initDatePicker()
        }, _showCurrentTime: function () {
            var t = this, n = $(this.element), r = this.options;
            this.timeContainer = n.find(".mh-time-monitor");
            var i = function () {
                var n = new Date;
                if (e.today) {
                    var r = new Date(e.today.getTime() + (n.getTime() - t.now.getTime()));
                    t.timeContainer.html($.padWithZero($.format("{getHours}:{getMinutes}:{getSeconds}", r)))
                }
            };
            clearInterval(this.handler), i(), this.handler = setInterval(function () {
                i()
            }, 1e3)
        }, initTime: function (n) {
            var s = this, o = n ? n : new Date, u = o.getFullYear(), a = o.getMonth() + 1;
            this.now = new Date, this.today = e.today, this.initCalendar(u, a), this.options.onselect.call(s, o, i(o)), this._showCurrentTime(), r.publish(t.type.ctc, {data: o})
        }, initCalendar: function (s, o, a) {
            var l = this, c = $(this.element), h = this.options, p = new Date(s, o - 1, a || 1), d = new window.OB.RiLi.Calendar(p), v = d.getCalendarFirstDate(), m = this.today;
            this.year = p.getFullYear(), this.month = p.getMonth() + 1, e.action == "goupiao" && $(".mh-dates").addClass("mh-goupiao-dates");
            var g = {}, y = {}, b = {}, w = e.dateRest;
            $.each(w, function (e, t) {
                g[t] = "mh-rest"
            });
            var E = e.dateWork;
            $.each(E, function (e, t) {
                y[t] = "mh-work"
            });
            var S = new Date(v), x = $.map(new Array(42), function (s, a) {
                var c = S.getFullYear(), h = S.getMonth(), p = S.getDate(), d = S.getDay(), v = i(S), w = [], E = ("0" + (h + 1)).slice(-2) + ("0" + p).slice(-2), x = c + E + "";
                $.inArray(x, f) != -1 && w.push("mh-fes"), h != o - 1 && w.push("mh-cross-month"), (a + 1) % 7 == 0 && w.push("mh-last"), p == m.getDate() && h == m.getMonth() && c == m.getFullYear() && w.push("mh-today"), (d == 0 || d == 6) && w.push("mh-weekend");
                var T = v.festival();
                v.term ? w.push("mh-solar-style") : T.length && w.push("mh-" + T[0].type + "solar-style"), c == u && (g[E] && w.push(g[E], "mh-vacation"), y[E] && w.push(y[E]));
                if (b[u + E]) {
                    r.publish(t.type.hgt, {data: b[u + E]});
                    var N = t.returnValue
                } else var N = l.tmplDate;
                S.setDate(S.getDate() + 1), e.action == "goupiao" ? goupiao = n.getHuochepiaoDayHtml(c, h + 1, p) : goupiao = "";
                var C, k;
                return C = T[0] && T[0].desc.length < 9 && T[0].desc || v.term || v.dateIndex == 0 && v.lMonth + "\u6708" + (v.isBigMonth ? "\u5927" : "\u5c0f") || v.lDate, C.length > 4 ? $.format(N, {
                    monthClass: w.join(" "),
                    solar: p,
                    lunar: C,
                    date: [c, h + 1, p].join("/"),
                    goupiao: goupiao,
                    lunarTitle: "title='" + C + "'"
                }) : $.format(N, {
                    monthClass: w.join(" "),
                    solar: p,
                    lunar: C,
                    date: [c, h + 1, p].join("/"),
                    goupiao: goupiao,
                    lunarTitle: ""
                })
            });
            this.panel.html(x)
        }, handleClick: function () {
            var n = this, s = $(this.element), o = this.options;
            $(n.panel).delegate("li", "click", function () {
                n.panel.find("li.mh-on").removeClass("mh-on"), n.panel.find("li.reston").removeClass("reston").addClass("mh-rest"), n.panel.find("li.workon").removeClass("workon").addClass("mh-work");
                var s = $(this).addClass("mh-on"), u = s.attr("date"), a = new Date(u), f = a.getFullYear(), l = a.getMonth() + 1, c = null;
                r.publish(t.type.fhv, {
                    data: f,
                    from: n.dltYear
                }), c = t.returnValue, l == n.month && f == n.year || !c ? (o.onselect.call(n, a, i(a)), r.publish(t.type.ctc, {data: a}), typeof e.CallBack.holiday == "function" && e.CallBack.holiday($.trim(n.panel.find('li[date="' + u + '"]').find(".mh-lunar").html()), n.year)) : (r.publish(t.type.fsv, {
                    data: f,
                    from: n.dltYear
                }), r.publish(t.type.fsv, {data: l, from: n.dltMonth}), r.publish(t.type.ftc, {
                    data: {},
                    from: n.dltMonth
                }), n.panel.find('li[date="' + u + '"]').click())
            })
        }, initDatePicker: function () {
            var n = this, i = $(this.element), s = this.options, o = function (e) {
                var i, s;
                this.name == "year" ? (i = e, r.publish(t.type.fgv, {
                    data: {},
                    from: n.dltMonth
                }), s = t.returnValue, e += ("0" + s).slice(-2)) : (r.publish(t.type.fgv, {
                    data: {},
                    from: n.dltYear
                }), i = t.returnValue, s = e, e = i + ("0" + s).slice(-2)), n.initCalendar(i, s), r.publish(t.type.fsv, {
                    data: e,
                    from: n.dltFestival
                })
            }, f = function (i) {
                var s = i.slice(0, 4) - 0, o = i.slice(4, 6) - 0, u = i.slice(-2) - 0;
                n.initCalendar(s, o, u);
                var f = a, l = [], c = s < 10 ? "0" + s + "" : s + "", h = o < 10 ? "0" + o + "" : o + "", p = u < 10 ? "0" + u + "" : u + "", d = "";
                r.publish(t.type.fsv, {data: s, from: n.dltYear}), r.publish(t.type.fsv, {data: o, from: n.dltMonth});
                for (var v = 0; v < f.length; ++v) {
                    l = $.trim(f[v]).split("||");
                    if (l[0].slice(0, 8) == c + h + p) {
                        d = s + "/" + o + "/" + (l[0].slice(-2) - 0) + "", d != "2014/2/1" ? $("li[date='" + d + "']").click() : typeof e.CallBack.holiday == "function" && e.CallBack.holiday("\u6625\u8282", s);
                        break
                    }
                }
            };
            this.dltYear = i.find("div.mh-year-bar"), this.dltMonth = i.find("div.mh-mouth-bar"), this.dltFestival = i.find("div.mh-holiday-bar");
            var l = [];
            l.push({value: "", text: u + "\u5e74\u5047\u65e5\u5b89\u6392"});
            var c = e.needDay || e.today, h = c.getMonth() + 1, p = c.getDate();
            h = h > 9 ? h : "0" + h + "", $.each(a, function (e, t) {
                var n = {}, r = t.split("||"), i = r[0].substr(0, 8), s = r[1];
                n.value = i, n.text = s, i.substr(0, 8) == c.getFullYear() + h + p ? n.is_sel = !0 : n.is_sel = !1, l.push(n)
            }), setTimeout(function () {
                var i = e.needDay || e.today;
                r.publish(t.type.fin, {
                    data: {
                        name: "year",
                        value: i.getFullYear(),
                        onchange: o,
                        data: $.map(new Array(200), function (e, t) {
                            var n = 1901 + t;
                            return {value: n, text: n + "\u5e74"}
                        })
                    }, from: n.dltYear
                })
            }, 200), setTimeout(function () {
                r.publish(t.type.fin, {
                    data: {
                        name: "month",
                        value: c.getMonth() + 1,
                        onchange: o,
                        circle: !0,
                        data: $.map(new Array(12), function (e, t) {
                            var n = t + 1;
                            return {value: n, text: n + "\u6708"}
                        })
                    }, from: n.dltMonth
                })
            }, 250), setTimeout(function () {
                r.publish(t.type.fin, {data: {name: "festival", onchange: f, data: l}, from: n.dltFestival})
            }, 300), this.btnToday = i.find(".mh-btn-today").click(function (e) {
                e.preventDefault(), r.publish(t.type.fsv, {
                    data: n.today.getFullYear(),
                    from: n.dltYear
                }), r.publish(t.type.fsv, {
                    data: n.today.getMonth() + 1,
                    from: n.dltMonth
                }), r.publish(t.type.ftc, {data: {}, from: n.dltMonth}), n.panel.find("li.mh-today").click()
            })
        }
    })
})();
(function () {
    var e = {
        getAstroByDate: function (e, t) {
            var n = "\u9b54\u7faf\u6c34\u74f6\u53cc\u9c7c\u7261\u7f8a\u91d1\u725b\u53cc\u5b50\u5de8\u87f9\u72ee\u5b50\u5904\u5973\u5929\u79e4\u5929\u874e\u5c04\u624b\u9b54\u7faf", r = [20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22];
            return n.substr(e * 2 - (t < r[e - 1] ? 2 : 0), 2) + "\u5ea7"
        }
    }, t = window.OB.RiLi.Huochepiao;
    $.widget("rili.dayDetail", {
        options: {}, _create: function () {
            var e = this, t = $(this.element), n = this.options;
            this.tmpl = [], this.tmpl.push('<div class="mh-dates-bar">'), this.tmpl.push('<span class="mh-date">{year}-{padmonth}-{paddate}</span>'), this.tmpl.push('<span class="mh-weekday">{week}</span>'), this.tmpl.push("</div>"), this.tmpl.push('<div class="mh-date-show-panel">'), this.tmpl.push("{date}"), this.tmpl.push("</div>"), this.tmpl.push('<div class="mh-desc">'), this.tmpl.push('<div class="mh-lunar">\u519c\u5386{lmonth}\u6708{ldate}</div>'), this.tmpl.push('<div class="mh-lunar-ganzhi">'), this.tmpl.push("{gzyear}\u5e74{gzmonth}\u6708{gzdate}\u65e5"), this.tmpl.push("</div>"), this.tmpl.push('<div class="mh-other-info">'), this.tmpl.push('<span class="mh-animal-year">[<em class="mh-animal">{animal}\u5e74</em>]</span>'), this.tmpl.push('<span class="mh-astro">{astro}</span>'), this.tmpl.push("</div>"), this.tmpl.push('<div class="mh-lunar-term">'), this.tmpl.push("{festival}"), this.tmpl.push("</div>"), this.tmpl.push("</div>"), this.tmpl = this.tmpl.join("")
        }, init: function (n, r) {
            var i = this, s = $(this.element), o = this.options, u = n.getFullYear(), a = n.getMonth() + 1, f = n.getDate(), l = new Date, c = r.festival();
            s.html($.format(this.tmpl, {
                year: u,
                padmonth: ("0" + a).slice(-2),
                paddate: ("0" + f).slice(-2),
                date: f,
                week: "\u661f\u671f" + r.cnDay,
                animal: r.animal,
                animal_index: jQuery.inArray(r.animal, r.db.chineseZodiac),
                istoday: l.getDate() == f && l.getMonth() == n.getMonth() && l.getFullYear() == u ? '<div class="today_icon"></div>' : "",
                lmonth: r.lMonth,
                ldate: r.lDate,
                nofestival: c.length || r.term ? "" : " nofestival",
                festival: c.length && $.trim($.format("{desc} ", c)) || r.term || "",
                gzyear: r.gzYear,
                gzmonth: r.gzMonth,
                gzdate: r.gzDate,
                astro: e.getAstroByDate(("0" + a).slice(-2), f)
            })), window.OB.RiLi.action != "goupiao" ? (this.loadLuckyData(u, a, f), $(".mh-almanac-extra").show(), $(".mh-linktail").show()) : ($(".mh-linktail-goupiao").show(), $(".mh-phone-net .mh-gongli").html(t.getHuochepiaoDayGongli(u, a, f)), $(".mh-proxy .mh-gongli").html(t.getHuochepiaoDayGongliProxy(u, a, f)), $(".mh-phone-net .mh-nongli").html(t.getHuochepiaoDayNongli(u, a, f)), $(".mh-proxy .mh-nongli").html(t.getHuochepiaoDayNongliProxy(u, a, f)), $(".mh-almanac").addClass("mh-almanac-goupiao"), $(".mh-ticket-info").show())
        }, loadLuckyData: function (e, t, n) {
            var r = this, i = $(this.element), s = this.options, o = "d" + ("0" + t).slice(-2) + ("0" + n).slice(-2), u = window.OB.RiLi.HuangLi;
            u && u["y" + e] ? this.fillLuckyData(u["y" + e][o]) : e > 2007 && e < 2021 ? (clearTimeout(window.OB.RiLi.getHandle), window.OB.RiLi.getHandle = setTimeout(function () {
                $.getScript(window.OB.RiLi.hlUrl[e], function () {
                    r.fillLuckyData(window.OB.RiLi.HuangLi["y" + e][o])
                })
            }, 100)) : this.fillLuckyData({y: "", j: ""})
        }, fillLuckyData: function (e) {
            function t(e) {
                var t = [], t = [], n;
                return e.sort(function (e, t) {
                    return e.length - t.length
                }), $.each(e, function (n, r) {
                    var i = "<li>" + r + "</li>", s = "<li class='cl'>" + r + "</li>";
                    r.length > 3 ? t.push(s) : n % 2 == 1 ? t.push(i) : n == e.length - 1 ? t.push(s) : e[n + 1].length > 3 ? t.push(s) : t.push(i);
                    if (t.length > 8)return !1
                }), t.slice(0, 8).join("")
            }

            var n = this, r = $(this.element), i = this.options, s = e.y.replace(/^\.|\.$/g, "").split("."), o = e.j.replace(/^\.|\.$/g, "").split(".");
            $(".mh-suited .mh-st-items").html(t(s)).attr("title", s.join(" ")), $(".mh-tapu .mh-st-items").html(t(o)).attr("title", o.join(" "))
        }
    })
})();
(function () {
    var e = window.OB.RiLi.mediator, t = window.OB.RiLi.msg_config, n = $(".mh-calendar");
    e.subscribe(t.type.fsv, function (e) {
        e.from.fakeSelect("setValue", e.data)
    }), e.subscribe(t.type.ftc, function (e) {
        e.from.fakeSelect("triggerChange")
    }), e.subscribe(t.type.fhv, function (e) {
        t.returnValue = e.from.fakeSelect("hasValue", e.data)
    }), e.subscribe(t.type.fgv, function (e) {
        t.returnValue = e.from.fakeSelect("getValue")
    }), e.subscribe(t.type.fin, function (e) {
        e.from.fakeSelect(e.data)
    }), e.subscribe(t.type.hin, function (e) {
        n.speCalendar()
    }), e.subscribe(t.type.hgt, function (e) {
        t.returnValue = n.speCalendar("getTpl", e.data)
    })
})();
(function () {
    var e = window.OB.RiLi.msg_config, t = window.OB.RiLi.mediator, n = function () {
        var e = {}, t = $("#mh-rili-params").val() || "";
        if (t) {
            var n = t.replace(/^\?/, "").split("&"), r;
            for (var i = 0; i < n.length; ++i)r = n[i].split("="), e[r[0]] = r[1]
        }
        return e
    };
    window.OB.RiLi.Dispatcher = {
        dispatch: function () {
            var r = n();
            switch (r.action) {
                case"query":
                    t.publish(e.type.actionquery, r);
                    break;
                case"goupiao":
                    t.publish(e.type.actiongoupiao, r);
                    break;
                case"festival":
                    t.publish(e.type.actionfestival, r);
                    break;
                default:
                    t.publish(e.type.actiondefault, r)
            }
        }
    }
})();