# Graph Report - .graphify_root  (2026-11-11)

## Corpus Check
- Corpus is ~2,719 words - fits in a single context window. You may not need a graph.

## Summary
- 233 nodes · 495 edges · 12 communities (7 shown, 5 thin omitted)
- Extraction: 80% EXTRACTED · 20% INFERRED · 0% AMBIGUOUS · INFERRED: 100 edges (avg confidence: 0.85)
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- Adminmenuservlet
- Httpservletrequest Httpservletresponse
- Resultset .insert()
- Dao Drivermanager
- .sales() Httpservletrequest
- Connection Java.sql.connection
- Userdao .findbynameandpassword()
- .calcfee() Override
- Arraylist List
- Category.java Category
- Shopdb Setup.sql

## God Nodes (most connected - your core abstractions)
1. `Order` - 33 edges
2. `Product` - 21 edges
3. `ProductDAO` - 18 edges
4. `PageServlet` - 17 edges
5. `OrderDAO` - 13 edges
6. `Sales` - 11 edges
7. `User` - 11 edges
8. `Jdbc` - 9 edges
9. `Category` - 7 edges
10. `DBManager` - 7 edges

## Surprising Connections (you probably didn't know these)
- `CategoryDAO` --inherits--> `Jdbc`  [EXTRACTED]
  src/main/java/dao/CategoryDAO.java → src/main/java/dao/Jdbc.java
- `OrderDAO` --inherits--> `Jdbc`  [EXTRACTED]
  src/main/java/dao/OrderDAO.java → src/main/java/dao/Jdbc.java
- `ProductDAO` --inherits--> `Jdbc`  [EXTRACTED]
  src/main/java/dao/ProductDAO.java → src/main/java/dao/Jdbc.java
- `UserDAO` --inherits--> `Jdbc`  [EXTRACTED]
  src/main/java/dao/UserDAO.java → src/main/java/dao/Jdbc.java
- `LoginServlet` --inherits--> `PageServlet`  [EXTRACTED]
  src/main/java/servlet/LoginServlet.java → src/main/java/servlet/PageServlet.java

## Import Cycles
- None detected.

## Communities (12 total, 5 thin omitted)

### Community 0 - "Adminmenuservlet"
Cohesion: 0.09
Nodes (7): CategoryDAO, AdminMenuServlet, PageServlet, ProductAddServlet, ProductDetailServlet, ShopDetailServlet, ShopServlet

### Community 1 - "Httpservletrequest Httpservletresponse"
Cohesion: 0.10
Nodes (4): ProductDAO, Product, OrderServlet, ProductListServlet

### Community 4 - ".sales() Httpservletrequest"
Cohesion: 0.10
Nodes (4): OrderDAO, Sales, OrderListServlet, SalesServlet

### Community 5 - "Connection Java.sql.connection"
Cohesion: 0.14
Nodes (3): Jdbc, Mapper, ProductDeleteServlet

### Community 6 - "Userdao .findbynameandpassword()"
Cohesion: 0.15
Nodes (3): UserDAO, User, LoginServlet

### Community 7 - ".calcfee() Override"
Cohesion: 0.13
Nodes (3): Delivery, ExpressDelivery, StandardDelivery

### Community 10 - "Shopdb Setup.sql"
Cohesion: 0.70
Nodes (4): category, orders, product, users

## Knowledge Gaps
- **5 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Order` connect `Resultset .insert()` to `Httpservletrequest Httpservletresponse`, `.sales() Httpservletrequest`?**
  _High betweenness centrality (0.178) - this node is a cross-community bridge._
- **Are the 8 inferred relationships involving `ProductDAO` (e.g. with `.doGet()` and `.doPost()`) actually correct?**
  _`ProductDAO` has 8 INFERRED edges - model-reasoned connections that need verification._
- **Should `Adminmenuservlet` be split into smaller, more focused modules?**
  _Cohesion score 0.0915915915915916 - nodes in this community are weakly interconnected._
- **Why does `ProductDAO` connect `Httpservletrequest Httpservletresponse` to `Adminmenuservlet`, `Dao Drivermanager`, `Connection Java.sql.connection`?**
  _High betweenness centrality (0.108) - this node is a cross-community bridge._
- **Should `Httpservletrequest Httpservletresponse` be split into smaller, more focused modules?**
  _Cohesion score 0.09982174688057041 - nodes in this community are weakly interconnected._
- **Why does `OrderDAO` connect `.sales() Httpservletrequest` to `Httpservletrequest Httpservletresponse`, `Resultset .insert()`, `Dao Drivermanager`, `Connection Java.sql.connection`?**
  _High betweenness centrality (0.094) - this node is a cross-community bridge._
- **Should `Resultset .insert()` be split into smaller, more focused modules?**
  _Cohesion score 0.0846774193548387 - nodes in this community are weakly interconnected._