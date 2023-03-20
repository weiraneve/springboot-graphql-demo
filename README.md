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

json的query模板:`{"query": "{vehicles(count: 1){id,type,modelCode}}"}`


## 依赖调试工具

- 调试工具GraphIQL ${address}/graphiql
- 调试工具Voyager ${address}/voyager
- 调试工具Altair ${address}/altair
- 调试工具Playground ${address}/playground
