#include <stdlib.h>
#include <stdio.h>
#include "./link-list.h"

// link_list -> virtual_head -> 0 -> 1 -> 2 -> 3 -> 4 -> 5
struct link_list *init_list() {
  struct link_list *list = malloc(sizeof(struct link_list));
  list -> size = 0;
  list -> virtual_head = malloc(sizeof(struct node));
  list -> virtual_head -> next = NULL;
  return list;
}

int get_size(struct link_list *list) {
  return list -> size;
}

int add(void *data, int index, struct link_list *list) {
  if (index < 0 || index > list -> size) {
    return -1;
  }

  struct node *pre_next = list -> virtual_head;
  for (int i = 0; i < index; i++)
    pre_next = pre_next -> next;

  struct node *new_node = malloc(sizeof(struct node));
  new_node -> data = data;
  new_node -> next = pre_next -> next;
  pre_next -> next = new_node;
  list -> size++;

  return 1;
}

int add_first(void *data, struct link_list *list) {
  return add(data, 0, list);
}

void show_list(struct link_list *list, int type) {
  printf("head==> ");
  struct node *pre_next = list -> virtual_head;
  for (int i = 0; i < list -> size; i++) {
    pre_next = pre_next -> next;

    if (type == 1)
      printf("%d ", *(int *)pre_next -> data);

    if (type == 2)
      printf("%s ", (char *)pre_next -> data);
    if (i != (list -> size) - 1) {
      printf("-> ");
    }
  }

  printf("tail\n");
}

int update(void *data, int index, struct link_list *list) {

  if (index < 0 || index >= list -> size) {
    return -1;
  }

  struct node *pre_next = list -> virtual_head;

  for (int i = 0; i < index; i++)
    pre_next = pre_next -> next;

  pre_next -> next -> data = data;

  return 1;
}

int remove_element(int index, struct link_list *list) {

  if (index < 0 || index >= list -> size)
    return -1;
  struct node *pre_next = list -> virtual_head;

  for (int i = 0; i < index; i++)
    pre_next = pre_next -> next;
  struct node *tmp_node = pre_next -> next -> next;
  free(pre_next -> next);
  pre_next -> next = tmp_node;
  list -> size--;
  return 1;
}
