$(function() {

	var i;
	//no1开始
	$('.tab li:first').show();
	$('.no1 .list li').click(function(event) {
		$(this).addClass('current').siblings().removeClass('current');
		//tab切换开始
		i=$(this).index()
		$('.no1 .tab>li').eq(i).show().siblings().hide();
	});
	$('.no6 .tab li:first').show();
	$('.no6 .list li').click(function(event) {
		$(this).addClass('current').siblings().removeClass('current');
		//tab切换开始
		i=$(this).index()
		$('.no6 .tab>li').eq(i).show().siblings().hide();
	});
	
	//no2开始
	$('.no2 .tab0>li:first').show();
	$('.no2 .list li').click(function(event) {
		$(this).addClass('current').siblings().removeClass('current');
		i=$(this).index()
		$('.no2 .tab0>li').eq(i).show().siblings().hide();
	});
	//no3开始
	$('.no3 .tab0>li:first').show();
	$('.no3 .list li').click(function(event) {
		$(this).addClass('current').siblings().removeClass('current');
		i=$(this).index();
		$('.no3 .tab0>li').eq(i).show().siblings().hide();
	});
	//no5开始
	$('.no5 .tab0>li:first').show();
	$('.no5 .list li').click(function(event) {
		$(this).addClass('current').siblings().removeClass('current');
		i=$(this).index();
		$('.no5 .tab0>li').eq(i).show().siblings().hide();
	});

// ======================================================

	/*$('.no1 h3 span,.no1 h3 b').click(function(event) {
		$('.no1 .zd').toggle(400);
	});
	$('.no2 h3 span,.no2 h3 b').click(function(event) {
		$('.no2 .zd').toggle(400);
	});
	$('.no3 h3 span,.no3 h3 b').click(function(event) {
		$('.no3 .zd').toggle(400);
	});
	$('.no4 h3 span,.no4 h3 b').click(function(event) {
		$('.no4 .zd').toggle(400);
	});
	$('.no5 h3 span,.no5 h3 b').click(function(event) {
		$('.no5 .zd').toggle(400);
	})*/
});