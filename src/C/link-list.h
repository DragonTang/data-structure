struct node {
  void *data;
  struct node *next;
};

struct link_list {
  int size;
  struct node *virtual_head;
};

struct link_list *init_list();
int get_size(struct link_list *list);
int add(void *data, int index, struct link_list *list);
int add_first(void *data, struct link_list *list);
void show_list(struct link_list *list, int type);
int update(void *data, int index, struct link_list *list);
void * remove_element(int index, struct link_list *list);
void * remove_first_element(struct link_list *list);
void * find(int index, struct link_list *list);
void * find_first_element(struct link_list *list);
int contains(void *data, struct link_list *list, int type);
