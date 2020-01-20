#include <stdio.h>
#include "./link-list.h"

int main(int argc, char **argv) {
  struct link_list *num_list = init_list();
  struct link_list *str_list = init_list();

  int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  char *str[] = { "asd", "cdh", "lll", "asdasd", "qwe", "google", "ssh", "ppp", "qqqq" };
  for (int i = 0; i < 9; i++)
    add(num + i, i, num_list);

  for(int i = 0; i < 9; i++) {
    add(str[i], i, str_list);
  }

  show_list(num_list, 1);
  // add(999, 5, list);
  // show_list(list);
  // add_first(321, list);
  // show_list(list);
  // update(97, 0, list);
  // show_list(list);
  // remove_element(4, list);
  show_list(str_list, 2);

  printf("%d\n", *(int*)remove_element(7, num_list));
  printf("%s\n", (char*)remove_element(3, str_list));
  printf("%s\n", (char*)remove_first_element(str_list));

  show_list(str_list, 2);
  printf("%s\n", (char*)find(6, str_list));
  printf("%s\n", (char*)find_first_element(str_list));

  printf("%d\n", contains("google", str_list, 2));
  return 0;
}
