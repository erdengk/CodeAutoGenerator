package com;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


public class CodeGenerator {



    public static void main( String[] args ) {

        AutoGenerator autoGenerator = new AutoGenerator();

//数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType( DbType.MYSQL );
//如果是远端的数据库 需要把localhost改成ip地址就好了
        dataSourceConfig.setUrl( "jdbc:mysql://localhost:3306/tablename?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" );
        dataSourceConfig.setUsername( "username" );
        dataSourceConfig.setPassword( "password" );
        dataSourceConfig.setDriverName( "com.mysql.cj.jdbc.Driver" );
        autoGenerator.setDataSource( dataSourceConfig );

//全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //这样会拿到工程的绝对路径
        globalConfig.setOutputDir( System.getProperty( "user.dir" ) + "/src/main/java" );
//System.getProperty("user.dir") 就是当前工程的绝对目录
        //创建好工程之后不会自动打开
        globalConfig.setOpen( false );
        //加上这句代码  在生成Service类的时候就不会默认前面有I了
        globalConfig.setServiceName( "%sService" );
        autoGenerator.setGlobalConfig( globalConfig );

//包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent( "com.test" );
        packageConfig.setModuleName( "test" );
        packageConfig.setController( "controller" );
        packageConfig.setService( "service" );
        packageConfig.setServiceImpl( "service.impl" );
        packageConfig.setMapper( "mapper" );
        packageConfig.setEntity( "model" );
        autoGenerator.setPackageInfo( packageConfig );

//配置策略  //生成部份表的设置在这里
        StrategyConfig strategyConfig = new StrategyConfig();
        //只会生成user和table这两个表
        strategyConfig.setInclude( "analyse" );
        //实体类生成之后自动添加lombok注解
        strategyConfig.setEntityLombokModel( true );
        strategyConfig.setNaming( NamingStrategy.underline_to_camel );
        //将数据库中带下划线的转成驼峰规则
        strategyConfig.setColumnNaming( NamingStrategy.underline_to_camel );
        autoGenerator.setStrategy( strategyConfig );
        //配置完之后运行
        autoGenerator.execute();
    }

}
