# 简介
用kotlin Springboot 集成的graphql的demo，跑起来后，postman上用`graphql`模式调试。mutation和query分别如下模板。

请求接口为 `127.0.0.1/graphql`

- query graphql

```
query {
  getHeroesNotIsPick
  {
    id, 
    name, 
    line,
    isPick
	}
}

query {
  getLogByTeamId(teamId: 10) 
  {
    id,
    teamId,
    pickGroup,
    time
	}
}

query {
  getTeamByEncryptCode(encryptCode: "asd") 
  {
    id,
    encryptCode,
    pickContent,
    isPicked,
    updateTime
	}
}

```

- mutation graphql

```
mutation {
  clearAllHero
}
```

```
mutation {
  clearOneTeam(id: 9)
}
```

```
mutation {
  clearAllTeam
}
```

- subscription graphql

```
subscription {
  getHeroUpdate(id: 1)
   {
    id, 
    name, 
    line,
    isPick
  }
}
```

- json的query模板:`{"query": "{vehicles(count: 1){id,type,modelCode}}"}`
- graphql server端需要自定义一些属性端时候，可以使用`scalar` 标量，具体有两种方法。一种是直接在yml文件中引入官方的scalar自定义模版，另一种是自己写入一些scalar代码。

## 依赖调试工具

- 调试工具GraphIQL ${address}/graphiql
- 调试工具Voyager ${address}/voyager
- 调试工具Altair ${address}/altair
- 调试工具Playground ${address}/playground
